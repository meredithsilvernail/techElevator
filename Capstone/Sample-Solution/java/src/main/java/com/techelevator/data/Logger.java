package com.techelevator.data;

import com.techelevator.exceptions.DataAccessException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    public static final String DEFAULT_LOG_FILENAME =
            "C:\\te-instructor-work\\david-vickars\\course-extras\\19_Capstone\\java\\log.txt";

    private static PrintWriter logfile;

    public static void openLogger(String filename) throws DataAccessException {
        try {
            logfile = new PrintWriter( new FileWriter(filename) );
        } catch (IOException e){
            // failed logger so default to console
            System.out.println("Logger failed to open: " + e.getMessage());
            throw new DataAccessException("Logger failed to open!");
        }
    }

    public static void closeLogger(){
        if (logfile != null)
            logfile.close();
    }

    public static void logMessage(AuditLogEntry message){
        if (logfile == null){
            return;
        }
        logfile.println(message);
    }

    public static void logMessage(String message){
        if (logfile == null){
            return;
        }
        logfile.println(message);
    }

    public static void logTimeStampedMessage(String message){

        logMessage(new Date() + ": " + message);
    }
}
