package com.techelevator;

public class CustomerDao {

    public Customer getCustomer(int id) throws CustomerNotFoundException{
        /*
         * Go to the database and select the customer
         */
        if (id < 0){
            throw new CustomerNotFoundException("Id not found " + id);
        }
        return new Customer(1, "Leah");
    }
}
