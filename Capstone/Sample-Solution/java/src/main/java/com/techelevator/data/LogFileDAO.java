package com.techelevator.data;

import com.techelevator.entity.*;
import com.techelevator.exceptions.DataAccessException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LogFileDAO {

    public static List<AuditLogEntry> loadLogs (File file) throws DataAccessException {
        List<AuditLogEntry> logs = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] fields = line.split("\\|");
            }
        } catch (IOException e){
            Logger.logTimeStampedMessage(e.getMessage());
            throw new DataAccessException("Error loading " + file.getAbsolutePath());
        }
        return logs;
    }

    /*
     *  This method implements a simple string logger.
     */
    public static List<String> loadStringLogs (File file) throws DataAccessException {
        List<String> logs = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                logs.add(scanner.nextLine());
            }
        } catch (IOException e){
            Logger.logTimeStampedMessage(e.getMessage());
            throw new DataAccessException("Error loading " + file.getAbsolutePath());
        }
        return logs;
    }
}
