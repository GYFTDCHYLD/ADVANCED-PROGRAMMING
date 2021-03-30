package main;
import models.Student;
import java.util.Scanner;

public class Driver {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		Student student = null;
		String id;
		String name;
		Scanner input = new Scanner(System.in);
		System.out.print("\n Enter ID: ");
		id = input.next();
		System.out.print("\n Enter Name: ");
		name = input.next();
		student.create(id, name);
		student.readAll();
		student.update(id, "Shericka");
		student.readAll();
		student.delete(id);
		student.readAll();
	}

}