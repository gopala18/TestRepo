package com.htc.jdbc.simpleinsert.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.htc.jdbc.simpleinsert.DTO.MobileDTO;

public interface MobileDAO {

	public boolean insertMobile(MobileDTO newMobile) throws SQLException;
	public boolean deleteMobile(int IEMI)throws SQLException;
	public boolean updateMobile(int IEMI,MobileDTO updatedMobile)throws SQLException;
	public MobileDTO getMobile(int IEMI)throws SQLException;
	public ArrayList<MobileDTO> getAllMobiles()throws SQLException;
	
	
	
}
