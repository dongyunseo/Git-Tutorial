package com.human.cartorderCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dao.OrderDao;
import com.human.dto.OrderVO;

public class OrderListCommand implements CartOrderCommand{
// 주문 페이지에서 주문 List 출력
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("login_Id");

		System.out.println(id);
		OrderDao orderDao = OrderDao.getInstance();
		ArrayList<OrderVO> ListOrder = orderDao.OrderList(id);
		request.setAttribute("ListOrder", ListOrder);
	}

}
