package com.exception;

//Exercise six
public class MyException extends Exception{
	private String Message;

	public MyException(String message) {
		super(message);
		this.Message = message;
	}

	public String getMessage() {
		return Message;
	}
	
}
