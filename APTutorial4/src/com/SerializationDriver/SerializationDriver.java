package com.SerializationDriver;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.date.Date;

import com.employee.Employee;

public class SerializationDriver{
	static Employee Emp = new Employee("Jenifer James", "Jamaica","123-987-392","(876)-435-2323",new Date(11,3, 1990)) ;
	
	public static void main(String[] args) {
		try {
			ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream("Employee.ser"));
			OS.writeObject(Emp);
			OS.flush();
			OS.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
