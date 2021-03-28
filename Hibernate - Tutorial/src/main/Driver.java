package main;

import java.util.List;

import models.Student;

public class Driver {
	public static void main(String... args) {
		Student student = new Student(1, "Craig", "Reid", "craig@yahoo.com"); 
		student.create(); 
		//student.update();
		//List list = student.readAll();
		///student.delete();
	}
}
