package com.user;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.date.Date;

public class User implements Serializable{
	private String firstName;
	private String lastName;
	private int age;
	private Date signUpDate;
	
	
	public User() {
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.signUpDate = new Date();
	}
	
	public User(String firstName, String lastName, int age, Date signUpDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.signUpDate = signUpDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
	
	public static void Write(ArrayList<User> Users) throws IOException, FileNotFoundException {
		ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream("Users.ser"));
		OS.writeObject(Users);
		OS.flush();
		OS.close();
	}
	
	public static void Write2(ArrayList<User> Users) throws IOException, FileNotFoundException {
		ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream("Users.ser"));
		for(User user:  Users)
			OS.writeObject(user);
		OS.flush();
		OS.close();
	}
	
	public static ArrayList<User> Read() throws ClassNotFoundException, IOException, FileNotFoundException {
		ObjectInputStream IS = new ObjectInputStream(new FileInputStream("Users.ser"));
		ArrayList<User> user = (ArrayList<User>) IS.readObject();
		IS.close();
		return user;
	}
	
	public static ArrayList<User> Read2()  throws ClassNotFoundException, IOException, FileNotFoundException{
		ArrayList<User> Users = new ArrayList();
		User user = new User();
		ObjectInputStream IS = new ObjectInputStream(new FileInputStream("Users.ser"));
		while(true) {
			try {
				Users.add(user = (User) IS.readObject());
			}catch(EOFException e) {
				break;
			} 
		}
		return Users;
	}

	
	public String toString() {
		return "First Name : " + firstName + "\n"
			 + "Last Name    : " + lastName + "\n" 
			 + "Age          : " + age + "\n" 
			 + "Signup Date  : " + signUpDate + "\n";
	}
}
