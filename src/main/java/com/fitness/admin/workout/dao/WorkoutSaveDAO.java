package com.fitness.admin.workout.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.admin.workout.vo.WorkoutSaveVO;

@Repository
public class WorkoutSaveDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertWorkoutSave(WorkoutSaveVO vo) {
		System.out.println("WorkoutSaveDAO.insertWorkoutSave ����");
		sqlSessionTemplate.insert("WorkoutSaveDAO.insertWorkoutSave", vo);
	}
	
	public List<WorkoutSaveVO> getWorkoutSaveList(WorkoutSaveVO vo) {
		System.out.println("WorkoutSaveDAO.getWorkoutSaveList ����");
		return sqlSessionTemplate.selectList("WorkoutSaveDAO.getWorkoutSaveList", vo);
	}
	
}
