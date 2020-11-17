package com.human.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.human.dto.CartVO;
import com.human.dto.QandAVo;
import com.human.util.DBConn;

public class QandADao {

	public QandADao() {
	}

	private static QandADao instance = new QandADao();

	public static QandADao getInstance() {
		return instance;
	}

	// Q&A 등록
	public void insertQandA(QandAVo qandAVo) {
		String sql = "insert into tbl_QANDA(qandaid,qandatitle,qandacontent,id,dressid) VALUES(tbl_QANDA_seq.nextval,?,?,?,?)";

		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qandAVo.getQandatitle());
			pstmt.setString(2, qandAVo.getQandacontent());
			pstmt.setString(3, qandAVo.getId());
			pstmt.setInt(4, qandAVo.getDressid());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

	// Q&A 출력
	// ------------------------------------------------------------------------------------------------

	public ArrayList<QandAVo> QandASelete(String dressid) {
		ArrayList<QandAVo> dressDetails = new ArrayList<QandAVo>();
		Connection con = DBConn.getConnection();
		System.out.println("상품 번호:" + dressid + " 의 Q&A 출력");
		String sql = String.format("select * from tbl_QANDA where dressid='%s' order by qandaid desc", dressid);
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				dressDetails.add(new QandAVo(rs.getInt("qandaid"), rs.getString("qandatitle"),
						rs.getString("qandacontent"), rs.getTimestamp("qandadate"), rs.getString("qandareply"),
						rs.getString("id"), rs.getInt("dressid")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dressDetails;
	}

	// -------------------------Q&A delete---------------------
	public void QandAdelete(String qandaid, String id) {
		// TODO Auto-generated method stub
		String sql = "delete tbl_QANDA where qandaid=? and id=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qandaid);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}

	}

	// -------------------------관리자 페이지 모든 QandA 리스트 출력
	public ArrayList<QandAVo> QandAallSelete() {
		// TODO Auto-generated method stub
		ArrayList<QandAVo> QandAallList = new ArrayList<QandAVo>();
		Connection con = DBConn.getConnection();
		String sql = "select * from tbl_QANDA order by qandaid desc";
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				QandAallList.add(new QandAVo(rs.getInt("qandaid"), rs.getString("qandatitle"),
						rs.getString("qandacontent"), rs.getTimestamp("qandadate"), rs.getString("qandareply"),
						rs.getString("id"), rs.getInt("dressid")));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return QandAallList;
	}

// 수정할 QANDA게시물 출력---------------------------------------
	public QandAVo UpdateQandA(int qandaid) {
// TODO Auto-generated method stub
		QandAVo updateQandA = null;
		Connection con = DBConn.getConnection();
		String sql = String.format("select * from tbl_QANDA where qandaid=%d", qandaid);
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				updateQandA = new QandAVo(rs.getInt("qandaid"), rs.getString("qandatitle"),
						rs.getString("qandacontent"), rs.getTimestamp("qandadate"), rs.getString("qandareply"),
						rs.getString("id"), rs.getInt("dressid"));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateQandA;
	}

	public void QandAreply(QandAVo qandaVo) {
		// TODO Auto-generated method stub
		String sql = "update tbl_QANDA set qandareply=? where qandaid=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qandaVo.getQandareply());
			System.out.println("관리자 답글 : " + qandaVo.getQandareply());
			pstmt.setInt(2, qandaVo.getQandaid());
			System.out.println("답글 완료 게시글 " + qandaVo.getQandaid() + "번째 게시물");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

}
