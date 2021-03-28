package com.DeSerializationDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.employee.Employee;

public class DeSerializationDriver {

	public static void main(String[] args) {
		try {
			ObjectInputStream IS = new ObjectInputStream(new FileInputStream("Employee.ser"));
			Employee emp = (Employee) IS.readObject();
			IS.close();
			System.out.println(emp);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
