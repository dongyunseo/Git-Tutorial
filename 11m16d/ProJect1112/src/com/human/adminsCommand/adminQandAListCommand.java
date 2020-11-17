package com.human.adminsCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.QandADao;
import com.human.dto.QandAVo;

public class adminQandAListCommand implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String qandareply = request.getParameter("qandareply");
		String qandaid = request.getParameter("qandaid");
		String id = request.getParameter("id");

		if (qandareply != null) {
			System.out.println(qandaid);
			System.out.println(qandareply);
			QandAVo qandaVo = new QandAVo();
			qandaVo.setQandareply(request.getParameter("qandareply"));
			qandaVo.setQandaid(Integer.parseInt(request.getParameter("qandaid")));
			QandADao qDao = QandADao.getInstance();
			qDao.QandAreply(qandaVo);

		}
		QandADao qDao = QandADao.getInstance();
		ArrayList<QandAVo> QandAallList = qDao.QandAallSelete();
		request.setAttribute("QandAallList", QandAallList);
	}

}
