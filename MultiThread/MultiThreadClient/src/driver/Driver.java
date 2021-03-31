package driver;

import java.util.Scanner;

import client.MultiThreadClient;

public class Driver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadClient client = new MultiThreadClient();
		Scanner input = new Scanner(System.in);
		String redo = "y";
		while(redo.toLowerCase() == "y") {
			System.out.println("Enter radius: ");
			Double radius = input.nextDouble();
			client.sendRadius(radius);
			client.receiveArea();
			System.out.println("Would you like to enter a new radius?\nY - yes\nN- no");
			redo = input.next().toLowerCase();
		}
		client.closeConnection();
		input.close();
	}

}
