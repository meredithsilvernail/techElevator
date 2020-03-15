package com.techelevator;

import com.techelevator.entity.Customer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		Customer cust1 = new Customer(1, "Mary");
		Customer cust2 = new Customer(2, "Paul");

		Map<Integer, Customer> customerMap = new HashMap<>();
		customerMap.put(cust1.getId(), cust1);
		customerMap.put(cust2.getId(), cust2);

		Customer currentCust = customerMap.get(1);
		System.out.println(currentCust.getName());

		for(Customer temp : customerMap.values()){
			System.out.println(temp.getName());
		}

		Set<Integer> keys = customerMap.keySet();
		for(Integer key : keys){
			Customer temp = customerMap.get(key);
			System.out.println(temp.getName());
		}


		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */

		/* The "put" method is used to add elements to a Map */

		/* The "get" method is used to retrieve elements from a Map */
	
		/* keySet returns a Set of all of the keys in the Map */
		
		/* If the key already exists, put will overwrite the existing value with the new value */


		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();



		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();


		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();



	}

}
