package org.family.ssm.service.impl;

import java.util.List;

import org.family.ssm.dao.IUserDao;
import org.family.ssm.entity.UserEntity;
import org.family.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserEntity selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public List<UserEntity> getAllUserList() {
		// TODO Auto-generated method stub
		return userDao.getAllUserList();
	}

}
