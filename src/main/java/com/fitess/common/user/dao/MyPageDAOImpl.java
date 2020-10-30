package com.fitess.common.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fitess.common.meal.vo.MealVO;
import com.fitess.common.program.vo.ProgramVO;
import com.fitess.common.trainer.vo.TrainerVO;
import com.fitess.common.user.vo.MyPageVO;

public class MyPageDAOImpl implements MyPageDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public char getUserLevel(int userId) {
		char userLevel = 'U';
		System.out.println("mybatis MyPageDAO.userLevelResult 실행");
		String userLevelStr = sqlSessionTemplate.selectOne("MyPageDAO.userLevelResult", userId);
		userLevel = userLevelStr.charAt(0);
		return userLevel;
	}

	@Override
	public List<ProgramVO> getProgramFromUser(int userId) {
		System.out.println("mybatis MyPageDAO.programResult 실행");
		return sqlSessionTemplate.selectList("MyPageDAO.programResult", userId);
	}

	@Override
	public List<MealVO> getMealFromUser(int userId) {
		System.out.println("mybatis MyPageDAO.mealResult 실행");
		return sqlSessionTemplate.selectList("MyPageDAO.mealResult", userId);
	}

	@Override
	public boolean delProgram(int programId, int userId) {
		boolean checkDel = false;
		System.out.println("mybatis MyPageDAO.programResult 실행");
		ProgramVO checkRight = (ProgramVO) sqlSessionTemplate.selectList("MyPageDAO.programResult", programId);
		if (checkRight.getUser_id() == userId) {
			System.out.println("mybatis Program 삭제 처리");
			sqlSessionTemplate.delete("MyPageDAO.delProgram", programId);
			checkDel = true;
		}
		return checkDel;
	}

	@Override
	public boolean delMeal(int mealId, int userId) {
		boolean checkDel = false;
		MealVO checkRight = (MealVO) sqlSessionTemplate.selectList("MyPageDAO.mealResult", mealId);
		if (checkRight.getUser_id() == userId) {
			System.out.println("mybatis Meal 삭제 처리");
			sqlSessionTemplate.delete("MyPageDAO.delMeal", mealId);
		}
		return checkDel;
	}

	@Override
	public List<TrainerVO> getTrainerRequest() {
		List<TrainerVO> trainerList = new ArrayList<>();
		System.out.println("mybatis 아직  승인되지 않은 트레이너 목록 요청");
		trainerList = sqlSessionTemplate.selectList("MyPageDAO.getTrainerRequest");
		return trainerList;
	}

	@Override
	public void confirmTrainer(boolean whether, int userId) {
		if (whether) {
			System.out.println("mybatis 트레이너 승인 요청");
			sqlSessionTemplate.update("MyPageDAO.confirmTrainer", userId);
		} else {
			System.out.println("mybatis 트레이너 거부 요청");
			sqlSessionTemplate.delete("MyPageDAO.refuseTrainer", userId);
		}
	}

	@Override
	public void modifyUser(int userId, String modifyNick, String modifyPassword) {
		MyPageVO vo = new MyPageVO(userId, modifyNick, modifyPassword);
		System.out.println("mybatis 마이페이지 수정 요청");
		sqlSessionTemplate.update("MyPageDAO.modifyUser", vo);
	}

}
