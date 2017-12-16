package com.htc.bankapp.main;


import com.htc.bankapp.dao.BankOperationsImpl;
import com.htc.bankapp.dto.Bank;
import com.htc.bankapp.dto.BankAccount;
import com.htc.bankapp.exceptions.InvalidAccountNumberException;

public class ExceptionMain {
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
		try {
			System.out.println("before exception statement");
			System.out.println("Account: "+bankOperations.getAccount("1234"));
			System.out.println("after exception statement");
		} catch (InvalidAccountNumberException e) {
			System.out.println("inside catch block");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("inside finally block");
		}
		System.out.println("after finally statement");
	}

}
