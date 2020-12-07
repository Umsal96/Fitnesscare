package com.fitness.user.comment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.user.comment.vo.CommentInfoVO;

@Repository
public class UserCommentDAOImpl implements UserCommentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertComment(CommentInfoVO vo) {
		System.out.println("mybatis insertComment 실행");
		sqlSessionTemplate.insert("commentDAO.insertComment", vo);
	}
	
	@Override
	public void reInsertComment(CommentInfoVO vo) {
		System.out.println("mybatis reInsertComment 실행");
		sqlSessionTemplate.insert("commentDAO.reInsertComment", vo);
	}

	@Override
	public List<CommentInfoVO> getCommentList(CommentInfoVO vo) {
		System.out.println("mybatis getCommentList 실행");
		return sqlSessionTemplate.selectList("commentDAO.getCommentList");
	}

	@Override
	public CommentInfoVO getComment(CommentInfoVO vo) {
		System.out.println("mybatis getComment 실행");
		return sqlSessionTemplate.selectOne("commentDAO.getComment");
	}

}
