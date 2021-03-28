package domain;


public class PartTimeEmployee extends Employee implements Payable {
	private final double BASICPAYRATE = 3575.65; // hourly pay rate
	private double overTimePay;
	
	
	public PartTimeEmployee() {
		super();
		this.overTimePay = 0;
	}
	
	public PartTimeEmployee(String id, String name, String phone, double salary, double hoursWorked) {
		super(id,  name, phone, salary, hoursWorked);
	}
	
	public PartTimeEmployee(String id, String name, String phone, double hoursWorked) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.hoursWorked = hoursWorked;
	}
	
	public double calculateOverTime() { 
		overTimePay = (BASICPAYRATE * (hoursWorked - 6) * OVRATE);
		return overTimePay;
	}

	@Override
	public double calculatePay() {
		if(hoursWorked <= 6) {
			return BASICPAYRATE * hoursWorked;
		} 
		return salary = BASICPAYRATE * 6 + calculateOverTime();
		
		
	}

}
