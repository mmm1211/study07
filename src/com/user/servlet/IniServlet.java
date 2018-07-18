package com.user.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IniServlet
 */
@WebServlet(value="/",loadOnStartup=1)
public class IniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private String filePath="uploadFile";
    
    
    @Override
	public void init(ServletConfig config) throws ServletException {
    	String temp=config.getInitParameter("upload");
    	
    	if(temp !=null) {
    		filePath=temp;
    	}
    	
    	//判断此路径是否存在
    	String path=config.getServletContext().getRealPath("/");
    	File fl=new File(path,"../"+filePath);
    	
    	if(!fl.exists()) {
    		fl.mkdirs();
    	}
	}

	public IniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
