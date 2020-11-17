package com.human.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.human.dto.ProDto;
import com.human.util.DBConn;

public class ProDao {
	public ProDao() {

	}

	private static ProDao instance = new ProDao();

	public static ProDao getInstance() {
		return instance;
	}

	// ----------------------------selecttop------------------------------------
	public ArrayList<ProDto> selecttop() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=999";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}//select * from '���̺��̸�' where dressname like '%�˻��� �̸�%';

	// ----------------------------selectmidd------------------------------------
	public ArrayList<ProDto> selectmidd() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=998";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// ----------------------------selectbottom------------------------------------
	public ArrayList<ProDto> selectbottom() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=997";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// --------------dressDetailsCommand------------------
	public ProDto select(String dressid) {
		ProDto dto = null;
		Connection con = DBConn.getConnection();
		String sql = String.format("select * from dress where dressid='%s'", dressid);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dto = new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg"));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// ----------------------------outer------------------------------------------
	public ArrayList<ProDto> selectouter() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=1";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// ----------------------------selectcategoryshipts------------------------------------------
	public ArrayList<ProDto> selectcategoryshipts() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=2";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// ----------------------------selectcategorytee------------------------------------------
	public ArrayList<ProDto> selectcategorytee() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=3";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// ----------------------------selectselectcategorybottom------------------------------------------
	public ArrayList<ProDto> selectcategorybottom() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=4";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// ----------------------------selectselectcategoryacc------------------------------------------
	public ArrayList<ProDto> selectselectcategoryacc() {
		ArrayList<ProDto> dtos = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = "select * from dress where categoryId=5";
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dtos.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	// ----------------------------------Search----------------------------------
	public ArrayList<ProDto> selectSearch(String search) {
		ArrayList<ProDto> Search = new ArrayList<>();
		Connection con = DBConn.getConnection();
		String sql = String.format("select * from dress where dressname like '%%%s%%'", search);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Search.add(new ProDto(rs.getInt("dressid"), rs.getString("dressname"), rs.getInt("categoryid"),
						rs.getInt("price"), rs.getString("companyid"), rs.getInt("amount"), rs.getString("dressimg")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Search;
	}

	// ----------------------dressUpdate------------------------------------------------
	public void dressupdate(ProDto prodto) {
		String sql = "update dress set dressname=?,price=? where dressid=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, prodto.getDressname());
			System.out.println("������ ��ǰ �̸� : " + prodto.getDressname());
			pstmt.setInt(2, prodto.getPrice());
			System.out.println("������ ��ǰ ���� : " + prodto.getPrice());
			pstmt.setInt(3, prodto.getDressid());
			System.out.println("������ ��ǰ ���̵� : " + prodto.getDressid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

}