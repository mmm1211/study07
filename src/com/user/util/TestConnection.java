package com.user.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	    public static void main(String[] args) throws Exception {
	       Connection conn=DBUtil.getConection();//利用封装好的类名来调用连接方法便可
	       System.out.println(conn+",成功连接数据库");
	       DBUtil.close( conn);//同样利用类名调用关闭方法即可
	    }
}
