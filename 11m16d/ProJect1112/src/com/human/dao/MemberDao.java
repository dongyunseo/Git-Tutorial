package com.human.dao;

import com.human.dto.MemberVo;
import com.human.util.DBConn;

import java.sql.*;

public class MemberDao {

	public int checkId(String id) {
		DBConn.getInstance();
		int result = 0;
		String sql = "select id from customer where id='" + id + "'";
		System.out.println(sql);
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			if (rs.next()) {
				result = 1;
				System.out.println(id + " = 존재합니다. ");
				
			} else {
				result = -1;
				System.out.println(id + " 로 회원가입이 가능합니다. ");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		DBConn.dbClose();
		return result;
	}

	public void insertNewJoin(String id, String pwd, String name, String email, String zip_num, String address,
			String phone) {
		Connection conn = null;
		Statement stmt;

		String sql = "insert into customer(id,pwd,name,email,zip_num,address,phone) values('%s','%s','%s','%s','%s','%s','%s')";

		sql = String.format(sql, id, pwd, name, email, zip_num, address, phone);
		try {
			conn = DBConn.getInstance();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			stmt.executeUpdate(sql);
			System.out.println(sql);
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		DBConn.dbClose();

	}

	public String login(String id, String pwd, MemberVo memberVo) {
		String result = "";
		if (id == null && pwd == null) {
			return result;
		}
		DBConn.getInstance();
		String sql = "select name, useyn, Id from customer where Id = '" + id + "' AND pwd='" + pwd + "'";
		System.out.println(sql);
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			if (rs.next()) {
				memberVo.setName(rs.getString("name"));
				memberVo.setUseyn(rs.getString("useyn"));
				memberVo.setId(rs.getString("id"));
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

	public MemberVo GetId(String name, String email) {
		// TODO Auto-generated method stub
		MemberVo dtoid = null;
		Connection con = DBConn.getConnection();
		String sql = String.format("select * from customer where name='%s' and email='%s'", name, email);
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtoid = new MemberVo(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("email"), rs.getString("zip_num"), rs.getString("address"), rs.getString("phone"),
						rs.getString("useyn"), rs.getTimestamp("indate"));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoid;
	}
}

//		// personalInfo �뜝�럥�뱺�뜝�럡�맋 �뜝�럥�닡�뜝�럩�뭵�뜝�럥由� update 占쎈쐩占쎈닑占쎈뉴 �뜝�럡�돮�슖�댙�삕 嶺뚮씭�뒧甕곤옙.
//		public int update(MemberDto mDto) {
//
//			int returnValue = 0;
//			DBConn.getInstance();
//			String sql = "update newCustomer set newPw='%s', newDate='%s' where NEWID='%s'";
//
//			sql = String.format(sql, mDto.getNewPw(), getDate(), mDto.getNewID());
//			System.out.println(sql);
//
//			returnValue = DBConn.statementUpdate(sql);
//			DBConn.dbClose();
//			return returnValue;
//		}
