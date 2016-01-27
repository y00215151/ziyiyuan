package com.huawei.dao.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository(value="userMapper")
public interface UserMapper 
{
	   @Select(value = "${sql}")  
	   @Results(value = { @Result(id = true, property = "id", column = "id"),  
	            @Result(property = "name", column = "name"),  
	            @Result(property = "age", column = "age"),  
	            @Result(property = "birthday", column = "birthday")
	   			})  
	    List<User> operateReturnBeans(@Param(value = "sql") String sql);
	   
	   @Select(value = "${sql}")  
	   @Results(value = { @Result(id = true, property = "id", column = "id"),  
	            @Result(property = "name", column = "name"),  
	            @Result(property = "age", column = "age"),  
	            @Result(property = "birthday", column = "birthday")
	   			})  
	    List<User> getUserListByName(@Param(value = "sql") String sql);
	   
	   
	   
}
