package org.family.ssm.dao;

import org.family.ssm.entity.UserEntity;

public interface IUserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);
    /**
     * 通过用户ID查找用户
     * @param id 用户ID
     * @return 用户对象
     */
    UserEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}