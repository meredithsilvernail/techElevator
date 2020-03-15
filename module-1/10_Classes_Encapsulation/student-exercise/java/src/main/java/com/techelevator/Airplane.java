package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats; //derived?
    private int totalFirstClassSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats; //derived
    private int totalCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
        this.availableFirstClassSeats =  totalFirstClassSeats - bookedFirstClassSeats;
        this.availableCoachSeats = totalCoachSeats - bookedCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return availableFirstClassSeats;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return availableCoachSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
        if(forFirstClass){
            if(this.availableFirstClassSeats >= totalNumberOfSeats){
                this.availableFirstClassSeats -= totalNumberOfSeats;
                this.bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }else{
                return false;
            }
        }else if(this.availableCoachSeats >= totalNumberOfSeats){
            this.availableCoachSeats -= totalNumberOfSeats;
            bookedCoachSeats += totalNumberOfSeats;
            return true;
        }else{
            return false;
        }
    }
}
