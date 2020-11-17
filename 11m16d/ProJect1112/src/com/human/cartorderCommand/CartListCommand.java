package com.human.cartorderCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dao.CartDao;
import com.human.dto.CartVO;

public class CartListCommand implements CartOrderCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("login_Id");
		if (id == null) {
			String url = "../Member/mainLoginPage.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			CartDao cDao = CartDao.getInstance();
			ArrayList<CartVO> cartList = cDao.listCart(id);
			request.setAttribute("cartList", cartList);
		}
	}

}