package com.fitess.common.user.service;

import java.util.List;

import com.fitess.common.meal.vo.MealVO;
import com.fitess.common.program.vo.ProgramVO;
import com.fitess.common.trainer.vo.TrainerVO;
import com.fitess.common.user.vo.UserVO;

public interface MyPageService {
	public char getUserLevel(int user_id);

	public List<ProgramVO> getProgramFromUser(UserVO vo);
	public List<MealVO> getMealFromUser(UserVO vo);

	public boolean delProgram(int programId, int userId);
	public boolean delMeal(int mealId, int userId);
	
	public List<TrainerVO> getTrainerRequest();
	
	public void confirmTrainer(boolean whether, int userId);

	public void modifyUser(UserVO vo);
}
