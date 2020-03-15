package com.techelevator.blog;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class PostJdbcDao implements PostDao {

	private JdbcTemplate jdbcTemplate;

	public PostJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// To insert a date into a prepared statement, wrap the date in `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`


	@Override
	public void save(Post newPost) {
		String sqlSavePost =
				"INSERT INTO posts (id, name, body, published, created) " +
						"VALUES (?, ?, ?, ?, ?)";
		newPost.setId(getNextPostId());
		jdbcTemplate.update(sqlSavePost, newPost.getId(), newPost.getName(), newPost.getBody(),
				newPost.isPublished(), Date.valueOf(newPost.getCreated())) ;
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> allPosts = new ArrayList<>();
		String sqlGetAll =
				"SELECT * " +
						"FROM posts";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAll);
		while(results.next()){
			allPosts.add(mapRowToPost(results));
		}

		return allPosts;
	}

	private Post mapRowToPost(SqlRowSet results) {
		Post postRow = new Post();
		postRow.setId(results.getLong("id"));
		postRow.setName(results.getString("name"));
		postRow.setBody(results.getString("body"));
		postRow.setPublished(results.getBoolean("published"));
		postRow.setCreated(results.getDate("created").toLocalDate());
		return postRow;
	}

	private long getNextPostId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('posts_id_seq')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new user");
		}
	}

}
