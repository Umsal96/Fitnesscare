package com.fitess.common.user.dao;

import java.util.List;

import com.fitess.common.meal.vo.MealVO;
import com.fitess.common.program.vo.ProgramVO;
import com.fitess.common.trainer.vo.TrainerVO;

public interface MyPageDAO {
	// 유저의 등급을 확인하는 로직
	// return -> U : User, T : Trainer, A : Admin
	public char getUserLevel(int userId);

	// 각 사용자가 작성한 프로그램, 식단 추출 로직
	public List<ProgramVO> getProgramFromUser(int userId);
	public List<MealVO> getMealFromUser(int userId);

	// 프로그램과 식단 삭제 로직
	// del에 userId가 사용되는 이유는 삭제 권한이 있는지 확인하기 위함임.
	// 삭제 권한이 있는 지 확인 후 권한이 있다면 삭제 후 true 리턴
	public boolean delProgram(int programId, int userId);
	public boolean delMeal(int mealId, int userId);
	
	// 전문가 신청 확인 로직 (관리자)
	public List<TrainerVO> getTrainerRequest();
	
	// 전문가 신청 승인/거부 로직 (관리자)
	// confirm : true, defuse : false
	public void confirmTrainer(boolean whether, int userId);

	// 정보 수정 로직
	public boolean modifyUser(int userId, String modifyNick, String modifyPassword);
}
