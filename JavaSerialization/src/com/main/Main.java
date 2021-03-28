package com.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.date.Date;
import com.user.User;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<User>  List = new ArrayList();
		List.add(new User("Sam", "Ron", 23, new Date(2,2,1992)));
		List.add(new User("jake", "cork", 23, new Date(3,4,1993)));
		List.add(new User("crain", "tom", 23, new Date(4,5,1997)));
		List.add(new User("lisa", "pears", 23, new Date(7,2,1998)));
		List.add(new User("kim", "blue", 23, new Date(3,10,2000)));

		User.Write2(List);
		try {
			System.out.println(User.Read2());
		} catch (ClassNotFoundException e) {
			System.err.println("class not found");
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} catch (IOException e) {
			System.err.println("IO exxception ");
		}
		
	}

}
