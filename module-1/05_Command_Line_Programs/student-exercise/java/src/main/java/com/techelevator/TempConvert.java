package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		//Create scanner
		Scanner input = new Scanner(System.in);

		//ask for temperature and store in variable, convert to double
		System.out.println("Please enter a temperature: ");
		String tempStr = input.nextLine();
		double tempNumber = Double.parseDouble(tempStr);

		//ask for C or F and store in variable
		System.out.println("Is the temperature in (C)elsius or (F)arenheit?: ");
		String tempCategory = input.nextLine().toUpperCase();

		//determine if temp entered is C or F and convert to opposite
		// Tf = Tc * 1.8 + 32
		// Tc = (Tf - 32) / 1.8
		//Print out original temp and converted temp
		if(tempCategory.equals("C")){
			double tempFar = tempNumber * 1.8 + 32;
			System.out.println(tempNumber + tempCategory + " is " + tempFar + "F");
		}else if(tempCategory.equals("F")) {
			double tempCel = (tempNumber - 32) / 1.8;
			System.out.println(tempNumber + tempCategory + " is " + tempCel + "C");
		}else{
			System.out.println("Did not receive 'C' or 'F'. Please try again.");
		}


	}



}
