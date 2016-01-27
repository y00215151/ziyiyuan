package com.huawei.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.huawei.utils.ReflectionUtils;


public class BaseMongoDAOImpl<T> implements BaseMongoDAO<T> 
{
    /** 
     * spring mongodb　集成操作类　 
     */  
	@Autowired
    protected MongoTemplate mongoTemplate;
    
    /** 
     * 获取需要操作的实体类class 
     *  
     * @return 
     */  
    private Class<T> getEntityClass(){  
        return ReflectionUtils.getSuperClassGenricType(getClass());  
    }  
    
    
	@Override
	public List<T> find(Query query) 
	{
		return mongoTemplate.find(query, this.getEntityClass());
	}

	@Override
	public T findOne(Query query) 
	{
		return mongoTemplate.findOne(query, this.getEntityClass());
	}

	@Override
	public void update(Query query, Update update) 
	{
		this.mongoTemplate.findAndModify(query, update, this.getEntityClass());
	}
	

	@Override
	public T save(T obj) 
	{
		this.mongoTemplate.insert(obj);
		return obj;
	}

	
	
	@Override
	public T findById(String id) 
	{
		return this.mongoTemplate.findById(id, this.getEntityClass());
	}


	@Override
	public T findById(String id, String collectionName) 
	{
		return this.mongoTemplate.findById(id, getEntityClass(), collectionName);
	}

	@Override
	public long count(Query query) 
	{
		return this.mongoTemplate.count(query, this.getEntityClass());
	}
	
	  /** 
     * 注入mongodbTemplate 
     *  
     * @param mongoTemplate 
     */  
    protected void setMongoTemplate(MongoTemplate mongoTemplate)
    {
    	this.setMongoTemplate(mongoTemplate);
    }

}
