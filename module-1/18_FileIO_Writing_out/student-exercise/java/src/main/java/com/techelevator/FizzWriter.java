package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("./FizzBuzz.txt"))) {
            for (int i = 1; i <= 300; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    pw.println("FizzBuzz");
                } else if (i % 3 == 0 || String.valueOf(i).contains("3")) {
                    pw.println("Fizz");
                } else if (i % 5 == 0 || String.valueOf(i).contains("5")) {
                    pw.println("Buzz");
                } else {
                    pw.println(i);
                }
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
