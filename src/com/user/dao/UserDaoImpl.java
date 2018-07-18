package com.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.user.bean.User;
import com.user.util.DBUtil;

public class UserDaoImpl implements IuserDao{

	//实现用户登陆的方法
	@Override
	public User login(String uid,String account, String password) {
		User user=null;
		Connection conn=DBUtil.getConection();
		String sql="select * from test_user where account='"+account+"' and password='"+password+"'";
		try {
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			if(rs.first()) {
				int id=rs.getInt("uid");
				user=new User();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
