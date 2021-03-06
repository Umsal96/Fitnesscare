package com.fitness.admin.feboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.feboard.dao.FEBoardDAO;
import com.fitness.admin.feboard.vo.FEBoardVO;

@Service
public class FEBoardServiceImpl implements FEBoardService {

	@Autowired
	private FEBoardDAO fEBoardDAO;
	
	@Override
	public void insertFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.insertFEBoard 실행");
		fEBoardDAO.insertFEBoard(vo);
	}

	@Override
	public void updateFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.updateFEBoard 실행");
		fEBoardDAO.updateFEBoard(vo);
	}
	
	@Override
	public void deleteFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.deleteFEBoard 실행");
		fEBoardDAO.deleteFEBoard(vo);
	}
	
	@Override
	public FEBoardVO getFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.getFEBoard 실행");
		return fEBoardDAO.getFEBoard(vo);
	}

	@Override
	public List<FEBoardVO> getFEBoardList(Criteria cri) {
		System.out.println("FEBoardService.getFEBoardList 실행");
		return fEBoardDAO.getFEBoardList(cri);
	}

	@Override
	public int getFEBoardCount() {
		System.out.println("FEBoardService.getFEBoardCount 실행");
		return fEBoardDAO.getFEBoardCount();
	}

}
