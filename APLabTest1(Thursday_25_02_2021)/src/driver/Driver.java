package driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Aplabt1.Date;
import Aplabt1.Student;
import form.Form;

public class Driver {
	static ArrayList<Student> studentList = new  ArrayList();
	public static void main(String[] arg) throws FileNotFoundException, IOException {
		
		studentList.add(new Student("1801864", "Jane Henry", "jane@yahoo.com",new Date(10,10,2000)));
		studentList.add(new Student("1822327", "Rachell Green", "rachell@yahoo.com",new Date(20,03,2001)));
		studentList.add(new Student("1800120", "Kerry Plasid", "plasid@yahoo.com",new Date(10,10,2003)));
		
		showMenu();
	}
	
	public static void showMenu() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		System.out.println(" 1 Insert Student Records");
		System.out.println(" 2 Display Student Records");
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
			case 1:		Student Student = new Student();
						Student.writeToFile(studentList);
						System.out.println(" Data has written to file");
						showMenu(); 
				break;
			case 2: 	new Form();
				break;
			case 3:		System.out.println(" Goodbye :)");
				break;
			default: 	System.err.println(" Option mus be an intiger ranging from 1-3");
						showMenu();
				
		
		}
	}

}