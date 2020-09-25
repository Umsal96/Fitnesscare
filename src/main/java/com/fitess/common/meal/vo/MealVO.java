package com.fitess.common.meal.vo;

import java.sql.Date;

public class MealVO {
	private int meal_id;
	private String meal_name;
	private int user_id;
	private int meal_cmt_cnt;
	private int meal_rd_cnt;
	private Date meal_regdate;
	private int food_list;
	private String meal_link;
	public MealVO(int meal_id, String meal_name, int user_id, int meal_cmt_cnt, int meal_rd_cnt, Date meal_regdate,
			int food_list, String meal_link) {
		super();
		this.meal_id = meal_id;
		this.meal_name = meal_name;
		this.user_id = user_id;
		this.meal_cmt_cnt = meal_cmt_cnt;
		this.meal_rd_cnt = meal_rd_cnt;
		this.meal_regdate = meal_regdate;
		this.food_list = food_list;
		this.meal_link = meal_link;
	}
	public int getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	public String getMeal_name() {
		return meal_name;
	}
	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMeal_cmt_cnt() {
		return meal_cmt_cnt;
	}
	public void setMeal_cmt_cnt(int meal_cmt_cnt) {
		this.meal_cmt_cnt = meal_cmt_cnt;
	}
	public int getMeal_rd_cnt() {
		return meal_rd_cnt;
	}
	public void setMeal_rd_cnt(int meal_rd_cnt) {
		this.meal_rd_cnt = meal_rd_cnt;
	}
	public Date getMeal_regdate() {
		return meal_regdate;
	}
	public void setMeal_regdate(Date meal_regdate) {
		this.meal_regdate = meal_regdate;
	}
	public int getFood_list() {
		return food_list;
	}
	public void setFood_list(int food_list) {
		this.food_list = food_list;
	}
	public String getMeal_link() {
		return meal_link;
	}
	public void setMeal_link(String meal_link) {
		this.meal_link = meal_link;
	}
	@Override
	public String toString() {
		return "MealVO [meal_id=" + meal_id + ", meal_name=" + meal_name + ", user_id=" + user_id + ", meal_cmt_cnt="
				+ meal_cmt_cnt + ", meal_rd_cnt=" + meal_rd_cnt + ", meal_regdate=" + meal_regdate + ", food_list="
				+ food_list + ", meal_link=" + meal_link + "]";
	}
	
}
