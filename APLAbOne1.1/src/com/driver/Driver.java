package com.driver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.domain.Vehicle;

public class Driver {

	public static void main(String[] args) {
		
		List<Vehicle> listOfVehicles = new ArrayList<>();
		
		Vehicle zuki = new Vehicle("Suzuki", "Vitara", "Red", 2019, true);
		listOfVehicles.add(zuki);
		listOfVehicles.add(new Vehicle("Honda", "City", "White", 2020, false));
		listOfVehicles.add(new Vehicle("Toyota", "Corolla", "Grey", 1999, false));
		
		for(Vehicle vehicle: listOfVehicles) {
			System.out.println(vehicle);
		}
		
		List<Vehicle> listOfVehicle2 = new LinkedList<>();
		Vehicle bmw = new Vehicle("BMW", "X6", "Blue", 2018, true);
		listOfVehicle2.add(bmw);
		listOfVehicle2.add(new Vehicle("Range Rover", "Evoque", "Mate Black", 2020, true));
		listOfVehicle2.add(new Vehicle("Mazda", "RX7", "Black", 2021, true));
		
		printList(listOfVehicle2);

	}
	
	private static void printList(List<Vehicle> vehicles) {
		for(Vehicle vehicle: vehicles) {
			System.out.println(vehicle);
		}
	}
}