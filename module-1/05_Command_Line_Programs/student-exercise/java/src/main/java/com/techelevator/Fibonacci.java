package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		//create a scanner
		Scanner input = new Scanner(System.in);

		//ask for number from user and store in string
		//convert string to integer
		System.out.println("Please enter the Fibonacci number: ");
		String fibStr = input.nextLine();
		int fibNum = Integer.parseInt(fibStr);

		//provide fib sequence leading up to number
		//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
		//the first two numbers in the Fibonacci sequence are 0 and 1,
		// and each subsequent number is the sum of the previous two

		int firstNum = 0;
		int secondNum = 1;
		int sum = 0;


		while(sum < fibNum){
			System.out.print(firstNum + ", ");
			sum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = sum;


		}
			System.out.print(firstNum);


	}

}
