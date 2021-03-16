//Craig Reid
//1806394
package Labtest1_2_2021;

import java.io.Serializable;

public class Address implements Serializable{
	private String streetAddress; 
	private String parish;
	
	
	public Address() {
		streetAddress = "";
		parish = "";
	}


	public Address(String streetAddrss, String parish) {
		this.streetAddress = streetAddrss;
		this.parish = parish;
	}


	public String getStreetAddrss() {
		return streetAddress;
	}


	public void setStreetAddrss(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getParish() {
		return parish;
	}


	public void setParish(String parish) {
		this.parish = parish;
	}


	@Override
	public String toString() {
		return "Street Address: " + streetAddress + "Parish: " + parish;
	}
	
}
