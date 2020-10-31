package com.fitness.admin.veboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.veboard.vo.VEBoardVO;

@Repository
public class VEBoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardDAO.insertVEBoard ����");
		sqlSessionTemplate.insert("VEBoardDAO.insertVEBoard", vo);
	}
	
	public void updateVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardDAO.updateVEBoard ����");
		sqlSessionTemplate.update("VEBoardDAO.updateVEBoard", vo);
	}
	
	public void deleteVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardDAO.deleteVEBoard ����");
		sqlSessionTemplate.delete("VEBoardDAO.deleteVEBoard", vo);
	}
	
	public VEBoardVO getVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardDAO.getVEBoard ����");
		return (VEBoardVO)sqlSessionTemplate.selectOne("VEBoardDAO.getVEBoard", vo);
	}
	
	public List<VEBoardVO> getVEBoardList(Criteria cri) {
		System.out.println("VEBoardDAO.getVEBoardList ����");
		return sqlSessionTemplate.selectList("VEBoardDAO.getVEBoardList", cri);
	}
	
	public int getVEBoardCount() {
		System.out.println("VEBoardDAO.getVEBoardCount ����");
		return (int)sqlSessionTemplate.selectOne("VEBoardDAO.getVEBoardCount");
	}
	
}
