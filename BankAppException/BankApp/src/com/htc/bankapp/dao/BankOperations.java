package com.htc.bankapp.dao;

import com.htc.bankapp.dto.BankAccount;
import com.htc.bankapp.exceptions.InvalidAccountNumberException;

public interface BankOperations {

	//public BankAccount getAccount(String accountNo);
	public BankAccount getAccount(String accountNo)throws InvalidAccountNumberException;
	public double getBalance(String accountNo)throws InvalidAccountNumberException ;
	public boolean withdraw(String accountNo,double amount)throws InvalidAccountNumberException ;
	public boolean deposit(String accountNo, double amount)throws InvalidAccountNumberException ;
	public boolean transfer(String fromAccountNo,String toAccountNo,double amount)throws InvalidAccountNumberException ;
}
