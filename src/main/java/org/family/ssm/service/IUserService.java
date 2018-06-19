package org.family.ssm.service;

import java.util.List;

import org.family.ssm.entity.UserEntity;

public interface IUserService {
    /**
     * 通过用户ID查找用户
     * @param id 用户ID
     * @return 用户对象
     */
    UserEntity selectByPrimaryKey(String id);
    /**
     * 查找所用用户对象
     * @return
     */
    public List<UserEntity> getAllUserList();
}
