package com.techelevator.item;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserJdbcDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserJdbcDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // To insert a date into a prepared statement, wrap the date in
    // `Date.valueOf()`
    // method: `Date.valueOf(myObject.getCreated())`

    @Override
    public void save(User newUser) {
        String sqlSaveUser =
                "INSERT INTO users (id, first_name, last_name, email, role, created) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        newUser.setId(getNextUserId());
        jdbcTemplate.update(sqlSaveUser, newUser.getId(), newUser.getFirstName(), newUser.getLastName(),
                newUser.getEmail(), newUser.getRole(), Date.valueOf(newUser.getCreated()));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sqlGetAll =
                "SELECT * " +
                        "FROM users ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAll);
        while (results.next()) {
            allUsers.add(mapRowToUser(results));
        }
        return allUsers;
    }

    private User mapRowToUser(SqlRowSet results) {
        User userRow = new User();
        userRow.setId(results.getLong("id"));
        userRow.setFirstName(results.getString("first_name"));
        userRow.setLastName(results.getString("last_name"));
        userRow.setEmail(results.getString("email"));
        userRow.setRole(results.getString("role"));
        userRow.setCreated(results.getDate("created").toLocalDate());
        return userRow;
    }

    private long getNextUserId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('users_id_seq')");
        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        } else {
            throw new RuntimeException("Something went wrong while getting an id for the new user");
        }
    }

}
