package com.geodistance.bean;

/*
 * Details: Bean class to define each customers
*/

public class Customer {
	private String strName;
	private int numUserId;
	private double dbLattitude;
	private double dbLongitude;
	
	/*
	 * Parameterized constructor
	 */
	public Customer(String strName, int numUserId, double dbLattitude, double dbLongitude) {
		this.strName = strName;
		this.numUserId = numUserId;
		this.dbLattitude = dbLattitude;
		this.dbLongitude = dbLongitude;
	}
	
	/*
	 * Getters and setters 
	 */
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public int getNumUserId() {
		return numUserId;
	}
	public void setNumUserId(int numUserId) {
		this.numUserId = numUserId;
	}
	public double getDbLattitude() {
		return dbLattitude;
	}
	public void setDbLattitude(double dbLattitude) {
		this.dbLattitude = dbLattitude;
	}
	public double getDbLongitude() {
		return dbLongitude;
	}
	public void setDbLongitude(double dbLongitude) {
		this.dbLongitude = dbLongitude;
	}

}
