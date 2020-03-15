package com.techelevator.bank;

import java.util.List;

public interface CustomerDao {

	public Customer findCustomerById(Long id);

	public void save(Customer customer);

	public List<Customer> getAllCustomers();

	public List<Account> getAllAccounts(Long customerId);

}
