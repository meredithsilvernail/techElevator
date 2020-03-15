package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Driver {

    private final String FILE_NAME = "./PastTeamPairings.txt";

    public static void main(String[] args){

        File ourFile = new File("./");
        for (String value : ourFile.list()) {
            System.out.println(value);
        }

        Driver driver = new Driver();

        try (Reader theFile = driver.openTheFile()) {
            driver.readTheFile(theFile);

        } catch (FileNotFoundException ex){
            System.out.println("File Not Found Error " + ex.getMessage());
            System.exit(1);
        } catch (IOException ex){
            System.out.println("Error " + ex.getMessage());
            System.exit(1);
        }
    }

    public Reader openTheFile() throws FileNotFoundException {
        File ourFile = new File(FILE_NAME);
        if (ourFile == null || !ourFile.isFile()){
            System.out.println(FILE_NAME + " is not a file!");
            return null;
        }
        System.out.println(ourFile.getName());

        return new BufferedReader( new FileReader(ourFile) );
    }

    public Scanner openTheFileScanner() throws FileNotFoundException {
        File ourFile = new File(FILE_NAME);
        if (ourFile == null || !ourFile.isFile()){
            System.out.println(FILE_NAME + " is not a file!");
            return null;
        }
        System.out.println(ourFile.getName());

        return new Scanner(ourFile);  // scanner.hasNextLine()
    }

    public void readTheFile(Reader theFile) throws IOException {
        BufferedReader br = (BufferedReader)theFile;
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

    }
}
