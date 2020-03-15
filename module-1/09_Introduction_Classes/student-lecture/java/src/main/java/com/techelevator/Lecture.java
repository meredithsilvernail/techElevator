package com.techelevator;

import com.techelevator.entity.BankAccount;
import com.techelevator.entity.CheckAccount;
import com.techelevator.entity.Customer;

public class Lecture {

	public static void main(String[] args) {

		System.out.println(BankAccount.INTEREST_RATE); //accessing static final field

		BankAccount ba1 = new BankAccount(1, new Customer(1, "Leah", 24), 10);

		//System.out.println(ba1.accountNumber); //accessing overridden toString method in bank account class

		BankAccount ba2 = new BankAccount(1, new Customer(1, "Leah", 24), 10);

		System.out.println(ba2);

		Customer customer = new Customer(2,"Anthony", 25);
		CheckAccount ca1 = new CheckAccount(100.0, 2, customer, 10.00);

		System.out.println(ca1);

		BankAccount[] accounts = new BankAccount[2];
		accounts[0] = ba2;
		accounts[1] = ca1;

		for(BankAccount value : accounts){
			System.out.println(value);
		}
	}


	//three ways to iterate through a list
//    Iterator it = demoList.iterator(){
//        while(it.hasNext()){
//            BankAccount temp = it.hasNext();
//        }
//    }

//    for(BankAccount temp : demoList){
//
//    }

//    for(int i = 0; i < demoList.size();, i++){
//        BankAccount temp = demoList.get(i);
//    }


}
