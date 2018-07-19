package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.biz.impl.UserBizImpl;

@WebServlet("/login")
public class LoginServlet extends Basicservlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");

		if ("login".equals(op)) {
			// 登陸
			login(request, response);
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getParameter("account");
		String password = request.getParameter("pwd");

		UserBizImpl userBizImpl = new UserBizImpl();
		int flag = userBizImpl.login(account, password);
		this.out(response, flag);
	}

}
