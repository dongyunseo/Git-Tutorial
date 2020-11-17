package com.human.cartorderCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.categorycommand.ProCommand;
import com.human.dao.CartDao;
import com.human.dto.CartVO;

public class CartInsertCommand implements CartOrderCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login_Id");
		if (id == null) {
			String url = "../Member/mainLoginPage.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			CartVO cartVO = new CartVO();
			cartVO.setId(id);
			cartVO.setDressId(Integer.parseInt(request.getParameter("dressid")));
			cartVO.setDressname(request.getParameter("dressname"));
			cartVO.setAmount(Integer.parseInt(request.getParameter("amount")));
			cartVO.setPrice(Integer.parseInt(request.getParameter("sell_price")));
			cartVO.setSum(Integer.parseInt(request.getParameter("sum")));
			CartDao cartDAO = CartDao.getInstance();
			cartDAO.insertCart(cartVO);
		}
	}
}
