package com.domain;

public class Vehicle {
	private String make;
	private String model;
	private String color;
	private int year;
	private boolean fourWheelDrive;
	
	
	public Vehicle() {
		super();
		this.make = "";
		this.model = "";
		this.color = "";
		this.year = 1;
		this.fourWheelDrive = false;
	}
	
	public Vehicle(String make, String model, String color, int year, boolean fourWheelDrive) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.fourWheelDrive = fourWheelDrive;
	}
	
	
	public Vehicle(Vehicle copy) {
		super();
		this.make = copy.make;
		this.model = copy.model;
		this.color = copy.color;
		this.year = copy.year;
		this.fourWheelDrive = copy.fourWheelDrive;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isFourWheelDrive() {
		return fourWheelDrive;
	}

	public void setFourWheelDrive(boolean fourWheelDrive) {
		this.fourWheelDrive = fourWheelDrive;
	}

	@Override
	public String toString() {
		return   " Make      : " + make + 
			   "\n Model     : " + model + 
			   "\n color     : " + color + 
			   "\n year      : " + year + 
			   "\n Drive Type: " + fourWheelDrive + "\n";
	}
}
