package com.fitess.common.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitess.common.user.dao.UserDAO;
import com.fitess.common.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}

	@Override
	public char getUserLevel(int userId) {
		char userLevel = 'U';
		String sql = "SELECT user_level FROM user_info WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(); // Modify this after creating a connection object
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId); // Insert parameter value
			rs = pstmt.executeQuery();
			userLevel = rs.getChar("user_level");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userLevel;
	}

}
