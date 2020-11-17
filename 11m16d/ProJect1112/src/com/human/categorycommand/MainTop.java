package com.human.categorycommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.ProDao;
import com.human.dto.ProDto;

public class MainTop implements ProCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ProDao ProDao = new ProDao();
		ArrayList<ProDto> dtost = ProDao.selecttop();
		request.setAttribute("dtost", dtost);

		
		ArrayList<ProDto> dtosm = ProDao.selectmidd();
		request.setAttribute("dtosm", dtosm);

		
		ArrayList<ProDto> dtosw = ProDao.selectbottom();
		request.setAttribute("dtosw", dtosw);

		
	}

}
