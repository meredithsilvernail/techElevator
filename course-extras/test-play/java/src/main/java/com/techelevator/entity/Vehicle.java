package com.techelevator.entity;

import java.util.Objects;

public class Vehicle implements Asset {

    private Owner owner;

    private String name;

    private int numberOfWheels;

    public Vehicle(){}

    public Vehicle(Owner owner, String name, int numberOfWheels) {
        this.owner = owner;
        this.name = name;
        this.numberOfWheels = numberOfWheels;
    }

    public Owner getOwner(){
        return owner;
    }

    public void setOwner(Owner owner){
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return numberOfWheels == vehicle.numberOfWheels &&
                Objects.equals(owner, vehicle.owner) &&
                Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name, numberOfWheels);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner=" + owner +
                ", name='" + name + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                '}';
    }
}
