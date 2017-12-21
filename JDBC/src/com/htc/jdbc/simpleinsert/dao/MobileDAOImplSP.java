package com.htc.jdbc.simpleinsert.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.htc.jdbc.connector.DBConnector;
import com.htc.jdbc.simpleinsert.DTO.MobileDTO;

public class MobileDAOImplSP implements MobileDAO{

	@Override
	public boolean insertMobile(MobileDTO newMobile) throws SQLException {
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{call INSERTMOBILE1(?,?,?,?,?)}");
		
		cstmt.setInt(1, newMobile.getIEMI());
		cstmt.setString(2, newMobile.getModel());
		cstmt.setString(3, newMobile.getBrand());
		cstmt.setDouble(4, newMobile.getCost());
		cstmt.registerOutParameter(5, java.sql.Types.BOOLEAN);
		System.out.println(cstmt.executeUpdate());
		return false;
	}

	@Override
	public boolean deleteMobile(int IEMI) throws SQLException {
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{call DELETEMOBILE(?)}");
		cstmt.setInt(1,IEMI);
		return cstmt.execute();
	}

	@Override
	public boolean updateMobile(int IEMI, MobileDTO updatedMobile) throws SQLException {
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{call UPDATEMOBILE(?,?,?,?)}");
		
		cstmt.setInt(1, IEMI);
		cstmt.setString(2, updatedMobile.getModel());
		cstmt.setString(3, updatedMobile.getBrand());
		cstmt.setDouble(4, updatedMobile.getCost());
		
		
		return cstmt.execute();
	}

	@Override
	public MobileDTO getMobile(int IEMI) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MobileDTO> getAllMobiles() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
