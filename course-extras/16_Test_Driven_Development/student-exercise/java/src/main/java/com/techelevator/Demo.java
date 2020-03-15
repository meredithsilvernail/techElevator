package com.techelevator;

public class Demo {

    public static void main(String[] args){
        CustomerDao dao = new CustomerDao();

        try {
            Customer customer = dao.getCustomer(-3);
            System.out.println(customer);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
