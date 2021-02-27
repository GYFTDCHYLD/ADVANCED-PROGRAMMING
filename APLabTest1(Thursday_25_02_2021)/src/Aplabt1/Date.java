package Aplabt1;

import java.io.Serializable;

public class Date implements Serializable{
	private int Day;
	private int Month;
	private int Year;
	
	
	public Date() {
		Day = 0;
		Month = 0;
		Year = 0;
	}
	
	public Date(int day, int month, int year) {
		Day = day;
		Month = month;
		Year = year;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	@Override
	public String toString() {
		return Day + " / " + Month + " / " + Year;
	}	

}
