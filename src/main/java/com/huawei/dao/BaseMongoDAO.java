package com.huawei.dao;

import java.util.List;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface BaseMongoDAO<T> 
{
	
	/**
	 * 查找列表
	 * @param query
	 * @return
	 */
	public List<T> find(Query query);
	
	
	/**
	 * 查找一个
	 * @param query
	 * @return
	 */
	public T findOne(Query query);
	
	
	/**
	 * 更新数据
	 * @param query
	 * @param update
	 */
	public void update(Query query, Update update);
	
	
	/**
	 * 保存数据
	 * @param obj
	 * @return
	 */
	public T save(T obj);
	
	

	/**
	 * 根据id查找数据
	 * @param id
	 * @return
	 */
	public T findById(String id);
	
	/**
	 * 根据id和表名查找数据
	 * @param id
	 * @param collectionName
	 * @return
	 */
	public T findById(String id, String collectionName);
	
    /** 
     * 求数据总和 
     * @param query 
     * @return 
     */  
    public long count(Query query);  
	
}
