package com.human.cartorderCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.CartDao;
import com.human.dto.CartVO;

public class OrderReadyCommand implements CartOrderCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cartnum = (Integer.parseInt(request.getParameter("cartnum")));
		System.out.println(cartnum);
		CartDao dao = new CartDao();
		CartVO OrderReady = dao.OrderReady(cartnum);
		request.setAttribute("OrderReady", OrderReady);
		
	}
}
/*
 * String cartnum = request.getParameter("cartnum"); System.out.println("2");
 * System.out.println(cartnum); System.out.println("3"); CartDao cDao =
 * CartDao.getInstance(); System.out.println("4"); ArrayList<CartVO> OrderReady
 * = cDao.OrderReady(Integer.parseInt(cartnum)); System.out.println("5");
 * request.setAttribute("OrderReady", OrderReady); System.out.println("6");
 */
