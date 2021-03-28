package com.domain;

import java.io.IOException;
import java.util.Scanner;
import com.exception.MyException;

public class ContainersNeeded {
	
	/* Exercise one
	
	public void Demonstrate()  throws IOException{
		int WholesaleSize;// size of ws container
		int RetailSize;// size of rt container
		int NumberRetailNeeded;// number of containers needed
		char ans;// single char needed to store 'y' or 'n'
		
		System.out.println("Now in Demonstrate()");
		
		while(true) {
			WholesaleSize = EnterSizeOfWholesaleContainer();
			RetailSize = EnterSizeOfRetailContainer();
			
			NumberRetailNeeded = CalculateRetailContainersNeeded(WholesaleSize, RetailSize); 
			
			System.out.println("Back to Demonstrate()");
			System.out.println("Number of retail container neded is : " + NumberRetailNeeded);
			
			
			
			ans = ' ';
			while(ans != 'y' && ans != 'Y' && ans != 'n' && ans != 'N') {
				System.out.print("Perform another calculation? " + " [Y/N]:  ");
				ans = (char)  System.in.read();
				System.out.println(" ");
				if(ans == 'n' || ans == 'N')
					break;
				
			}
		}
		
	}
	*/
	
	
	// Exercise four
	
	public void Demonstrate()  throws IOException, MyException{
			int WholesaleSize;// size of ws container
			int RetailSize;// size of rt container
			int NumberRetailNeeded = 0;// number of containers needed
			char ans;// single char needed to store 'y' or 'n'
			
			System.out.println("Now in Demonstrate()");
			
			while(true) {
				WholesaleSize = EnterSizeOfWholesaleContainer();
				RetailSize = EnterSizeOfRetailContainer();
				try {
					NumberRetailNeeded = CalculateRetailContainersNeeded(WholesaleSize, RetailSize); 
				}catch(MyException e) {
					//throw e;
					//throw new ArithmeticException();
					throw new MyException(e.getMessage());//Exercise 6 
				}
				
				System.out.println("Back to Demonstrate()");
				System.out.println("Number of retail container neded is : " + NumberRetailNeeded);
				
				
				
				ans = ' ';
				while(ans != 'y' && ans != 'Y' && ans != 'n' && ans != 'N') {
					System.out.print("Perform another calculation? " + " [Y/N]:  ");
					ans = (char)  System.in.read();
					System.out.println(" ");
					if(ans == 'n' || ans == 'N')
						break;
					
				}
				if(ans == 'n' || ans == 'N')
					break;
			}
			
		}

	/* Exercise one
	private int CalculateRetailContainersNeeded(int wholesaleSize, int retailSize) {
		System.out.println("Now in CalculateRetailContainersNeeded()");
		return wholesaleSize/retailSize;
	}
	*/
	
	/* Exercise two
	private int CalculateRetailContainersNeeded(int wholesaleSize, int retailSize) {
		System.out.println("Now in CalculateRetailContainersNeeded()");
		int result = 0;
		try {
			result = wholesaleSize/retailSize;
		}catch(ArithmeticException e) {
			System.err.println("Devision by zero is not allowed");
		}catch(Exception e) {
			System.err.println("general exception");
		}
		return result;
	}
	*/
	
	/* Exercise three
	private int CalculateRetailContainersNeeded(int wholesaleSize, int retailSize) throws ArithmeticException{
		System.out.println("Now in CalculateRetailContainersNeeded()");
		return wholesaleSize/retailSize;
	}
	*/
	
	// Exercise six
	private int CalculateRetailContainersNeeded(int wholesaleSize, int retailSize) throws MyException{
		System.out.println("Now in CalculateRetailContainersNeeded()");
		if(retailSize == 0) {
			 throw new MyException("Retail container size cannot be zero");
		}
		return wholesaleSize/retailSize;
	}
	
	

	// Exercise one
	private int EnterSizeOfRetailContainer() {
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("Now in EnterSizeOfRetailContainer()");
		System.out.print("Enter the size of the Retail" + " container: ");
		size = in.nextInt();
		System.out.println(" ");
		return size;
	}

	// Exercise one
	private int EnterSizeOfWholesaleContainer() {
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("Now in EnterSizeOfWholesaleContainer()");
		System.out.print("Enter the size of the wholesale" + " container: ");
		size = in.nextInt();
		System.out.println(" ");
		return size;
	}

}
