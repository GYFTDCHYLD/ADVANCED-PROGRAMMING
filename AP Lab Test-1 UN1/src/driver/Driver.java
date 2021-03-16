//Craig Reid
//1806394

package driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Labtest1_2_2021.*;
import form.Form;

public class Driver {
	public static ArrayList<Employee> EmployeeList = new  ArrayList(); 
	
	public static void main(String[] arg) throws FileNotFoundException, IOException {
		getEmployeeList().add(new Employee("123", "Kelly Palmer", new Address("Somewhere 123","Kingston")));
		getEmployeeList().add(new Employee("113", "Cookie Berry", new Address("Up The Road 19","Clarendon")));
		showMenu();
	}
	
	public static void showMenu() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1 Insert Employee Data");
		System.out.println(" 2 Display Employee Data");
		System.out.println(" 3 Exit");
		
		int Option = 0;
		try {
			System.out.print("\n Option: ");
			Option = input.nextInt();
		}catch(InputMismatchException e) {
			System.err.println(" Option mus be an intiger ranging from 1-3"); 
			showMenu();
		}catch(Exception e) {
			System.out.println(" Unknown exception fround");
		}
		
		
		switch(Option) {
			case 1:		new Form();
						showMenu(); 
				break;
			case 2: 	System.out.println(" Enter Id: ");
						Employee employee = new Employee();
						try {
							System.out.println(employee.readFromFile(input.next()));
						} catch (ClassNotFoundException e) {
							System.err.println("Employee Class Not found ");
						} catch (FileNotFoundException e) {
							System.err.println(" FileNotFoundException ");
						} catch (IOException e) {
							System.err.println(" IOException");
						}
						showMenu(); 
				break;
			case 3:		System.out.println(" Goodbye...... :)");
				break;
			default: 	System.err.println(" invalid input");
						showMenu();
				
		
		}
	}

	public static ArrayList<Employee> getEmployeeList() {
		return EmployeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		EmployeeList = employeeList;
	}

}