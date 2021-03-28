package tutorial2;

public class Driver {

	public static void main(String[] args) {
		try {
			double quotient = ExceptionExample.analyze();;
			System.out.println("The quotient of the two numbers is: " + quotient);
		}catch(ArithmeticException ex) {
			System.err.println("Division by zero is illigal" );
		}
	}

}
