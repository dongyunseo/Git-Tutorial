public void OrderHalf(OrderVO orderVo) {
		String sql = "insert into tbl_order(ordernum,id,dressimg,dressid,dressname,price,amount,sum) "
				+ "VALUES(tbl_order_seq.nextval,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderVo.getId());
			System.out.println("주문자 아이디 : " + orderVo.getId());
			pstmt.setString(2, orderVo.getDressimg());
			System.out.println("이미지 경로 : " + orderVo.getDressimg());
			pstmt.setInt(3, orderVo.getDressid());
			System.out.println("상품 넘버 :" + orderVo.getDressid());
			pstmt.setString(4, orderVo.getDressname());
			System.out.println("상품 이름 : " + orderVo.getDressname());
			pstmt.setInt(5, orderVo.getPrice());
			System.out.println("상품 가격 : " + orderVo.getPrice());
			pstmt.setInt(6, orderVo.getAmount());
			System.out.println("상품 수량 : " + orderVo.getAmount());
			pstmt.setInt(7, orderVo.getSum());
			System.out.println("총 금액  : " + orderVo.getSum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
	}