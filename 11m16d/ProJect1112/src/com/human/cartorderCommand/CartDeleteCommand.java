package com.human.cartorderCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.categorycommand.ProCommand;
import com.human.dao.CartDao;

public class CartDeleteCommand implements CartOrderCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartnum = request.getParameter("cartnum");

		 CartDao cartDAO = CartDao.getInstance();
		 cartDAO.deleteCart(Integer.parseInt(cartnum));

	}

}
