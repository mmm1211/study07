package com.user.biz.impl;

import java.util.List;

import com.user.biz.IUserBiz;
import com.user.dao.UserDaoImpl;

public class UserBizImpl implements IUserBiz {

	@Override
	public int login(String account, String password) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List list = userDaoImpl.login(account, password);
		if (list != null && list.size() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
