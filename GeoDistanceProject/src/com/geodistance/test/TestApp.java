package com.geodistance.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.geodistance.bean.Customer;
import com.geodistance.constant.Constants;
import com.geodistance.util.DistanceCalculator;
import com.geodistance.util.JsonParser;

/*
 * Details: Class to test the application
*/
public class TestApp {

	public static void main(String[] args) {
		JsonParser parserObj = new JsonParser();
		DistanceCalculator calculatorObj = new DistanceCalculator();
		
		List<Customer> customerList = calculatorObj.findCustomersInRange(parserObj.parse("files/customers.json"), Constants.DISTANCE_RANGE);
		
		//error checking
		if(customerList == null || customerList.size() == 0){
			System.out.println("No customer found");
			return;
		}
		
		Collections.sort(customerList, new Comparator<Customer>() {
			@Override
			public int compare(Customer cust1, Customer cust2) {
				return cust1.getNumUserId() - cust2.getNumUserId();
			}
	    });
		
		System.out.println("You can invite the below persons:");
		for(Customer item : customerList){
			System.out.println("Name: " + item.getStrName() + ", User Id: " + item.getNumUserId());
		}
	}

}
