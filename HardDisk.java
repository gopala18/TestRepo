package com.htc.corejava.dto;

import java.time.LocalDate;

public class HardDisk {

	private int hardDiskNo;
	private String brand;
	private LocalDate mfgDate;
	private String capacity;
	public HardDisk(int hardDiskNo, String brand, String capacity, LocalDate mfgDate) {
		super();
		this.hardDiskNo = hardDiskNo;
		this.brand = brand;
		this.mfgDate = mfgDate;
		this.capacity = capacity;
	}
	public HardDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHardDiskNo() {
		return hardDiskNo;
	}
	public void setHardDiskNo(int hardDiskNo) {
		this.hardDiskNo = hardDiskNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public LocalDate getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hardDiskNo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HardDisk other = (HardDisk) obj;
		if (hardDiskNo != other.hardDiskNo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HardDisk [hardDiskNo=" + hardDiskNo + ", brand=" + brand + ", mfgDate=" + mfgDate + ", capacity="
				+ capacity + "]";
	}
	
	
}
