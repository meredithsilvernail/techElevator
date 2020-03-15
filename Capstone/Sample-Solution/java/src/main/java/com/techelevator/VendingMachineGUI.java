package com.techelevator;

import com.techelevator.biz.VendingManager;
import com.techelevator.data.InventoryFileDAO;
import com.techelevator.data.Logger;
import com.techelevator.entity.Vendable;
import com.techelevator.entity.VendingMachine;
import com.techelevator.exceptions.DataAccessException;
import com.techelevator.gui.VendingMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class VendingMachineGUI {

    private static final String DEFAULT_VENDING_FILENAME =
            "./vendingmachine.csv";

    public static void main (String[] args){

        try{
            Logger.openLogger(Logger.DEFAULT_LOG_FILENAME);
        } catch (DataAccessException e){
            System.exit(1);
        }

        VendingMachine vendingMachine = null;
        try{
            vendingMachine = new VendingMachine(
                    InventoryFileDAO.loadVendingMachine(
                            5, DEFAULT_VENDING_FILENAME));
        } catch (DataAccessException e){
            Logger.closeLogger();
            System.exit(1);
        }
        VendingManager vendingManager = new VendingManager(vendingMachine);

        VendingMainFrame myFrame = new VendingMainFrame(vendingManager);
        myFrame.setVisible(true);
    }
}
