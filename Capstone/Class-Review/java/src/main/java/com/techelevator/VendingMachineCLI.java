package com.techelevator;

import com.techelevator.biz.VendingManager;
import com.techelevator.data.InventoryReader;
import com.techelevator.entity.Customer;
import com.techelevator.entity.VendingMachine;
import com.techelevator.view.Menu;

import java.text.NumberFormat;
import java.util.Scanner;

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

	private VendingManager manager;

	private Scanner scanner;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseSubMenu();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
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
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH)) {
				return;
			}
		}
	}

	private void feedMoney() {
		System.out.println("Please enter money (in whole dollars): ");
		System.out.println("New balance: " +
				NumberFormat.getCurrencyInstance().format(
						manager.feedMoney(scanner.nextLine())));
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			VendingMachine vm = InventoryReader.loadInventory(DEFAULT_VENDING_FILENAME);
			cli.manager = new VendingManager(vm, new Customer());
		} catch (Exception ex){
			System.out.println("Error: " + ex.getMessage());
			System.exit(1);
		}
		cli.scanner = new Scanner(System.in);
		cli.run();
	}
}
