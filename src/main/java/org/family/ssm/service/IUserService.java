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
    
    /**
     * 添加用户对象
     * @param record 用户对象
     * @return 成功添加用户 返回大于0的整数，添加失败返回0
     */
    int insert(UserEntity record);
    
	/**
	 * 根据用户ID删除用户对象
	 * @param id 用户ID
	 * @return 删除成功，返回大于0的整数，删除失败返回0
	 */
    int deleteByPrimaryKey(String id);
    
    /**
     * 根据用户对象，修改用户信息
     * @param record 用户对象
     * @return 修改成功，返回大于0的整数，修改失败返回0
     */
    int updateByPrimaryKey(UserEntity record);
}
