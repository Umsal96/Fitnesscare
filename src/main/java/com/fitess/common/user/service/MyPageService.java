package com.fitess.common.user.service;

import java.util.List;

import com.fitess.common.meal.vo.MealVO;
import com.fitess.common.program.vo.ProgramVO;
import com.fitess.common.trainer.vo.TrainerVO;

public interface MyPageService {
	public char getUserLevel(int userId);

	public List<ProgramVO> getProgramFromUser(int userId);
	public List<MealVO> getMealFromUser(int userId);

	public boolean delProgram(int programId, int userId);
	public boolean delMeal(int mealId, int userId);
	
	public List<TrainerVO> getTrainerRequest();
	
	public void confirmTrainer(boolean whether, int userId);

	public void modifyUser(int userId, String modifyNick, String modifyPassword);
}
