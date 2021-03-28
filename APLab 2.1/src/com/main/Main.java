package com.main;

import java.io.IOException;

import com.domain.ContainersNeeded;
import com.exception.MyException;

public class Main {
	// Exercise one
	public static void main(String[] args) throws IOException, MyException{
		
		ContainersNeeded container = new ContainersNeeded();
		
		System.out.println("Calling Demonstrate()");
		
		//Exercise five 
		try {
			container.Demonstrate();
		}catch(ArithmeticException e) {
			System.out.println("Size of retail container cannot be zero");
		}catch(MyException me) {
			System.err.println(me.getMessage());
		}catch(Exception e) {
			System.err.println("General exception raisedr");
		}
		
		System.out.println("Return from Demonstrate(), " + " now back in main()");
		
	}

}
