package com.htc.bankapp.dto;

public class BankAccount {

	// properties
	private String accountNo;
	private String name;
	private double balance;
	
	//getters & setters
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// Constructors
	public BankAccount(String accountNo, String name, double balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	public BankAccount(String accountNo, String name) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 1000.00;
	}
	public BankAccount() {
		this.balance=1000.00;
	}
	//tostring method
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
