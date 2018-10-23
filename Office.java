package com.htc.corejava.dto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.htc.corejava.dao.IOfficeServiceProvider;
import com.htc.corejava.util.DBConnector;

public class Office implements Serializable, IOfficeServiceProvider {

	private int officeId;
	private String officeName;
	private List<Computer> computers = new ArrayList<Computer>();

	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Office(int officeId, String officeName, List<Computer> computers) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.computers = computers;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + officeId;
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
		Office other = (Office) obj;
		if (officeId != other.officeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", officeName=" + officeName + ", computers=" + computers + "]";
	}
	
	
	
	
	/* Uncomment the below methods for the implementation with ArrayList  */
	
/*
	@Override
	public boolean createComputer(Computer computer) {
		boolean createFlag = false;
		if (!this.getComputers().contains(computer)) {
			this.getComputers().add(computer);
			createFlag = true;
		}
		return createFlag;
	}

	@Override
	public Computer readComputer(int compId) {
		Computer foundComputer = null;
		for (Computer comp : this.getComputers()) {
			if (comp.getComputerId() == compId) {
				foundComputer = comp;
				break;
			}
		}
		return foundComputer;
	}

	@Override
	public List<Computer> readComputers() {

		return this.getComputers();
	}

	@Override
	public boolean updateComputer(int compId, Computer updatedComputer) {
		boolean updateFlag = false;
		if (this.getComputers().contains(updatedComputer)) {
			Computer comp = readComputer(compId);
			comp.setComputerId(updatedComputer.getComputerId());
			comp.setComputerName(updatedComputer.getComputerName());
			comp.setHardDisk(updatedComputer.getHardDisk());
			updateFlag = true;
		}
		return updateFlag;
	}

	@Override
	public boolean deleteComputer(int compId) {
		boolean deleteFlag = false;
		for (Computer comp : this.getComputers()) {
			if (comp.getComputerId() == compId) {
				comp = null;
				deleteFlag = true;
				break;
			}
		}
		return deleteFlag;
	}
*/
	@Override
	public ArrayList<Office> deSerializeOffice() throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Office> offices = new ArrayList<>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Office.txt"));
		 
		try {
			while (true) {
				offices.add((Office) ois.readObject());

			}
		} catch (EOFException e) {

			throw e;
		} finally {
			ois.close();
			return offices;
		}

	}

	@Override
	public boolean serializeOffice(Office office) throws FileNotFoundException, IOException {
		boolean serializeFlag = false;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Office.txt"));
		oos.writeObject(office);
		oos.flush();
		oos.close();
		serializeFlag = true;
		return serializeFlag;
	}

	@Override
	public boolean createComputer(Computer computer) throws FileNotFoundException, IOException, SQLException {
		Connection con=DBConnector.getPostgreSQLConnection();
		boolean computerFlag=false;
		boolean officeFlag=false;
		boolean HdFlag=false;
		/* Callable statement to insert hard disk details */
		CallableStatement hd_cstmt=con.prepareCall("{?=call createHardDisk(?,?,?,?)}");
		HardDisk hd=computer.getHardDisk();
		hd_cstmt.registerOutParameter(1, Types.BOOLEAN);
		hd_cstmt.setInt(2, hd.getHardDiskNo());
		hd_cstmt.setString(3, hd.getBrand());
		hd_cstmt.setDate(4,  java.sql.Date.valueOf(hd.getMfgDate())); // converting LocalDate to sqlDate
		hd_cstmt.setString(5, hd.getCapacity());
		hd_cstmt.executeUpdate();
		HdFlag=hd_cstmt.getBoolean(1);
		
		/* Callable statement to insert office details*/
		CallableStatement off_cstmt=con.prepareCall("{?=call createOffice(?,?)}");
		off_cstmt.registerOutParameter(1, Types.BOOLEAN);
		off_cstmt.setInt(2, this.officeId);
		off_cstmt.setString(3, this.officeName);
		off_cstmt.executeUpdate();
		officeFlag=off_cstmt.getBoolean(1);
		
		if(HdFlag && officeFlag) {
			/* Callable statement to insert computer details */
			CallableStatement comp_cstmt=con.prepareCall("{?=call createComputer(?,?,?,?)}");
			comp_cstmt.registerOutParameter(1, Types.BOOLEAN);
			comp_cstmt.setInt(2, computer.getComputerId());
			comp_cstmt.setString(3, computer.getComputerName());
			comp_cstmt.setInt(4, hd.getHardDiskNo());
			comp_cstmt.setInt(5, this.officeId);
			comp_cstmt.executeUpdate();
			computerFlag=comp_cstmt.getBoolean(1);
		}
		
		
		
		return computerFlag;
	}

	@Override
	public Computer readComputer(int compId) throws FileNotFoundException, IOException, SQLException {
		Computer foundComputer=null;
		
		return foundComputer;
	}

	@Override
	public List<Computer> readComputers() throws FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateComputer(int compId, Computer updatedComputer)  throws FileNotFoundException, IOException, SQLException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComputer(int compId) throws FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
