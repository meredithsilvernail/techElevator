package com.techelevator.bank;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CustomerJdbcDao implements CustomerDao {

	private JdbcTemplate jdbcTemplate;

	public CustomerJdbcDao(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Customer findCustomerById(Long id) {
		String sqlFindById =
				"SELECT * " +
						"FROM customers " +
						"WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindById, id);
		if(results.next()){
			return mapRowToCustomer(results);
		}
		return null;
	}

	// To insert a date into a prepared statement, wrap the date in `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(Customer customer) {
		String sqlSaveCustomer =
				"INSERT INTO customers " +
						"VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sqlSaveCustomer, customer.getId(), customer.getName(),
				customer.getEmail(), Date.valueOf(customer.getCreated()));
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		String sqlGetAllCustomers =
				"SELECT * " +
				"FROM customers ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCustomers);
		while(results.next()){
			customers.add(mapRowToCustomer(results));
		}
		return customers;
	}

	@Override
	public List<Account> getAllAccounts(Long customerId) {
		List<Account> accounts = new ArrayList<>();
		String sqlGetAllAccounts =
				"SELECT * " +
						"FROM accounts " +
						"WHERE customer_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllAccounts, customerId);
		while(results.next()){
			accounts.add(mapRowToAccount(results));
		}

		return accounts;
	}

	private Customer mapRowToCustomer(SqlRowSet results) {
		return new Customer(
				results.getLong("id"),
				results.getString("name"),
				results.getString("email"),
				results.getTimestamp("created").toLocalDateTime().toLocalDate()
		);
	}

	private long getNextCustomerId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('customers_id_seq')");
		if(nextIdResult.next()){
			return nextIdResult.getLong(1);
		}else{
			throw new RuntimeException("Something went wrong while getting and ID");
		}
	}

	private Account mapRowToAccount(SqlRowSet results) {
		return new Account (
				results.getLong("id"),
				results.getString("name"),
				results.getBigDecimal("balance"),
				results.getTimestamp("created").toLocalDateTime().toLocalDate()
		);
	}

}
