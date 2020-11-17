package com.human.cartorderCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dao.OrderDao;
import com.human.dto.OrderVO;

public class OrderHalfCommand implements CartOrderCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login_Id");
		OrderVO orderVo = new OrderVO();
		orderVo.setId(id);
		orderVo.setDressid(Integer.parseInt(request.getParameter("dressid")));
		orderVo.setDressimg(request.getParameter("dressimg"));
		orderVo.setDressname(request.getParameter("dressname"));
		orderVo.setPrice(Integer.parseInt(request.getParameter("price")));
		orderVo.setAmount(Integer.parseInt(request.getParameter("amount")));
		orderVo.setSum(Integer.parseInt(request.getParameter("sum")));
		OrderDao orderDao = OrderDao.getInstance();
		orderDao.OrderHalf(orderVo);
	}

}
