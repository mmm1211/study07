package com.user.dao;

import java.util.List;

import com.user.bean.User;
import com.user.util.DBUtil;

public class UserDaoImpl implements IuserDao {

	// 实现用户登陆的方法
	@Override
	public List<User> login(String account, String password) {
		DBUtil dbUtil = new DBUtil();
		List list = null;
		String sql = "select * from user where account=? and password=?";
		try {
			list = dbUtil.query(sql, account, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
