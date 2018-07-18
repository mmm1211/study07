<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	String op=request.getParameter("op");
	
	if("login".equals(op)){
		String uname=request.getParameter("account");
		String pwd=request.getParameter("pwd");
		out.print(uname);
		
		if("123456".equals(uname) && "abc".equals(pwd)){
			out.print("1");
		}else{
			out.print("0");
		}
	}else{
		out.print("请求不能识别..");
	}
	
	
%>>