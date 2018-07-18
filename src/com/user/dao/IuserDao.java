package com.user.dao;

import com.user.bean.User;

public interface IuserDao {
	 User login(String uid,String account, String password);
}
