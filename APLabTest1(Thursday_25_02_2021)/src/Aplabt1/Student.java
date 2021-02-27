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
	private int Id;
	private String Name;
	private String Email;
	private Date DOB;
	
	
	public Student() {
		Id = 0;
		Name = "";
		Email = "";
		DOB = new Date();
	}
	
	
	public Student(int id, String name, String email, Date dOB) {
		Id = id;
		Name = name;
		Email = email;
		DOB = dOB;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
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
	
	public Student readFromFile(int Key)  throws ClassNotFoundException, IOException, FileNotFoundException{
		Student Student = new Student(); 
		ObjectInputStream Input = new ObjectInputStream(new FileInputStream("QACStudents.ser"));
		while(true) {
			try {
				Student = (Student) Input.readObject();
				if(Student.getId() == Key) {
					return Student;
				}
			}catch(EOFException e) {
				break; 
			} 
		}
		return new Student();
	}
	
	/* this method returns an array while the method above return a single object
	public static ArrayList<Student> readFromFile()  throws ClassNotFoundException, IOException, FileNotFoundException{
		ArrayList<Student> Students = new ArrayList();
		Student Student = new Student();
		ObjectInputStream Input = new ObjectInputStream(new FileInputStream("QACStudents.ser"));
		while(true) {
			try {
				Students.add(Student = (Student) Input.readObject());
			}catch(EOFException e) {
				break; 
			} 
		}
		return Students;
	}
	*/
	
}
