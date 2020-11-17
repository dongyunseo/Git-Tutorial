package com.human.adminsCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.QandADao;
import com.human.dto.QandAVo;

public class adminQandAreplyCommand implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int qandaid = (Integer.parseInt(request.getParameter("qandaid")));
		System.out.println(qandaid);
		QandADao qandaDao = new QandADao();
		QandAVo updateQandA = qandaDao.UpdateQandA(qandaid);
		request.setAttribute("updateQandA", updateQandA);
	}

}
