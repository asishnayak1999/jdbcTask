package com.fis.app.exce;

public class NoDeviceFoundException extends Exception {
	
private String brand;
private String type;
	
	public NoDeviceFoundException(String brand, String type) {
	super();
	this.brand = brand;
	this.type = type;
}


	public String toString()
	{
		return "No Device Available"+brand+" "+type;
	}
}
