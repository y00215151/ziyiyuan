package com.huawei.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huawei.dao.BaseMongoDAO;
import com.huawei.dao.mapping.User;
import com.huawei.dao.mapping.UserMapper;


@Repository(value = "loginService")  
@Transactional  
public class LoginService implements ILoginService
{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BaseMongoDAO<User> userMongoDAO;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
	





	public BaseMongoDAO<User> getUserMongoDAO() {
		return userMongoDAO;
	}

	public void setUserMongoDAO(BaseMongoDAO<User> userMongoDAO) {
		this.userMongoDAO = userMongoDAO;
	}








	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public boolean checkUserExist(String name, int age)
	{
		String sql = "select * from user";  
        List<User> userList = this.userMapper.getUserListByName(sql);
        for (User u : userList)
        {
        	if (u.getName().equalsIgnoreCase(name) && u.getAge() == age)
        	{
        		return true;
        	}
        }
        return false;
	}

	@Override
	public List<User> getSameNameUserList(String name) 
	{
		String sql = "select * from user where name = '" + name + "'";
		return this.userMapper.getUserListByName(sql);
	}
	
	public void saveUserMsgToMogodb(String name, int age, Date birthday)
	{
		User u = new User();
		u.setAge(age);
		u.setName(name);
		u.setBirthday(new Date(System.currentTimeMillis()));
		u.setId(122 + age);
		userMongoDAO.save(u);
	}
	
	public List<User> findUserInMongo(String name, int age)
	{
		List<User> users = null;
		Query query = new Query(Criteria.where("name").is(name));
		query.addCriteria(Criteria.where("age").is(age));
		users = userMongoDAO.find(query);
		return users;
	}
	
	
	
}
