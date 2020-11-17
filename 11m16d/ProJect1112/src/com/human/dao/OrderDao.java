package com.human.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.human.dto.OrderVO;
import com.human.util.DBConn;

public class OrderDao {

	public OrderDao() {

	}

	private static OrderDao instance = new OrderDao();

	public static OrderDao getInstance() {
		return instance;
	}

	// -------------------- �ֹ� ���-------------------
	public void OrderInsert(OrderVO orderVo) {
		String sql = "insert into tbl_order(ordernum,id,dressid,dressimg,dressname,price,amount,sum,"
				+ "ordername,address,phone,email,orderMessage,depositor,Bank,delivery)"
				+ "VALUES(tbl_order_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'입금 전')";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderVo.getId());
			System.out.println("�ֹ��� ���̵� : " + orderVo.getId());
			pstmt.setInt(2, orderVo.getDressid());
			System.out.println("��ǰ �ѹ� :" + orderVo.getDressid());
			pstmt.setString(3, orderVo.getDressimg());
			System.out.println("��ǰ �̹��� �ּ� : " + orderVo.getDressimg());
			pstmt.setString(4, orderVo.getDressname());
			System.out.println("��ǰ �̸� : " + orderVo.getDressname());
			pstmt.setInt(5, orderVo.getPrice());
			System.out.println("��ǰ ���� : " + orderVo.getPrice());
			pstmt.setInt(6, orderVo.getAmount());
			System.out.println("��ǰ ���� : " + orderVo.getAmount());
			pstmt.setInt(7, orderVo.getSum());
			System.out.println("�� �ݾ�  : " + orderVo.getSum());
			pstmt.setString(8, orderVo.getOrdername());
			System.out.println("�ֹ��� �̸�  : " + orderVo.getOrdername());
			pstmt.setString(9, orderVo.getAddress());
			System.out.println("�ּ� : " + orderVo.getAddress());
			pstmt.setString(10, orderVo.getPhone());
			System.out.println("��ȭ ��ȣ  : " + orderVo.getPhone());
			pstmt.setString(11, orderVo.getEmail());
			System.out.println("�̸��� : " + orderVo.getEmail());
			pstmt.setString(12, orderVo.getOrderMessage());
			System.out.println("�ֹ� �޽��� : " + orderVo.getOrderMessage());
			pstmt.setString(13, orderVo.getDepositor());
			System.out.println("�Ա��� �� : " + orderVo.getDepositor());
			pstmt.setString(14, orderVo.getBank());
			System.out.println("�Ա� ���� : " + orderVo.getBank());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

	// ------------------�ֹ� ����Ʈ ���� �ϱ����� �ֹ������� null �� ���� ���� -----------------
	public void OrderHalfNullDelete() {
		String sql = "delete from tbl_order where ordername IS NULL";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

	// ------------------�ֹ� ����Ʈ ��� select -------------------------------
	public ArrayList<OrderVO> OrderList(String userId) {
		ArrayList<OrderVO> ListOrder = new ArrayList<OrderVO>();
		Connection conn = DBConn.getConnection();
		String sql = String.format("select * from tbl_order where id='%s'order by orderDate desc", userId);
		/*	String sql = String.format("select tbl_order.ordernum, tbl_order.id, tbl_order.dressid,tbl_order.dressName, "
				+ "tbl_order.price,tbl_order.amount,tbl_order.sum,tbl_order.ordername,tbl_order.address,tbl_order.phone,"
				+ "tbl_order.email,tbl_order.orderMessage ,tbl_order.depositor ,tbl_order.bank, tbl_order.delivery,tbl_order.orderDate, "
				+ "dress.dressimg from tbl_order,dress where ordername IS NOT NULL and tbl_order.dressid = dress.dressid and id ='%s'order by ordernum desc",
				userId);*/
		System.out.println(sql);

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ListOrder.add(new OrderVO(rs.getInt("ordernum"), rs.getString("id"), rs.getInt("dressid"),
						rs.getString("dressname"), rs.getInt("price"), rs.getInt("amount"), rs.getInt("sum"),
						rs.getString("ordername"), rs.getString("address"), rs.getString("phone"),
						rs.getString("email"), rs.getString("orderMessage"), rs.getString("depositor"),
						rs.getString("Bank"), rs.getString("delivery"), rs.getTimestamp("orderDate"),
						rs.getString("dressimg")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListOrder;
	}

//--------------------�ֹ� ���̺� ���� ------------------------------
	public void OrderDelete(int ordernum) {
		String sql = "delete tbl_order where ordernum=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordernum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

	// ���----------------------------
	public void OrderHalf(OrderVO orderVo) {
		String sql = "insert into tbl_order(ordernum,id,dressimg,dressid,dressname,price,amount,sum)"
				+ "VALUES(tbl_order_seq.nextval,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderVo.getId());
			System.out.println("�ֹ��� ���̵� : " + orderVo.getId());
			pstmt.setString(2, orderVo.getDressimg());
			System.out.println("�̹��� ��� : " + orderVo.getDressimg());
			pstmt.setInt(3, orderVo.getDressid());
			System.out.println("��ǰ �ѹ� :" + orderVo.getDressid());
			pstmt.setString(4, orderVo.getDressname());
			System.out.println("��ǰ �̸� : " + orderVo.getDressname());
			pstmt.setInt(5, orderVo.getPrice());
			System.out.println("��ǰ ���� : " + orderVo.getPrice());
			pstmt.setInt(6, orderVo.getAmount());
			System.out.println("��ǰ ���� : " + orderVo.getAmount());
			pstmt.setInt(7, orderVo.getSum());
			System.out.println("�� �ݾ�  : " + orderVo.getSum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

// ������ ���������� �ֹ� ���̺� ��ü ���---------------------------------------------------------
	public ArrayList<OrderVO> AdminAllOrderList() {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> adminAllListOrder = new ArrayList<OrderVO>();
		Connection conn = DBConn.getConnection();
		String sql = "select * from tbl_order order by ordernum desc";

		System.out.println(sql);

		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				adminAllListOrder.add(new OrderVO(rs.getInt("ordernum"), rs.getString("id"), rs.getInt("dressid"),
						rs.getString("dressname"), rs.getInt("price"), rs.getInt("amount"), rs.getInt("sum"),
						rs.getString("ordername"), rs.getString("address"), rs.getString("phone"),
						rs.getString("email"), rs.getString("orderMessage"), rs.getString("depositor"),
						rs.getString("Bank"), rs.getString("delivery"), rs.getTimestamp("orderDate"),
						rs.getString("dressimg")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminAllListOrder;
	}

//���並 �ۼ��ϱ� �� �α����� ����ڰ� ��ǰ�� �ֹ��� �������� �����ۼ��� �� �� �ִ�.-----------------------
	public int checkOrder(String id, String dressid) {
		// TODO Auto-generated method stub
		DBConn.getInstance();
		int result = 0;
		String sql = "select * from tbl_order where id='" + id + "' and dressid='" + dressid + "'";
		System.out.println(sql);
		ResultSet rs = DBConn.statementQuery(sql);

		try {
			if (rs.next()) {
				result = 1;
				System.out.println(id + " ���� " + dressid + "�� ��ǰ�� �ֹ� �߽��ϴ�. ");
			} else {
				result = -1;
				System.out.println(id + " ���� " + dressid + "�� ��ǰ�� �ֹ� �� �����Ͱ� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		DBConn.dbClose();
		return result;
	}
}