package com.techelevator;

public class Elevator {

    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;


    public Elevator(int totalNumberOfFloors){
        this.numberOfFloors = totalNumberOfFloors;
        this.currentFloor = 1;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor(){
        if(!this.doorOpen){
            this.doorOpen = true;
        }
    }

    public void closeDoor(){
        if(this.doorOpen){
            this.doorOpen = false;
        }
    }

    public void goUp(int desiredFloor){
        if(!this.doorOpen){
            if(desiredFloor <= this.numberOfFloors && desiredFloor > currentFloor){
                this.currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor){
        if(!this.doorOpen){
            if(desiredFloor >= 1 && desiredFloor < currentFloor){
                this.currentFloor = desiredFloor;
            }
        }
    }
}
