package com.techelevator.gui;

import com.techelevator.biz.VendingManager;
import com.techelevator.data.AuditLogEntry;
import com.techelevator.data.InventoryFileDAO;
import com.techelevator.data.LogFileDAO;
import com.techelevator.data.Logger;
import com.techelevator.entity.Chip;
import com.techelevator.entity.Money;
import com.techelevator.entity.Vendable;
import com.techelevator.entity.VendingMachine;
import com.techelevator.exceptions.DataAccessException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Vector;

public class VendingMainFrame extends JFrame {

    private static final int QUANTITY_COLUMN = 3;

    private JTable inventoryTable;
    private InventoryTableModel inventoryTableModel;
    private JScrollPane inventoryTableScrollPane;

    private JMenuItem loadInventoryFileItem;
    private JMenuItem loadLogFileItem;
    private JMenuItem quitItem;

    private JMenuItem editInventoryFileItem;

    private JLabel customerBalanceLabel;
    private JButton feedMoneyItem;
    private JButton selectProductItem;
    private JButton quitButton;

    private VendingManager vendingManager;

    public VendingMainFrame(VendingManager vendingManager){
        setTitle("Vendo-Matic 800");

        this.vendingManager = vendingManager;

        loadInventoryFileItem = new JMenuItem("Load Inventory");
        loadInventoryFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadInventoryAction();
            }
        });
        loadLogFileItem = new JMenuItem("Load Logs");
        loadLogFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLogsAction();
            }
        });
        quitItem = new JMenuItem("Exit");
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitAction();
            }
        });

        editInventoryFileItem = new JMenuItem("Update Inventory");
        editInventoryFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInventoryAction();
            }
        });

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(loadInventoryFileItem);
        fileMenu.addSeparator();
        fileMenu.add(loadLogFileItem);
        fileMenu.addSeparator();
        fileMenu.add(quitItem);

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(editInventoryFileItem);
        editMenu.addSeparator();

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        customerBalanceLabel = new JLabel(
                "Current Balance: " + vendingManager.getCustomerBalance());
        feedMoneyItem = new JButton("Feed Money");
        feedMoneyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedMoneyAction();
            }
        });
        selectProductItem = new JButton("Select Product");
        selectProductItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectProductAction();
            }
        });

        quitButton = new JButton("Exit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitAction();
            }
        });
        JPanel bottomPanel = new JPanel();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(customerBalanceLabel);
        bottomPanel.add(feedMoneyItem);
        bottomPanel.add(selectProductItem);
        bottomPanel.add(quitButton);
        customerBalanceLabel.setVisible(false);
        feedMoneyItem.setVisible(false);
        selectProductItem.setVisible(false);

        setSize(500, 400);
    }

    private void exitAction(){
        returnChange();
        Logger.closeLogger();
        System.exit(0);
    }

    private void displayInventoryAction(){
        inventoryTableModel = new InventoryTableModel(vendingManager);
        inventoryTable = new JTable(inventoryTableModel);
        inventoryTableScrollPane = new JScrollPane(inventoryTable);
        inventoryTable.setFillsViewportHeight(true);
        // Enables row selection mode and disable column selection
        // mode.
        inventoryTable.setRowSelectionAllowed(true);
        inventoryTable.setColumnSelectionAllowed(false);
        add(inventoryTableScrollPane, BorderLayout.CENTER);

        customerBalanceLabel.setVisible(true);
        feedMoneyItem.setVisible(true);
        selectProductItem.setVisible(true);
    }

    private void loadInventoryAction(){
        JFileChooser jfc = new JFileChooser( new File( System.getProperty("user.dir")));

        int returnValue = jfc.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            try {
                vendingManager.setVendingMachine(
                        new VendingMachine(
                                InventoryFileDAO.loadVendingMachine(5, selectedFile)));
                displayInventoryAction();
            } catch (DataAccessException e){
                Logger.logTimeStampedMessage(
                        "Error Loading File : " + selectedFile.getAbsolutePath() + " : " + e.getMessage());
            }
        }
    }

    private void loadLogsAction(){
        JFileChooser jfc = new JFileChooser( new File( System.getProperty("user.dir")));

        int returnValue = jfc.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            List<String> logList = LogFileDAO.loadStringLogs(selectedFile);
            displayLogs(logList);
        }
    }

    private void displayLogs(List<String> logList){
        JOptionPane.showMessageDialog(this,
                "Under Construction",
                "Log Viewer",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateInventoryAction(){
        if (inventoryTable == null) {
            JOptionPane.showMessageDialog(this,
                    "No Inventory Data to Update!",
                    "Update Inventory",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        inventoryTable.setColumnSelectionAllowed(true);
    }

    private void feedMoneyAction(){
        String amount = JOptionPane.showInputDialog(this,
                "Enter amount:",
                "Feed Money",
                JOptionPane.DEFAULT_OPTION);
        vendingManager.addMoneyToCustomerBalance(amount);
        customerBalanceLabel.setText(
                "Current Balance: " + vendingManager.getCustomerBalance());
    }

    private void selectProductAction(){
        int selectedIndex = inventoryTable.getSelectedRow();
        if (selectedIndex == -1)
            return;
        String displayText = vendingManager.addSelectedItem(selectedIndex);
        JOptionPane.showMessageDialog(this,
                displayText,
                "Selected Product",
                JOptionPane.INFORMATION_MESSAGE);
        Vendable item = vendingManager.getCurrentSelectedItem();
        if (item == null){
            return;
        }
        inventoryTableModel.setValueAt(item.getQuantity(), selectedIndex, QUANTITY_COLUMN);
        vendingManager.setCurrentSelectedItemToNull();
        customerBalanceLabel.setText(
                "Current Balance: " + vendingManager.getCustomerBalance());
    }

    private void returnChange(){
        if (vendingManager.getCustomerBalance().isZero()) {
            return;
        }
        JOptionPane.showMessageDialog(this,
                "Thank you and here is your change "
                        + vendingManager.getChange(),
                "Leaving Vending...",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

class InventoryTableModel extends AbstractTableModel {

    private String[] columnNames =
            {"Code", "Name", "Price", "Quantity"};

    private Object[][] data;

    private VendingManager vendingManager;

    public InventoryTableModel(VendingManager vendingManager){
        this.vendingManager = vendingManager;
        setData();
    }

    public void setData(){
        List<Vendable> sortedInventory = vendingManager.getSortedVendingInventory();
        int size = sortedInventory.size();
        data = new Object[size][4];
        for (int i=0; i < size; i++){
            Vendable item = sortedInventory.get(i);
            for (int j=0; j < 4; j++) {
                switch (j){
                    case 0 :
                        data[i][j] = item.getCode();
                        break;
                    case 1 :
                        data[i][j] = item.getName();
                        break;
                    case 2 :
                        data[i][j] = item.getPrice();
                        break;
                    case 3 :
                        data[i][j] = item.getQuantity();
                        break;
                }
            }
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return false;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
