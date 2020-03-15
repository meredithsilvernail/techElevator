package com.techelevator.entity;

import java.util.Objects;

public class Bike extends Vehicle {

    private String pedalType;

    public Bike() {}

    public Bike(Owner owner, String name, int numberOfWheels, String pedalType) {
        super(owner, name, numberOfWheels);
        this.pedalType = pedalType;
    }

    public String getPedalType() {
        return pedalType;
    }

    public void setPedalType(String pedalType) {
        this.pedalType = pedalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bike)) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return Objects.equals(pedalType, bike.pedalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pedalType);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "pedalType='" + pedalType + '\'' +
                super.toString() + '\'' +
                '}';
    }
}
