package com.fitess.common.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitess.common.meal.vo.MealVO;
import com.fitess.common.program.vo.ProgramVO;
import com.fitess.common.trainer.vo.TrainerVO;
import com.fitess.common.user.dao.MyPageDAO;

@Service("myPageService")
public class MyPageServiceImpl implements MyPageDAO {
	
	@Autowired
	private MyPageDAO myPageDAO;

	@Override
	public char getUserLevel(int userId) {
		return myPageDAO.getUserLevel(userId);
	}

	@Override
	public List<ProgramVO> getProgramFromUser(int userId) {
		return myPageDAO.getProgramFromUser(userId);
	}

	@Override
	public List<MealVO> getMealFromUser(int userId) {
		return myPageDAO.getMealFromUser(userId);
	}

	@Override
	public boolean delProgram(int programId, int userId) {
		return myPageDAO.delProgram(programId, userId);
	}

	@Override
	public boolean delMeal(int mealId, int userId) {
		return myPageDAO.delMeal(mealId, userId);
	}

	@Override
	public List<TrainerVO> getTrainerRequest() {
		return myPageDAO.getTrainerRequest();
	}

	@Override
	public void confirmTrainer(boolean whether, int userId) {
		myPageDAO.confirmTrainer(whether, userId);
	}

	@Override
	public void modifyUser(int userId, String modifyNick, String modifyPassword) {
		myPageDAO.modifyUser(userId, modifyNick, modifyPassword);
	}

}
