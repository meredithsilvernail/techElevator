package com.techelevator.entity;


import java.util.Objects;

public class Owner extends Person {

    private String address;

    public Owner() {}

    public Owner(String name, String email, String address) {
        super(name, email);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(address, owner.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "address='" + address + '\'' +
                super.toString() + '\'' +
                '}';
    }
}
