package com.fitness.common.user.dao;

import java.util.List;

import com.fitness.common.user.vo.UserVO;

public interface UserDAO {
	
	public void insertUser(UserVO vo);
	
	public void updateUser(UserVO vo);
	
	public void deleteUser(UserVO vo);
	
	public UserVO getUser(UserVO vo);
	
	public List<UserVO> getUserList(UserVO vo);
	
	public UserVO userLogin(String user_email);
	
	public int getUserCount();
}
