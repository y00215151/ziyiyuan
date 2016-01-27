package com.huawei.dao;

import org.springframework.stereotype.Repository;

import com.huawei.dao.mapping.User;

@Repository("userMongoDAO")
public class UserMongoDAO extends BaseMongoDAOImpl<User>
{
}
