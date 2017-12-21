package com.htc.jdbc.simpleinsert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.htc.jdbc.connector.DBConnector;
import com.htc.jdbc.simpleinsert.DTO.MobileDTO;

public class MobileDAOImpl implements MobileDAO {

	@Override
	public boolean insertMobile(MobileDTO newMobile) throws SQLException {
		boolean insertFlag = false;

		Connection con = DBConnector.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO Mobile(IEMI,model,brand,cost) VALUES(?,?,?,?)");
		ps.setInt(1, newMobile.getIEMI());
		ps.setString(2, newMobile.getModel());
		ps.setString(3, newMobile.getBrand());
		ps.setDouble(4, newMobile.getCost());

		insertFlag = !ps.execute(); //true if the first result is a ResultSet object; false if the first result is an update count or there is no result

		return insertFlag;
	}

	@Override
	public boolean deleteMobile(int IEMI) throws SQLException {
		boolean deleteFlag = false;
		Connection con = DBConnector.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM Mobile WHERE IEMI=?");
		ps.setInt(1, IEMI);
		deleteFlag = !ps.execute();   //true if the first result is a ResultSet object; false if the first result is an update count or there is no result
		return deleteFlag;
	}

	@Override
	public boolean updateMobile(int IEMI, MobileDTO updatedMobile) throws SQLException {
		boolean updateFlag = false;

		Connection con = DBConnector.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE Mobile SET model=?,brand=?,cost=? WHERE IEMI=?");
		ps.setString(1, updatedMobile.getModel());
		ps.setString(2, updatedMobile.getBrand());
		ps.setDouble(3, updatedMobile.getCost());
		ps.setInt(4, IEMI);

		updateFlag = !ps.execute(); //true if the first result is a ResultSet object; false if the first result is an update count or there is no result
		return updateFlag;
	}

	@Override
	public MobileDTO getMobile(int IEMI) throws SQLException {
		MobileDTO mobile = null;
		Connection con = DBConnector.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT model,brand,cost FROM Mobile WHERE IEMI=?");
		ps.setInt(1, IEMI);
		ResultSet rs = ps.executeQuery();
		rs.next();  // to point the first record in the result set
		mobile = new MobileDTO(IEMI, rs.getString(1), rs.getString(2), rs.getDouble(3));
		return mobile;
	}

	@Override
	public ArrayList<MobileDTO> getAllMobiles() throws SQLException {
		ArrayList<MobileDTO> mobiles = new ArrayList<>();
		Connection con=DBConnector.getConnection();
		Statement stmt=con.createStatement(); 
		ResultSet rs=stmt.executeQuery("SELECT IEMI,model,brand,cost FROM Mobile");
		while(rs.next()) {
			mobiles.add(new MobileDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}
		return mobiles;
	}

}
