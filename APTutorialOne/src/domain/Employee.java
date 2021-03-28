package domain;

public abstract class Employee {
	
	protected String id;
	protected String name;
	protected String phone;
	protected double salary;
	protected double hoursWorked;
	
	
	public abstract double calculatePay();
	
	public Employee() {
		this.id = "000000";
		this.name = "????";
		this.phone = "0(000)000-0000";
		this.salary = 0.0;
		this.hoursWorked = 0.0;
	}
	
	public Employee(String id, String name, String phone, double salary, double hoursWorked) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.salary = salary;
		this.hoursWorked = hoursWorked;
	}
	
	public Employee(Employee copy) {
		this.id = copy.id;
		this.name = copy.name;
		this.phone = copy.phone;
		this.salary = copy.salary;
		this.hoursWorked = copy.hoursWorked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", salary=" + salary + ", hoursWorked="
				+ hoursWorked + "]";
	}
	
}
