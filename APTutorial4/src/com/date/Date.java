package com.date;

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

	
	public String toString() {
		return Day + "/" + Month + "/" + Year;
	}
}
