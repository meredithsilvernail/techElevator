package com.techelevator;

import java.util.*;

public class Explainer {

    public static void main(String[] args){
        Explainer.getNextExplainer();
    }

    public static void getNextExplainer(){
        String[] participants = {
                "Chris", "Sherin", "Greg", "Nick",
                "Margaret", "David", "Shaama", "Meredith",
                "Troy", "Leah", "Victoria", "Anthony"};
        Random random = new Random();
        int index = random.nextInt(participants.length);
        System.out.println(index + " " + participants[index]);
    }
}
