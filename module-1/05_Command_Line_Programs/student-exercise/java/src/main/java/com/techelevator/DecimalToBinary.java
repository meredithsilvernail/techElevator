package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		//create scanner
		Scanner input = new Scanner(System.in);

		//ask for series of decimal int values separated by space
		System.out.println("Please enter in a series of decimal values (separated by spaces): ");

		//store answer in string
		String inputStr = input.nextLine();

		//separate values and store in array as strings
		String[] valuesArray = inputStr.split(" ");

		//print to console original number and conversion
//		"easy" way with built in method
//		for(String str : valuesArray){
//			int convertedNum = Integer.parseInt(str);
//			System.out.println(convertedNum + " in binary is " + Integer.toBinaryString(convertedNum));
//		}

		int[] decimalArray = new int[valuesArray.length];

		for(int i = 0; i < valuesArray.length; i++){
			decimalArray[i] = Integer.parseInt(valuesArray[i]);;
		}
		//convert to binary and store in string
		//reverse string to put binary in correct order
		String binaryString = "";
		String binaryStringReverse = "";

		//for each number in decimal array - save number, get remainder of num / 2 and add to string
		for(int num : decimalArray){
			int tempNum = num;
			while(num > 0){
				binaryString = binaryString.concat(Integer.toString(num % 2));
				num = num / 2;
			}

			//loop through created string and add to new string in reverse to get binary in right order
			for(int i = binaryString.length() -1; i >= 0; i--){
				binaryStringReverse += binaryString.charAt(i);
			}

			//print out original value and binary value
			//reset string variables for next number
			System.out.println(tempNum + " in binary is " + binaryStringReverse);
			binaryString = "";
			binaryStringReverse = "";
		}

	}

}
