package com.techelevator;

import com.techelevator.biz.VendingManager;
import com.techelevator.data.InventoryFileDAO;
import com.techelevator.data.Logger;
import com.techelevator.entity.Money;
import com.techelevator.entity.Vendable;
import com.techelevator.entity.VendingMachine;
import com.techelevator.exceptions.DataAccessException;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String DEFAULT_VENDING_FILENAME =
			"./vendingmachine.csv";

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {
			MAIN_MENU_OPTION_DISPLAY_ITEMS,
			MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT	};

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {
			PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT,
			PURCHASE_MENU_OPTION_FINISH};

	private Menu menu;

	private VendingManager vendingManager;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseSubMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Here is your change: " +
						vendingManager.getChange());
				Logger.closeLogger();
				System.exit(0);
			}
		}
	}

	private void purchaseSubMenu() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				feedMoney();
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT)) {
				selectOption();
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH)) {
				return;
			}
		}
	}

	private void displayItems(){
		for (Vendable item : vendingManager.getInventoryItems()){
			System.out.println(item);
		}
	}

	private void feedMoney(){
		int inputAmount = menu.getInteger(
				"Please enter amount (whole dollars only): ");
		if (inputAmount <= 0) {
			return;
		}
		vendingManager.addMoneyToCustomerBalance(inputAmount);
		System.out.println(
				"Current Balance: " + vendingManager.getCustomerBalance());
	}

	private void selectOption(){
		String inputOption = menu.getInput(
				"Please enter code for selection: ");
		System.out.println(
				vendingManager.addSelectedItem(inputOption));
		System.out.println("Balance: " +
				vendingManager.getCustomerBalance());
	}

	public static void main(String[] args) {
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

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.vendingManager = new VendingManager(vendingMachine);
		cli.run();
	}
}
