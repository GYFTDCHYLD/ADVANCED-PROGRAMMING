package Domain;

import java.io.Serializable;

public class Employee implements Serializable
{
	private String name;
	private String address;
	private String trn;
	private String phoneNumber;
	private Date date;
	
	//default constructor()
public	Employee(String name,String address, String trn, String phoneNumber, Date date )
	{
		this.name = name;
		this.address = address;
		this.trn = trn;
		this.phoneNumber = phoneNumber;
		this.date = date;
		
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", trn=" + trn + ", phoneNumber=" + phoneNumber
				+ ", date=" + date + "]";
	}
	

}
