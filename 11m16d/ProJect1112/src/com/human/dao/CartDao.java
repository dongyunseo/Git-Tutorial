package com.human.dao;

import com.human.dto.CartVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.human.util.DBConn;

public class CartDao {

	public CartDao() {
	}

	private static CartDao instance = new CartDao();

	public static CartDao getInstance() {
		return instance;
	}

	// ----------------장바구니 등록----------------
	public void insertCart(CartVO cartVO) {
		String sql = "insert into tbl_cart(cartnum,id,dressId,dressName,amount,price,sum) VALUES(tbl_cart_seq.nextval,?,?,?,?,?,?)";

		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cartVO.getId());
			System.out.println("주문자 아이디 : " + cartVO.getId());
			pstmt.setInt(2, cartVO.getDressId());
			System.out.println("물품 번호 : " + cartVO.getDressId());
			pstmt.setString(3, cartVO.getDressname());
			System.out.println("물품 이름 : " + cartVO.getDressname());
			pstmt.setInt(4, cartVO.getAmount());
			System.out.println("물품 주문 수량 :" + cartVO.getAmount());
			pstmt.setInt(5, cartVO.getPrice());
			System.out.println("물품 가격 : " + cartVO.getPrice());
			pstmt.setInt(6, cartVO.getSum());
			System.out.println("물품 수량  * 물품 가격 : " + cartVO.getSum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}

	// ----------------장바구니 모두 출력----------------
	public ArrayList<CartVO> listCart(String userId) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		Connection conn = DBConn.getConnection();
		String sql = String.format("select tbl_cart.cartnum, tbl_cart.id, tbl_cart.dressid,"
				+ " tbl_cart.dressName,tbl_cart.amount, tbl_cart.price, tbl_cart.sum, tbl_cart.addDate,"
				+ " dress.dressimg from tbl_cart,dress where tbl_cart.dressid = dress.dressid and id ='%s'order by cartnum desc",
				userId);
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				cartList.add(new CartVO(rs.getInt("cartnum"), rs.getString("id"), rs.getInt("dressId"),
						rs.getString("dressName"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("sum"),
						rs.getString("dressimg"), rs.getTimestamp("addDate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	// ----------------------주문 준비 -----------------------------

	public CartVO OrderReady(int cartnum) {
		CartVO OrderReady = null;
		Connection con = DBConn.getConnection();
		String sql = String.format("select tbl_cart.cartnum, tbl_cart.id, tbl_cart.dressid, "
				+ "tbl_cart.dressName,tbl_cart.amount, tbl_cart.price, tbl_cart.sum, tbl_cart.addDate, "
				+ "dress.dressimg from tbl_cart,dress where tbl_cart.dressid = dress.dressid " + "and cartnum =%d",
				cartnum);
		System.out.println(sql);
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				OrderReady = new CartVO(rs.getInt("cartnum"), rs.getString("id"), rs.getInt("dressId"),
						rs.getString("dressName"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("sum"),
						rs.getString("dressimg"), rs.getTimestamp("addDate"));
			}
			DBConn.close(st, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OrderReady;

	}
	
	// ----------------장바구니 삭제----------------
		public void deleteCart(int cartnum) {
			String sql = "delete tbl_cart where cartnum=?";
			System.out.println(sql);
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cartnum);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConn.close(conn, pstmt);
			}
		}
	//--------------------- 장바구니에서 주문을 했을 시 주문한 상품은 장바구니에서 삭제를 해야 한다.
	public void OrderCartdelete(int dressid) {
		// TODO Auto-generated method stub
		String sql = "delete tbl_cart where dressid=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dressid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}
}
