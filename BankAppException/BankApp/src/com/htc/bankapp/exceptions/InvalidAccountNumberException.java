package com.htc.bankapp.exceptions;

public class InvalidAccountNumberException extends Exception {
	String errorMsg="Invalid Account Number !!";

	public InvalidAccountNumberException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidAccountNumberException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	

}
