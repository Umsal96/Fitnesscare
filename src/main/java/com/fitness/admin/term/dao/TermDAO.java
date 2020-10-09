package com.fitness.admin.term.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.term.vo.TermVO;

@Repository
public class TermDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertTerm(TermVO vo) {
		System.out.println("TermDAO.insertTerm ����");
		sqlSessionTemplate.insert("TermDAO.insertTerm", vo);
	}
	
	public void updateTerm(TermVO vo) {
		System.out.println("TermDAO.updateTerm ����");
		sqlSessionTemplate.update("TermDAO.updateTerm", vo);
	}
	
	public TermVO getTerm(TermVO vo) {
		System.out.println("TermDAO.getTerm ����");
		return (TermVO)sqlSessionTemplate.selectOne("TermDAO.getTerm", vo);
	}
	
	public List<TermVO> getTermList(Criteria cri) {
		System.out.println("TermDAO.getTermList ����");
		Map map = new HashMap();
		map.put("cri", cri);
		map.put("startNum", cri.getStartNum());
		map.put("endNum", cri.getEndNum());
		return sqlSessionTemplate.selectList("TermDAO.getTermList", map);
	}
	
	public int getTermCount() {
		System.out.println("TermDAO.getTermCount ����");
		return (int)sqlSessionTemplate.selectOne("TermDAO.getTermCount");
	}
	
}
