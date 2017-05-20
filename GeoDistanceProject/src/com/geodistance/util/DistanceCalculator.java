package com.geodistance.util;

import java.util.ArrayList;
import java.util.List;
import com.geodistance.bean.Customer;
import com.geodistance.constant.Constants;

public class DistanceCalculator {
	/*
	 * Details: find customers in a range 
	 * Parameter: 
	 * 		customerList - customer list on which it finds the customer in range
	 * 		numDistance - Range used in finding
	 * Return: List of customer objects within the given range
	*/
	public List<Customer> findCustomersInRange(List<Customer> customerList, long numDistance){
		List<Customer> resultList = new ArrayList<Customer>();
	
		for(Customer item : customerList){
			if(getDistance(item.getDbLattitude(), item.getDbLongitude(), Constants.OFFICE_LATTITUDE, Constants.OFFICE_LONGITUDE) <= numDistance){
				resultList.add(item);
			}
		}
		
		return resultList;
	}
	
	/*
	 * Details: calculate distance in km between two geo points 
	 * Parameter: 
	 * 		dbLat1 - Latitude of first point
	 * 		dbLon1 - Longitude of first point
	 *		dbLat2 - Latitude of second point
	 *		dbLon2 - Longitude of second point
	 * Return: distance between the two points in km
	*/
	private double getDistance(double dbLat1, double dbLon1, double dbLat2, double dbLon2) {
		double dbAbsDiff = dbLon2 - dbLon1;
		
		double dbCentralAngle = Math.acos(Math.sin(Math.toRadians(dbLat1)) * Math.sin(Math.toRadians(dbLat2)) + 
				Math.cos(Math.toRadians(dbLat1)) * Math.cos(Math.toRadians(dbLat2)) * Math.cos(Math.toRadians(dbAbsDiff)));
		
        double dbDistance = Constants.EARTH_RADIUS * dbCentralAngle;

		return dbDistance;
	}

}
