package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(
                new File("./PastTeamPairings.txt"));
             PrintWriter pw = new PrintWriter(
                     new FileWriter("./TeamCopy.txt", true));
            ) {
            while (scanner.hasNextLine()){
                pw.println(scanner.nextLine());
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
