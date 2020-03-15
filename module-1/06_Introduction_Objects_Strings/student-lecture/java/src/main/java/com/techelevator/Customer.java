package com.techelevator;

public class Customer {
    private int id;
    private String name;
    private int age;

    @Override
    public boolean equals(Object other){
        Customer otherCustomer = (Customer)other;
        return this.id == otherCustomer.id;
    }

    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
