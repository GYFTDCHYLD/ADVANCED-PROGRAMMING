package tutorial2;

import java.util.Scanner;

public class ExceptionExample {
	
	public static double findQuotient() throws ArithmeticException{
		
		int firstNumber;
		int secondNumber;
		double quotient = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		firstNumber = input.nextInt();
		
		System.out.print("Enter second number: ");
		secondNumber = input.nextInt();
		
		quotient = firstNumber/secondNumber;
		return quotient;
		
	}
	
	public static double analyze() {
		double quotient = 0;
		try {
			quotient = findQuotient();
		}catch(ArithmeticException ex) {
			throw ex;
		}
		return quotient;
	}
}
