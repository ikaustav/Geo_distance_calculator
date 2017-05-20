package com.geodistance.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.geodistance.bean.Customer;

public class JsonParser {
	
	/*
	 * Details: parse the json data 
	 * Parameter: 
	 * 		strFilePath- path of the file
	 * Return: List of Customer objects parsed from the json data
	*/
	public List<Customer> parse(String strFilePath){
		List<Customer> customerList = new ArrayList<Customer>();
		
		try{

			String strJsonString = this.read(strFilePath);
			
			JSONObject json = new JSONObject(strJsonString);
			JSONArray jsonCustomerArr = json.getJSONArray("customer");
			
			JSONObject jsonCustomerObj = null;
			Customer customerObj = null;
			
			for(int count=0; count<jsonCustomerArr.length(); count++)
			{
				//extra try catch statement because if one entry is incorrect in the json file, 
				//then it should not affect the other entries
				try{
					jsonCustomerObj = jsonCustomerArr.getJSONObject(count);
					customerObj = new Customer(jsonCustomerObj.getString("name"), jsonCustomerObj.getInt("userId"), jsonCustomerObj.getDouble("latitude"), jsonCustomerObj.getDouble("longitude"));
					customerList.add(customerObj);
				}
				catch(JSONException ex){
					ex.printStackTrace();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		catch(JSONException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return customerList;
	}
	
	/*
	 * Details: read the json data from a file and output is as a String
	 * Parameter: 
	 * 		strFilePath- path of the file
	 * Return: json data as String
	*/
	private String read(String strFilePath){
		String strJsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(strFilePath));
			while ((line = br.readLine()) != null) {
				strJsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return strJsonData;
	}
}
