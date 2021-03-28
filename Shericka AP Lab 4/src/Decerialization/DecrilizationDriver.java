package Decerialization;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import Domain.Employee;

public class DecrilizationDriver 
{

	public static void main(String[] args) 
	{

		
				Employee empObj = null;
				try
				{
					ObjectInput is = new ObjectInputStream (new FileInputStream("Employees.ser"));
					empObj = (Employee) is.readObject();
					is.close();
					
					System.out.println(empObj);
							
				}catch(Exception ex)
				{
					System.err.println("Error file could not be read");
				}
		}

		

	

}
