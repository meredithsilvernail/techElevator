package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo2 {

    public static void main(String[] args){
        Demo2 demo2 = new Demo2();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("./Pairings.txt"))) {
            demo2.readTheFile(reader);

        } catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void readTheFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
}
