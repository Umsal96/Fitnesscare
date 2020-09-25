package com.fitess.common.user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fitess.common.meal.vo.MealVO;
import com.fitess.common.program.vo.ProgramVO;
import com.fitess.common.trainer.vo.TrainerVO;

public class MyPageDAOImpl implements MyPageDAO {
	@Override
	public char getUserLevel(int userId) {
		char userLevel = 'U';
		String sql = "SELECT user_level FROM user_info WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection(); // Modify this after creating a connection object
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			userLevel = rs.getChar("user_level");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userLevel;
	}

	@Override
	public List<ProgramVO> getProgramFromUser(int userId) {
		List<ProgramVO> programList = new ArrayList<>();
		String sql = "SELECT * FROM program WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProgramVO program = new ProgramVO(
						rs.getInt("program_id"), 
						rs.getString("program_name"),
						rs.getInt("user_id"), 
						rs.getInt("program_cmt_cnt"), 
						rs.getInt("program_rd_cnt"),
						rs.getDate("program_regdate"),
						rs.getInt("workout_list"), 
						rs.getString("program_link")
						);
				programList.add(program);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return programList;
	}

	@Override
	public List<MealVO> getMealFromUser(int userId) {
		List<MealVO> mealList = new ArrayList<>();
		String sql = "SELECT * FROM meal WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MealVO meal = new MealVO(
						rs.getInt("meal_id"), 
						rs.getString("meal_name"), 
						rs.getInt("user_id"),
						rs.getInt("meal_cmt_cnt"), 
						rs.getInt("meal_rd_cnt"), 
						rs.getDate("meal_regdate"),
						rs.getInt("food_list"), 
						rs.getString("meal_link")
						);
				mealList.add(meal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealList;
	}

	@Override
	public boolean delProgram(int programId, int userId) {
		boolean checkDel = false;
		String checksql = "SELECT * FROM program WHERE program_id=?";
		String sql = "DELETE FROM program WHERE program_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement checkPstmt = null;
		ResultSet rs = null;
		ResultSet checkRs = null;
		try {
			conn = getConnection();
			checkPstmt = conn.prepareStatement(checksql);
			checkPstmt.setInt(1, programId);
			checkRs = checkPstmt.executeQuery();
			if (checkRs.getInt("user_id") == userId) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, programId);
				rs = pstmt.executeQuery();
				checkDel = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkDel;
	}

	@Override
	public boolean delMeal(int mealId, int userId) {
		boolean checkDel = false;
		String checksql = "SELECT * FROM meal WHERE program_id=?";
		String sql = "DELETE FROM meal WHERE program_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement checkPstmt = null;
		ResultSet rs = null;
		ResultSet checkRs = null;
		try {
			conn = getConnection();
			checkPstmt = conn.prepareStatement(checksql);
			checkPstmt.setInt(1, mealId);
			checkRs = checkPstmt.executeQuery();
			if (checkRs.getInt("user_id") == userId) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mealId);
				rs = pstmt.executeQuery();
				checkDel = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkDel;
	}
	
	@Override
	public List<TrainerVO> getTrainerRequest() {
		List<TrainerVO> trainerList = new ArrayList<>();
		String sql = "SELECT * FROM trainer_cert WHERE t_checkdate=NULL";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TrainerVO trainer = new TrainerVO(
						rs.getInt("t_id"), 
						rs.getInt("user_id"),
						rs.getString("t_picture_link"),
						rs.getString("t_cname"),
						rs.getString("t_company"),
						rs.getDate("t_createdate"),
						rs.getString("t_clink"),
						rs.getDate("t_checkdate")
						);
				trainerList.add(trainer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainerList;
	}

	@Override
	public void confirmTrainer(boolean whether, int userId) {
		String confirmSql = "UPDATE trainer_cert SET t_checkdate=SYSDATE WHERE user_id=?";
		String refuseSql = "DELETE FROM trainer_cert WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (whether) {
				conn = getConnection();
				pstmt = conn.prepareStatement(confirmSql);
				pstmt.setInt(1, userId);
				rs = pstmt.executeQuery();
			} else {
				conn = getConnection();
				pstmt = conn.prepareStatement(refuseSql);
				pstmt.setInt(1, userId);
				rs = pstmt.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean modifyUser(int userId, String modifyNick, String modifyPassword) {
		boolean check = false;
		String sql = "UPDATE user_info SET user_nick=?, user_pw=? WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyNick);
			pstmt.setString(2, modifyPassword);
			pstmt.setInt(3, userId);
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

}
