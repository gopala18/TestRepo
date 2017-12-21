package com.htc.jdbc.simpleinsert.DTO;

public class MobileDTO {
	private int IEMI;
	private String model;
	private String brand;
	private double cost;
	
	public MobileDTO(int iEMI, String model, String brand, double cost) {
		super();
		IEMI = iEMI;
		this.model = model;
		this.brand = brand;
		this.cost = cost;
	}
	public MobileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIEMI() {
		return IEMI;
	}
	public void setIEMI(int iEMI) {
		IEMI = iEMI;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Mobile [IEMI=" + IEMI + ", model=" + model + ", brand=" + brand + ", cost=" + cost + "]";
	}
	
	

}
