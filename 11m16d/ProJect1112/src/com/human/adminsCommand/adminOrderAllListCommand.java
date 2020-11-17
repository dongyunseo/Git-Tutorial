package com.human.adminsCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.OrderDao;
import com.human.dto.OrderVO;

public class adminOrderAllListCommand implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao orderDao = OrderDao.getInstance();
		ArrayList<OrderVO> adminAllListOrder = orderDao.AdminAllOrderList();
		request.setAttribute("adminAllListOrder", adminAllListOrder);
	}

}
