package com.htc.bankapp.dto;

import java.util.Arrays;

public class Bank {

	//properties
	private String IFSI;
	private String name;
	private String branch;
	private BankAccount[] BankAccounts;
	public String getIFSI() {
		return IFSI;
	}
	public void setIFSI(String iFSI) {
		IFSI = iFSI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public BankAccount[] getBankAccounts() {
		return BankAccounts;
	}
	public void setBankAccounts(BankAccount[] bankAccounts) {
		BankAccounts = bankAccounts;
	}
	public Bank(String iFSI, String name, String branch, BankAccount[] bankAccounts) {
		super();
		IFSI = iFSI;
		this.name = name;
		this.branch = branch;
		BankAccounts = bankAccounts;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [IFSI=" + IFSI + ", name=" + name + ", branch=" + branch + ", BankAccounts="
				+ Arrays.toString(BankAccounts) + "]";
	}
	
	
	}
