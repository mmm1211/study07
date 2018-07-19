package com.user.dao;

import java.util.List;

import com.user.bean.User;

public interface IuserDao {
	public List<User> login(String account, String password);
}
