package com.fitness.admin.comment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.admin.comment.vo.CommentVO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertComment(CommentVO vo) {
		System.out.println("CommentDAO.insertComment ����");
		sqlSessionTemplate.insert("CommentDAO.insertComment", vo);
	}
	
	public void updateComment(CommentVO vo) {
		System.out.println("CommentDAO.updateComment ����");
		sqlSessionTemplate.update("CommentDAO.updateComment", vo);
	}
	
	public void deleteComment(CommentVO vo) {
		System.out.println("CommentDAO.deleteComment ����");
		sqlSessionTemplate.delete("CommentDAO.deleteComment", vo);
	}
	
	public CommentVO getComment(CommentVO vo) {
		System.out.println("CommentDAO.getComment ����");
		return (CommentVO)sqlSessionTemplate.selectOne("CommentDAO.getComment", vo);
	}
	
	public List<CommentVO> getCommentList(CommentVO vo) {
		System.out.println("CommentDAO.getCommentList ����");
		return sqlSessionTemplate.selectList("CommentDAO.getCommentList", vo);
	}
	
}
