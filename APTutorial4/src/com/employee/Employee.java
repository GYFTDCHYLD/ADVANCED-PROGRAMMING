package com.employee;

import java.io.Serializable;

import com.date.Date;

public class Employee implements Serializable{
	private String Name;
	private String Address;
	private String TRN;
	private String PhoneNumber;
	private Date DOB;
	
	
	public Employee() {
		super();
		Name = "";
		Address = "";
		TRN = "";
		PhoneNumber = "";
		DOB = new Date();
	}
	
	public Employee(String name, String address, String tRN, String phoneNumber, Date dOB) {
		Name = name;
		Address = address;
		TRN = tRN;
		PhoneNumber = phoneNumber;
		DOB = dOB;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTRN() {
		return TRN;
	}

	public void setTRN(String tRN) {
		TRN = tRN;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public String toString() {
		return "Name       : " + Name + "\n" 
		     + "Address    : " + Address + "\n"  
		     + "TRN        : " + TRN + "\n" 
		     + "PhoneNumber: " + PhoneNumber + "\n" 
			 + "DOB        : " + DOB;
	}
}
