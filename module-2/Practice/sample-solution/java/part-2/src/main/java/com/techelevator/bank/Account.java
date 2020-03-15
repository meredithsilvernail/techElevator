package com.techelevator.bank;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Account {

    private Long id;

    private String name;

    private BigDecimal balance;

    private LocalDate created;

    public Account() {}

    public Account(Long id, String name, BigDecimal balance, LocalDate created) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.created = created;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(name, account.name) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(created, account.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, created);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + NumberFormat.getCurrencyInstance().format(balance) +
                ", created=" + created +
                '}';
    }
}
