package com.human.cartorderCommand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.OrderDao;
import com.human.util.DBConn;

public class OrderNullDeleteCommand implements CartOrderCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao orderDao = OrderDao.getInstance();
		System.out.println("4");
		orderDao.OrderHalfNullDelete();
	}
}
