package com.fitness.admin.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.user.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// ���� ���� �޼���
	public void suspendUser(UserVO vo) {
		System.out.println("UserDAO.suspendUser ����");
		sqlSessionTemplate.update("UserDAO.suspendUser", vo);
	}
	
	// ���� ���� ���� �޼���
	public void unsuspendUser(UserVO vo) {
		System.out.println("UserDAO.unsuspendUser ����");
		sqlSessionTemplate.update("UserDAO.unsuspendUser", vo);
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("UserDAO.getUser ����");
		return (UserVO)sqlSessionTemplate.selectOne("UserDAO.getUser", vo);
	}
	
	public List<UserVO> getUserList(Criteria cri) {
		System.out.println("UserDAO.getUserList ����");
		Map map = new HashMap();
		map.put("cri", cri);
		map.put("startNum", cri.getStartNum());
		map.put("endNum", cri.getEndNum());
		return sqlSessionTemplate.selectList("UserDAO.getUserList", cri);
	}
	
	public int getUserCount() {
		System.out.println("UserDAO.getUserCount ����");
		return (int)sqlSessionTemplate.selectOne("UserDAO.getUserCount");
	}
	
}
