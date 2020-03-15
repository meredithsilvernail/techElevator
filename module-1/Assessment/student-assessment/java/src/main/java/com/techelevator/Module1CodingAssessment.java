package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		TellerMachine tm = new TellerMachine("TestMachine", new BigDecimal(50.00), new BigDecimal(25.00));
		System.out.println("Balance for " + tm.getManufacturer() + " is: " + tm.getBalance());
		System.out.println(tm);

		String cardNum1 = "5134567890123456";
		System.out.println(tm.isCardValid(cardNum1));

		List<TellerMachine> machineList = new ArrayList<>();

		try(Scanner scanner = new Scanner(new File("./data-files/TellerInput.csv"))){
			while(scanner.hasNext()){
//				String line = scanner.nextLine();
				String[] items = scanner.nextLine().split(",");
//				items = line.split(",");

				machineList.add(new TellerMachine(items[0], new BigDecimal(items[1]), new BigDecimal(items[2])));
				}

		}catch(FileNotFoundException ex){
			System.out.println("Error: " + ex.getMessage());
		}

		System.out.println(machineList);

		BigDecimal total = BigDecimal.ZERO;
		for(TellerMachine atm : machineList){
			total = total.add(atm.getBalance());
		}

		System.out.println("Total for all machines is: " + total);
	}

}
