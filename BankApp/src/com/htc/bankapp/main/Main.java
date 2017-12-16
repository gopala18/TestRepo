package com.htc.bankapp.main;

import com.htc.bankapp.dao.BankOperations;
import com.htc.bankapp.dao.BankOperationsImpl;
import com.htc.bankapp.dto.Bank;
import com.htc.bankapp.dto.BankAccount;

public class Main {
	public static void main(String[] args) {
		
		Bank bank=new Bank();
		BankAccount[] bankAccounts=new BankAccount[5];
		
		bankAccounts[0]=new BankAccount("12345","Gopi");
		bankAccounts[1]=new BankAccount("123456","Dev");
		bankAccounts[2]=new BankAccount("1234567","John");
		
		bank.setIFSI("ICIC0012");
		bank.setName("ICICI");
		bank.setBranch("Chennai");
		bank.setBankAccounts(bankAccounts);
		
		BankOperationsImpl bankOperations=new BankOperationsImpl();
		bankOperations.setBank(bank);
		System.out.println("Account: "+bankOperations.getAccount("12345"));
		System.out.println("Balance: "+bankOperations.getBalance("12345"));
		System.out.println("Withdraw: "+bankOperations.withdraw("12345", 500.00));
		System.out.println("Balance after withdraw:"+bankOperations.getBalance("12345"));
		System.out.println("Deposit: "+bankOperations.deposit("12345", 1000.00));
		System.out.println("Balance after deposit: "+bankOperations.getBalance("12345"));
		System.out.println("Transfer:"+bankOperations.transfer("12345", "123456", 1000.00));
		System.out.println("From account Balance: "+bankOperations.getBalance("12345"));
		System.out.println("To account Balance: "+bankOperations.getBalance("123456"));
	}

}
