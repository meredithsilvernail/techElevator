package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		//create scanner
		Scanner input = new Scanner(System.in);

		//ask user for a length
		System.out.println("Please enter the length: ");
		//store in a string variable and convert to a double
		String lengthStr = input.nextLine();
		double length = Double.parseDouble(lengthStr);

		//ask user for meters or feet
		System.out.println("Is the measurement in (m)eters, or (f)eet?: ");
		//store in a string variable
		String measureType = input.nextLine().toLowerCase();

		//determine if m or f and convert
		//print original and converted to console
		//m = f * 0.3048
		//f = m * 3.2808399
		if(measureType.equals("m")){
			double feet = length * 3.2808399;
			System.out.println(length + measureType + " is " + feet + "f");
		}else if(measureType.equals("f")) {
			double meters = length * 0.3048;
			System.out.println(length + measureType + " is " + meters + "m");
		}else{
			System.out.println("Did not receive 'm' or 'f', please try again.");
		}
	}

}
