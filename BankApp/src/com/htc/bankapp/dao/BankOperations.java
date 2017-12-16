package com.htc.bankapp.dao;

import com.htc.bankapp.dto.BankAccount;

public interface BankOperations {

	public BankAccount getAccount(String accountNo);
	public double getBalance(String accountNo);
	public boolean withdraw(String accountNo,double amount);
	public boolean deposit(String accountNo, double amount);
	public boolean transfer(String fromAccountNo,String toAccountNo,double amount);
}
