package persistence_RAF;
import java.util.Scanner;

public class Employee extends Person {

	private int empnum;
	private	double basic_pay;
	private	double allowance;
	private	double deduction;
	private Scanner input = null;
	
	public Employee(Employee e) {
		super(e);
		this.empnum = e.empnum;		
		this.basic_pay = e.basic_pay;
		this.allowance = e.allowance;
		this.deduction = e.deduction;
	}
	public Employee(){
		super();
		this.empnum = 0;		
		this.basic_pay = 0;
		this.allowance = 0;
		this.deduction = 0;
	}		
	public Employee(int empnum){
		this.empnum = empnum;	
	}		
	public Employee(int empnum, String f_name, String l_name, String address, double basic_pay, double allowance){
		super(f_name, l_name, address);
		this.empnum = empnum;
		this.basic_pay = basic_pay;
		this.allowance = allowance;
		this.deduction = (double) ((basic_pay + allowance) * 0.33);
	}	
	public void setEmployeeNum(int empnum){
		this.empnum = empnum;
	}
	public void setAllowance(double allowance){
		this.allowance = allowance;
	}
	public void setBasicPay(double basic_pay){
		this.basic_pay = basic_pay;
	}
	public void setDeduction(double deduction){
		this.deduction = deduction;
	}
	public double getAllowance(){
		return this.allowance;
	}
	public double getBasicPay(){
		return this.basic_pay;
	}
	public double getDeduction(){
		if(deduction == 0){
			return (this.basic_pay+this.allowance) * 0.33;
		}else{
			return deduction;
		}
	}	
	public int getEmployeeNum(){
		return this.empnum;
	}	
	public void report(){
		System.out.println(this.empnum + "\t" + this.f_name+" "+ this.l_name +"\t\t"+this.address+"\t\t"+this.basic_pay+
		" \t"+this.allowance+"\t"+(allowance + basic_pay)+ "\t"+ getDeduction() + "\t" + ((allowance + basic_pay)- getDeduction()));
	}
	
	@Override
	public String toString() {
		return empnum + "\t" + f_name + " " + l_name+ "\t" + address + basic_pay + "\t" + allowance + "\t" + deduction + "\n";
	}

	public void printData(){
		System.out.println("\n\nEmployee ID: " +this.empnum);
		System.out.println("Name :\t\t"+this.f_name + " " + this.l_name);
		System.out.println("Address :\t"+this.address);
		System.out.println("Basic Salary :\t$"+this.basic_pay);
		System.out.println("Allowence :\t$"+this.allowance);
		System.out.println("Total Salary :\t$"+(this.basic_pay + this.allowance));
		System.out.println("Deductions :\t$"+this.getDeduction());	        
		System.out.println("Net Pay :\t$"+ ((this.basic_pay + this.allowance ) - this.getDeduction()));
		System.out.println();
	}
	
	public boolean ifExists(int id_num){ //Function to check if a Employee ID is already taken
		Employee e = new Employee();
		boolean flag = false;
		
	    while(true){
			if(e.getEmployeeNum() == id_num){					
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public void getEmployeeData(){	
		input = new Scanner(System.in);
		
		System.out.println("===== Enter New Record =====\n");
        
		System.out.println("Employee ID :\t"); 
		if(input.hasNextInt()) {
			this.empnum = input.nextInt();
		}
		
        //while (ifExists(this.empnum)){
        //	System.out.println("\nThe employee Id is already taken.\nPlease enter a different ID: ");
        //	this.empnum = input.nextInt();
		//}			
        System.out.println("\nFirst Name :\t"); this.f_name = input.next();
        System.out.println("\nLast Name :\t"); this.l_name = input.next();
        System.out.println("\nAddress :\t"); this.address = input.next();
        System.out.println("\nBasic Salary :\t"); this.basic_pay = input.nextDouble();
        System.out.println("\nAllowence :\t"); this.allowance = input.nextDouble();		        
        System.out.println();
        
        return;
	}
	
	public void getModifiedData(){	
		input = new Scanner(System.in);
		System.out.println("===== Enter Modified Data =====\n");
        		
		System.out.println("First Name :\t"); 		
		if(input.hasNext()) {
			this.f_name = input.next();
		}
        System.out.println("\nLast Name :\t"); this.l_name = input.next();
		System.out.println("\nAddress :\t"); this.address = input.next();
		System.out.println("\nBasic Salary :\t"); this.basic_pay = input.nextDouble();  
		System.out.println("\nAllowence :\t"); this.allowance = input.nextDouble();		        
		System.out.println();
		return;
	}
			
			
}
