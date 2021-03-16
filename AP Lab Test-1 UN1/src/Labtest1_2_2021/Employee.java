//Craig Reid
//1806394
package Labtest1_2_2021;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Employee implements Serializable{ 
	private String empId;
	private String name;
	private Address address; 
	
	public Employee() {
		this.empId = "";
		this.name = "";
		this.address = new Address();
	}
	
	public Employee(String empId, String name, Address address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	

	@Override
	public String toString() {
		return "( Employee ID:" + empId + "\n Name=" + name + "\n address=" + address + ")";
	} 




	public String getEmpId() {
		return empId;
	}



	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public void writeToFile(ArrayList<Employee> employees) throws FileNotFoundException, IOException { 
		ObjectOutputStream Output = new ObjectOutputStream(new FileOutputStream("QACEmployee.ser"));
		for(Employee employee: employees) {
			Output.writeObject(employee);
		}
		
		Output.flush(); 
		Output.close();
	}
	 
	public Employee readFromFile(String key)  throws ClassNotFoundException, IOException, FileNotFoundException{
		Employee employee = new Employee();  
		ObjectInputStream Input = new ObjectInputStream(new FileInputStream("QACEmployee.ser"));
		while(true) {
			try {
				employee = (Employee) Input.readObject();
				if(employee.getEmpId().equals(key)){  
					return employee;
				}
			}catch(EOFException e) {
				break; 
			} 
		}
		return new Employee();
	}
	
}
