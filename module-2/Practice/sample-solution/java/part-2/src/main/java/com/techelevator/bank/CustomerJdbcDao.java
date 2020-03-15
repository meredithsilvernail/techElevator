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
		Customer customer = null;
		String sqlFindCustomerById =
				"SELECT * FROM customers WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCustomerById, id);
		if (results.next()) {
			customer = mapRowToCustomer(results);
		}
		return customer;
	}

	// To insert a date into a prepared statement, wrap the date in `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(Customer customer) {
		String sqlInsert =
				"INSERT INTO customers(id, name, email, created)"
						+ " VALUES(?, ?, ?, ?)";
		customer.setId(getNextCustomerId());
		jdbcTemplate.update(sqlInsert,
				customer.getId(), customer.getName(),
				customer.getEmail(), Date.valueOf(customer.getCreated()));
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();

		String sqlGetAllCustomers =
				"SELECT id, name, email, created" +
						" FROM customers";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCustomers);
		while(results.next()) {
			customers.add(mapRowToCustomer(results));
		}
		return customers;
	}

	@Override
	public List<Account> getAllAccounts(Long customerId) {
		List<Account> accounts = new ArrayList<>();

		String sqlGetAllAccounts =
				"SELECT id, name, balance, created" +
						" FROM accounts" +
						" WHERE customer_id=?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(
				sqlGetAllAccounts, customerId);
		while(results.next()) {
			accounts.add(mapRowToAccount(results));
		}
		return accounts;
	}

	private Customer mapRowToCustomer(SqlRowSet results) {
		Customer customer = new Customer();
		customer.setId(results.getLong("id"));
		customer.setName(results.getString("name"));
		customer.setEmail(results.getString("email"));
		customer.setCreated(results.getDate("created").toLocalDate());
		return customer;
	}

	private long getNextCustomerId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('customers_id_seq')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new customer");
		}
	}

	private Account mapRowToAccount(SqlRowSet results) {
		Account account = new Account();
		account.setId(results.getLong("id"));
		account.setName(results.getString("name"));
		account.setBalance( new BigDecimal(results.getDouble("balance")) );
		account.setCreated(results.getDate("created").toLocalDate());
		return account;
	}

}
