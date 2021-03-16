package Aplabt1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Student implements Serializable{
	private String Id;
	private String Name;
	private String Email;
	private Date DOB;
	
	
	public Student() {
		Id = "";
		Name = "";
		Email = "";
		DOB = new Date();
	}
	
	
	public Student(String id, String name, String email, Date dOB) {
		Id = id;
		Name = name;
		Email = email;
		DOB = dOB;
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", DOB=" + DOB + "]";
	}
	
	public void writeToFile(ArrayList<Student> Students) throws FileNotFoundException, IOException {
		ObjectOutputStream Output = new ObjectOutputStream(new FileOutputStream("QACStudents.ser"));
		for(Student Student: Students) {
			Output.writeObject(Student);
		}
		Output.flush(); 
		Output.close();
	}
	
	public Student readFromFile(String string)  throws ClassNotFoundException, IOException, FileNotFoundException{
		Student Student = new Student(); 
		ObjectInputStream Input = new ObjectInputStream(new FileInputStream("QACStudents.ser"));
		while(true) {
			try {
				Student = (Student) Input.readObject();
				if(Student.getId() == string) { 
					return Student;
				}
			}catch(EOFException e) {
				break; 
			} 
		}
		return new Student();
	}
	
}
