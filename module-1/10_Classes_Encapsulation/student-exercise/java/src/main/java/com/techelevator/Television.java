package com.techelevator;

public class Television {

    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    public Television() {
        isOn = false;
        currentChannel = 3;
        currentVolume = 2;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        if(isOn){
            isOn = false;
        }

    }

    public void turnOn(){
        if(!isOn){
            isOn = true;
        }
    }

    public void changeChannel(int newChannel){
        if(isOn){
            if(newChannel >= 3 && newChannel <= 18){
                this.currentChannel = newChannel;
            }
        }
    }

    public void channelUp(){
        if(this.isOn){
            if(this.currentChannel == 18){
                this.currentChannel = 3;
            }else{
                this.currentChannel += 1;
            }
        }
    }

    public void channelDown(){
        if(this.isOn){
            if(this.currentChannel == 3){
                this.currentChannel = 18;
            }else{
                this.currentChannel -= 1;
            }
        }
    }

    public void raiseVolume(){
        if(this.isOn){
            if(this.currentVolume < 10){
                this.currentVolume += 1;
            }
        }
    }

    public void lowerVolume(){
        if(this.isOn){
            if(this.currentVolume > 0){
                this.currentVolume -= 1;
            }
        }
    }
}
