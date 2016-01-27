package com.huawei.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.dao.mapping.User;
import com.huawei.service.ILoginService;

@Controller
@RequestMapping("/login")
public class LoginAction 
{
	@ResponseBody
	@RequestMapping("/doLogin")
	public MyClass doLogin(HttpServletRequest request, String userName, String password)
	{
		MyClass cls = new MyClass();
		cls.setAge("22222");
		cls.setName("sfdsfds");
		cls.setScore(23232);
		return cls;
	}
	
	@Autowired
	private ILoginService loginService;
	
	@ResponseBody
	@RequestMapping("/getUserInfo")
	public List<User> getUserInfoByName(String name, int age)
	{
		//return loginService.getSameNameUserList(name);
		return loginService.findUserInMongo(name, age);
	}
	
	
	@ResponseBody
	@RequestMapping("/saveUserInfo")
	public String saveUserInfo(String userName, int age)
	{
		Date birthday = new Date(System.currentTimeMillis());
		loginService.saveUserMsgToMogodb(userName, age, birthday);
		return "success";
	}
	
	class MyClass
	{
		private String name;
		
		private int score;
		
		private String age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
		
	}
	
	
}
