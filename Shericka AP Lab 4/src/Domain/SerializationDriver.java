package Domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDriver {

	public static void main(String[] args)
	{
					
		Date date = new Date(2021,2,8);
		
		Employee emp = new Employee("Bob","1244","46656","876-589-0987", date);
		
		try {
			
			ObjectOutputStream os = new ObjectOutputStream(
						new FileOutputStream ("Employees.ser"));
			
			os.writeObject(emp);
		
				
		}catch(IOException ex) 
		{
			
			System.err.println("Error Occured");
		}
		
	}

}


		
		