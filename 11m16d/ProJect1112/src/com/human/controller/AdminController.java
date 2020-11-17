package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.adminsCommand.AdminInterface;
import com.human.adminsCommand.adminOrderAllListCommand;
import com.human.adminsCommand.adminProductDetail;
import com.human.adminsCommand.adminProductUpdate;
import com.human.adminsCommand.adminQandAListCommand;
import com.human.adminsCommand.adminQandAreplyCommand;
import com.human.adminsCommand.adminReviewListCommand;
import com.human.adminsCommand.adminaccCommand;
import com.human.adminsCommand.adminbottomCommand;
import com.human.adminsCommand.adminouterCommand;
import com.human.adminsCommand.adminshiptsCommand;
import com.human.adminsCommand.adminteeCommand;
/**
 * Servlet implementation class AdminController
 */
@WebServlet("*.ao")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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
		System.out.println("AdminController doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AdminController doPost");
		request.setCharacterEncoding("UTF-8");
		AdminInterface aCom = null;

		// 사용자에게 보여줄 view 설정
		String viewPage = null;
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);

		if (com.equals("/AdminProductManager/AdminPdOuter.ao")) {
			viewPage = "AdminPdOuter.jsp";
			aCom = new adminouterCommand(); //
			aCom.execute(request, response);
		} else if (com.equals("/AdminProductManager/AdminProductAcc.ao")) {
			viewPage = "AdminProductAcc.jsp";
			aCom = new adminaccCommand(); //
			aCom.execute(request, response);
		} else if (com.equals("/AdminProductManager/AdminProductBottom.ao")) {
			viewPage = "AdminProductBottom.jsp";
			aCom = new adminbottomCommand(); //
			aCom.execute(request, response);
		} else if (com.equals("/AdminProductManager/AdminProductShipts.ao")) {
			viewPage = "AdminProductShipts.jsp";
			aCom = new adminshiptsCommand(); //
			aCom.execute(request, response);
		} else if (com.equals("/AdminProductManager/AdminProductTee.ao")) {
			viewPage = "AdminProductTee.jsp";
			aCom = new adminteeCommand(); //
			aCom.execute(request, response);
		} else if (com.equals("/AdminProductManager/AdminProductDetail.ao")) {
			viewPage = "AdminProductDetail.jsp";
			aCom = new adminProductDetail(); //
			aCom.execute(request, response);
		} else if (com.equals("/AdminProductManager/AdminProductUpdate.ao")) {
			viewPage = "AdminProductUpdate.jsp";
			aCom = new adminProductUpdate();
			aCom.execute(request, response);
		} else if (com.equals("/AdminReview&QandA/AdminQandA.ao")) {
			viewPage = "AdminQandA.jsp";
			aCom = new adminQandAListCommand();
			aCom.execute(request, response);
		} else if (com.equals("/AdminReview&QandA/AdminQandAreply.ao")) {
			viewPage = "AdminQandAreply.jsp";
			aCom = new adminQandAreplyCommand();
			aCom.execute(request, response);
		} else if (com.equals("/AdminOrder/AllOrderList.ao")) {
			viewPage = "AllOrderList.jsp";
			aCom = new adminOrderAllListCommand();
			aCom.execute(request, response);
		} else if (com.equals("/AdminReview&QandA/AdminReviewreply.ao")) {
			viewPage = "AdminReviewreply.jsp";
			aCom = new adminReviewListCommand();
			aCom.execute(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
