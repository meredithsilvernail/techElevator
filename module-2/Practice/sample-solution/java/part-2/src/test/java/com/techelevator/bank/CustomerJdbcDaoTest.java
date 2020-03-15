package com.techelevator.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerJdbcDaoTest {

	private static SingleConnectionDataSource dataSource;
	private CustomerJdbcDao dao;
	private JdbcTemplate template;

	private RoundingMode roundingMode = RoundingMode.UP;
	private int scale = 2;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/module-2-practice");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		dao = new CustomerJdbcDao(dataSource);
		template = new JdbcTemplate(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void testFindCustomerById() throws SQLException {
		Customer expected = createMargaretCustomer();
		Customer actual = dao.findCustomerById(1L);
		assertCustomersAreEqual(expected, actual);
	}

	@Test
	public void testGetAllCustomers() throws SQLException {
		Customer expected = dao.findCustomerById(13L);
		List<Customer> list = dao.getAllCustomers();
		assertEquals("List size is incorrect!", 12, list.size());
		assertCustomersAreEqual(createMargaretCustomer(), list.get(0));
		assertCustomersAreEqual(expected, list.get(list.size()-1));
	}

	@Test
	public void testSave1SetId() throws SQLException {
		Customer expected = createNewCustomer();
		dao.save(expected);
		Customer actual = dao.findCustomerById(expected.getId());
		assertEquals("save() failed to return new id", expected.getId(), actual.getId());
	}

	@Test
	public void testSave2CorrectData() throws SQLException {
		Customer expected = createNewCustomer();
		dao.save(expected);
		Customer actual = dao.findCustomerById(expected.getId());
		assertCustomersAreEqual(expected, actual);
	}

	@Test
	public void testGetAllAccounts() throws SQLException {
		Customer customer = createMargaretCustomer();
		List<Account> actual = dao.getAllAccounts(customer.getId());
		assertEquals("List size is incorrect!", 2, actual.size());
		Account[] expected = createMargaretAccounts();
		for (int i=0; i < expected.length; i++){
			assertAccountsAreEqual(expected[i], actual.get(i));
		}
	}

	private Customer createNewCustomer(){
		return new Customer(
				0L,
				"TEST-NAME",
				"TEST-EMAIL",
				LocalDate.ofEpochDay(101));
	}

	private Customer createMargaretCustomer(){
		return new Customer(1L, "MARGARET",
				"margaret@myco.com", LocalDate.of(2018, 9, 16));
	}

	private void assertCustomersAreEqual(Customer expected, Customer actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getEmail(), actual.getEmail());
	}

	private Account[] createMargaretAccounts(){
		return new Account[] {
				new Account(1L, "CHECKING",
						new BigDecimal(100),
						LocalDate.of(2018, 9, 16)),
				new Account(2L, "SAVINGS",
						new BigDecimal(100),
						LocalDate.of(2018, 9, 16))
		};
	}

	private void assertAccountsAreEqual(Account expected, Account actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(
				expected.getBalance().setScale(scale, roundingMode),
				actual.getBalance().setScale(scale, roundingMode));
	}
}
