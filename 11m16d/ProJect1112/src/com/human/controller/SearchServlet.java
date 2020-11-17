package com.human.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.MemberDao;
import com.human.dao.ProDao;
import com.human.dto.ProDto;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("SearchServlet 서블릿 이동 완료");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String search = request.getParameter("search");
		response.getWriter().write(getJSON(search));
	}

	public String getJSON(String search) {
		System.out.println(search + " 검색중....");
		if (search == null)
			search = "";
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ProDao prodao = new ProDao();
		ArrayList<ProDto> Search = prodao.selectSearch(search);
		for (int i = 0; i < Search.size(); i++) {
			result.append("[{\"value\":\""+ "<a href='../dressDetails/dressDetails_view.do?dressid= " + Search.get(i).getDressid() +"'>" +Search.get(i).getDressimg() +"</a>"+"\"},");
			result.append("{\"value\":\""+ "<a href='../dressDetails/dressDetails_view.do?dressid= " + Search.get(i).getDressid() +"'>" +Search.get(i).getDressname() +"</a>"+"\"},");
			result.append("{\"value\":\""+ "<a href='../dressDetails/dressDetails_view.do?dressid= " + Search.get(i).getDressid() +"'>" +Search.get(i).getPrice() +"</a>"+"\"}],\n");
			
		}
		if(Search.size() < 10) { 
			
		}
		System.out.println(result);
		result.append("]}");
		return result.toString();
	}
}