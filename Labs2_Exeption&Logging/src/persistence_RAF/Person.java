package persistence_RAF;

public class Person {
	protected String f_name;
	protected String l_name;
	protected String address;
	
	public Person(Person p) {
		this.f_name = p.f_name;
		this.l_name = p.l_name;
		this.address = p.address;
	}
	public Person(){
		this.f_name = "";
		this.l_name = "";
		this.address = "";
	}
	public Person(String f_name, String l_name, String address){
		this.f_name = f_name;
		this.l_name = l_name;
		this.address = address;
	}
	
	public void setFirstName(String f_name){ 
		this.f_name = f_name;
	}
	public void setLastName(String l_name){ 
		this.l_name = l_name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getFirstName(){
		return this.f_name;
	}
	public String getLastName(){
		return this.l_name;
	}
	public String getAddress(){
		return this.address;
	}
}
