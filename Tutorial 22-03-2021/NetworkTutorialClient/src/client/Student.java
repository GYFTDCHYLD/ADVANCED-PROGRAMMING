package client;


import java.io.Serializable;

public class Student implements Serializable {
	private String StudentID;
	private String firstName;
	private String lastName;
	private String email;
	



	public Student() {
		super();
	}
	
	
	public Student(String studentID, String firstName, String lastName, String email) {
		super();
		StudentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	public String getStudentID() {
		return StudentID;
	}



	public void setStudentID(String studentID) {
		StudentID = studentID;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
