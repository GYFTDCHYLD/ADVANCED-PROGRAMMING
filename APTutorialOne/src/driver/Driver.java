package driver;

import domain.Employee;
import domain.PartTimeEmployee;
import domain.Payable;

public class Driver {

	public static void main(String[] args) {
		PartTimeEmployee tempEmp = new PartTimeEmployee("1209745","Jenny Public","1(876)654-9876", 0,10.5);
		Payable taxPayer = tempEmp;
		double overTime = taxPayer.calculateOverTime();
		
		System.out.println("Over-time pay: " + overTime + "\n");
		System.out.println(taxPayer);
		
		Employee emp = (Employee) taxPayer;
		double salary = emp.calculatePay();
		System.out.println(emp);
	}

}
