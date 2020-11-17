package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.human.dto.AdminVO;
import com.human.util.DBConn;

public class AdminDao {
	
	public String login(String id, String pwd, AdminVO adminVO) {
		
		String result = "";
		
		if (id == null && pwd == null) {
			return result;
		}
		DBConn.getInstance();
		String sql = "select Id from admin where Id = '" + id + "' AND pwd='" + pwd + "'";
		System.out.println(sql);
		ResultSet rs = DBConn.statementQuery(sql);
		
		try {
			if (rs.next()) {
				adminVO.setId(rs.getString("id"));
				result = "1";
			} else {
				result = "0";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		DBConn.dbClose();
		return result;

	}
}
