package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.cartorderCommand.CartOrderCommand;
import com.human.cartorderCommand.CartDeleteCommand;
import com.human.cartorderCommand.CartInsertCommand;
import com.human.cartorderCommand.CartListCommand;
import com.human.cartorderCommand.OrderDeleteCommand;
import com.human.cartorderCommand.OrderHalfCommand;
import com.human.cartorderCommand.OrderHalfSListCommand;
import com.human.cartorderCommand.OrderInsertCommand;
import com.human.cartorderCommand.OrderListCommand;
import com.human.cartorderCommand.OrderNullDeleteCommand;
import com.human.cartorderCommand.OrderReadyCommand;

/**
 * Servlet implementation class CartOrderController
 */
@WebServlet("*.co")
public class CartOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CartOrderController doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CartOrderController doPost");
		request.setCharacterEncoding("UTF-8");
		CartOrderCommand cCom = null;

		// 사용자에게 보여줄 view 설정
		String viewPage = null;
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);

// -------------cart--------------
		if (com.equals("/cart/cartInsert.co")) {
			viewPage = "cartSelect.co";
			cCom = new CartInsertCommand();
			cCom.execute(request, response);
		} else if (com.equals("/cart/cartSelect.co")) {
			viewPage = "cart.jsp";
			cCom = new CartListCommand();
			cCom.execute(request, response);
		} else if (com.equals("/cart/cartDelete.co")) {
			viewPage = "/cart/cartSelect.co";
			cCom = new CartDeleteCommand();
			cCom.execute(request, response);
// -------------cart -> order--------------
		} else if (com.equals("/order/order.co")) {
			viewPage = "order.jsp";
			cCom = new OrderReadyCommand();
			cCom.execute(request, response);
		} else if (com.equals("/order/orderInsert.co")) {
			viewPage = "orderSelect.co";
			cCom = new OrderInsertCommand();
			cCom.execute(request, response);
		} else if (com.equals("/order/orderSelect.co")) {
			viewPage = "orderList.jsp";
			cCom = new OrderListCommand();
			cCom.execute(request, response);
		} else if (com.equals("/order/orderDelete.co")) {
			viewPage = "/order/orderSelect.co";
			cCom = new OrderDeleteCommand();
			cCom.execute(request, response);
// dressDetails.jsp -> order----------------------------------
		} else if (com.equals("/order/orderHalfInsert.co")) {
			viewPage = "orderSelect.co";
			System.out.println(viewPage);
			cCom = new OrderHalfSListCommand();
			cCom.execute(request, response);
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
