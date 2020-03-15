package com.techelevator.bank;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Long id;

    private String name;

    private String email;

    private LocalDate created;

    private List<Account> accounts;

    public Customer() {}

    public Customer(Long id, String name, String email, LocalDate created) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created = created;
    }

    public Customer(String name, String email, LocalDate created) {
        this(0L, name, email, created);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(created, customer.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, created);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                '}';
    }
}
