package com.human.categorycommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.ProDao;
import com.human.dto.ProDto;

public class SearchCommand implements ProCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProDao ProDao = new ProDao();
		String search = request.getParameter("search");
		System.out.println("검색중... = " + search);
		if (search != "") {
			ArrayList<ProDto> Search = ProDao.selectSearch(search);
			request.setAttribute("Search", Search);
			System.out.println(Search);
		}
	}
}
