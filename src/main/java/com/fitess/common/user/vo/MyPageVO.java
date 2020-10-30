package com.fitess.common.user.vo;

public class MyPageVO {
	private int user_id;
	private String user_nick;
	private String user_pw;
	
	@Override
	public String toString() {
		return "MyPageVO [user_id=" + user_id + ", user_nick=" + user_nick + ", user_pw=" + user_pw + "]";
	}
	public MyPageVO(int user_id, String user_nick, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_nick = user_nick;
		this.user_pw = user_pw;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
	
}
