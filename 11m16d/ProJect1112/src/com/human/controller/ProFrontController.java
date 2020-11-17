package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.categorycommand.MainTop;
import com.human.categorycommand.ProCommand;
import com.human.categorycommand.ReviewCommand;
import com.human.categorycommand.accCommand;
import com.human.categorycommand.bottomCommand;
import com.human.categorycommand.dressDetailsCommand;
import com.human.categorycommand.outerCommand;
import com.human.categorycommand.shiptsCommand;
import com.human.categorycommand.teeCommand;
import com.human.categorycommand.SearchCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class ProFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProFrontController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ProFrontController doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ProFrontController doPost");
		request.setCharacterEncoding("UTF-8");
		ProCommand bCom = null;

		// ����ڿ��� ������ view ����
		String viewPage = null;
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);

		if (com.equals("/Main&Category/main.do")) {
			viewPage = "main.jsp";
			bCom = new MainTop(); // ���������� ��ǰ ���
			bCom.execute(request, response);
		} else if (com.equals("/dressDetails/dressDetails_view.do")) {
			bCom = new dressDetailsCommand();
			viewPage = "dressDetails.jsp";
			bCom.execute(request, response);
		} else if (com.equals("/dressDetails/dressDetails_Review.do")) {
			bCom = new ReviewCommand();
			viewPage = "dressDetails.jsp";
			bCom.execute(request, response);
		} else if (com.equals("/Main&Category/outer.do")) {
			viewPage = "outer.jsp";
			bCom = new outerCommand(); // outer ��ǰ ���
			bCom.execute(request, response);
		} else if (com.equals("/Main&Category/shipts.do")) {
			viewPage = "shipts.jsp";
			bCom = new shiptsCommand(); // ���� ��ǰ ���
			bCom.execute(request, response);
		} else if (com.equals("/Main&Category/tee.do")) {
			viewPage = "tee.jsp";
			bCom = new teeCommand(); // ���� ��ǰ ���
			bCom.execute(request, response);
		} else if (com.equals("/Main&Category/bottom.do")) {
			viewPage = "bottom.jsp";
			bCom = new bottomCommand(); // ���� ��ǰ ���
			bCom.execute(request, response);
		} else if (com.equals("/Main&Category/acc.do")) {
			viewPage = "acc.jsp";
			bCom = new accCommand(); // �Ǽ����� ��ǰ ���
			bCom.execute(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
