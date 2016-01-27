package com.huawei.service;

import java.util.Date;
import java.util.List;

import com.huawei.dao.mapping.User;

public interface ILoginService {
	public boolean checkUserExist(String name, int age);
	
	public List<User> getSameNameUserList(String name);

	public void saveUserMsgToMogodb(String name, int age, Date birthday);
	
	public List<User> findUserInMongo(String name, int age);
}
