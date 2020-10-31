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
		System.out.println("FEBoardService.insertFEBoard ����");
		fEBoardDAO.insertFEBoard(vo);
	}

	@Override
	public void updateFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.updateFEBoard ����");
		fEBoardDAO.updateFEBoard(vo);
	}
	
	@Override
	public void deleteFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.deleteFEBoard ����");
		fEBoardDAO.deleteFEBoard(vo);
	}
	
	@Override
	public FEBoardVO getFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardService.getFEBoard ����");
		return fEBoardDAO.getFEBoard(vo);
	}

	@Override
	public List<FEBoardVO> getFEBoardList(Criteria cri) {
		System.out.println("FEBoardService.getFEBoardList ����");
		return fEBoardDAO.getFEBoardList(cri);
	}

	@Override
	public int getFEBoardCount() {
		System.out.println("FEBoardService.getFEBoardCount ����");
		return fEBoardDAO.getFEBoardCount();
	}

}
