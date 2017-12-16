package com.htc.bankapp.dao;

import com.htc.bankapp.dto.Bank;
import com.htc.bankapp.dto.BankAccount;
import com.htc.bankapp.exceptions.InvalidAccountNumberException;

public class BankOperationsImpl implements BankOperations{
	private Bank bank;
	
	
	public void setBank(Bank bank) {
		this.bank = bank;
		System.out.println(bank.toString());
	}

	@Override
	public BankAccount getAccount(String accountNo)throws InvalidAccountNumberException {
		BankAccount foundAccount=null;
		for(BankAccount bankAccount:this.bank.getBankAccounts()) {
			if(bankAccount!=null && bankAccount.getAccountNo().equals(accountNo)) {
				foundAccount=bankAccount;
				break;
			}
		}
		if(foundAccount==null) {
			throw new InvalidAccountNumberException();
		}
		return foundAccount;
	}

	
	/*@Override
	public BankAccount getAccount(String accountNo) {
		BankAccount foundAccount=null;
		for(BankAccount bankAccount:this.bank.getBankAccounts()) {
			if(bankAccount.getAccountNo().equals(accountNo)) {
				foundAccount=bankAccount;
				break;
			}
		}
		return foundAccount;
	}
*/
	@Override
	public double getBalance(String accountNo)throws InvalidAccountNumberException  {
		BankAccount bankAccount=null;
		double balance=0.0;
		bankAccount=this.getAccount(accountNo);
		balance=bankAccount.getBalance();
		return balance;
		//return this.getAccount(accountNo).getBalance();
	}

	@Override
	public boolean withdraw(String accountNo, double amount)throws InvalidAccountNumberException  {
		BankAccount bankAccount=null;
		bankAccount=this.getAccount(accountNo);
		boolean withdrawFlag=false;
		
		if(bankAccount.getBalance()>amount) {
			double newBalance=bankAccount.getBalance()-amount;
			bankAccount.setBalance(newBalance);
			withdrawFlag=true;
		}
		return withdrawFlag;
	}

	@Override
	public boolean deposit(String accountNo, double amount)throws InvalidAccountNumberException  {
		BankAccount bankAccount=null;
		bankAccount=this.getAccount(accountNo);
		boolean depositFlag=false;
		
		if(bankAccount!=null) {
			double newBalance=bankAccount.getBalance()+amount;
			bankAccount.setBalance(newBalance);
			depositFlag=true;
	}
		return depositFlag;
	}

	@Override
	public boolean transfer(String fromAccountNo, String toAccountNo, double amount)throws InvalidAccountNumberException  {
		boolean transferFlag=false;
		
		
		if(this.withdraw(fromAccountNo, amount)) {
			if(this.deposit(toAccountNo, amount)) {
				transferFlag=true;
			}else {
				this.deposit(fromAccountNo, amount);
			}
		}
		
		return transferFlag;
	}

}
