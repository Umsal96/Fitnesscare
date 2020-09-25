package com.fitess.common.trainer.vo;

import java.sql.Date;

public class TrainerVO {
	private int t_id;
	private int user_id;
	private String t_picture_link;
	private String t_cname;
	private String t_company;
	private Date t_createdate;
	private String t_clink;
	private Date t_checkdate;
	
	public TrainerVO(int t_id, int user_id, String t_picture_link, String t_cname, String t_company, Date t_createdate,
			String t_clink, Date t_checkdate) {
		super();
		this.t_id = t_id;
		this.user_id = user_id;
		this.t_picture_link = t_picture_link;
		this.t_cname = t_cname;
		this.t_company = t_company;
		this.t_createdate = t_createdate;
		this.t_clink = t_clink;
		this.t_checkdate = t_checkdate;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getT_picture_link() {
		return t_picture_link;
	}
	public void setT_picture_link(String t_picture_link) {
		this.t_picture_link = t_picture_link;
	}
	public String getT_cname() {
		return t_cname;
	}
	public void setT_cname(String t_cname) {
		this.t_cname = t_cname;
	}
	public String getT_company() {
		return t_company;
	}
	public void setT_company(String t_company) {
		this.t_company = t_company;
	}
	public Date getT_createdate() {
		return t_createdate;
	}
	public void setT_createdate(Date t_createdate) {
		this.t_createdate = t_createdate;
	}
	public String getT_clink() {
		return t_clink;
	}
	public void setT_clink(String t_clink) {
		this.t_clink = t_clink;
	}
	public Date getT_checkdate() {
		return t_checkdate;
	}
	public void setT_checkdate(Date t_checkdate) {
		this.t_checkdate = t_checkdate;
	}
	@Override
	public String toString() {
		return "TrainerVO [t_id=" + t_id + ", user_id=" + user_id + ", t_picture_link=" + t_picture_link + ", t_cname="
				+ t_cname + ", t_company=" + t_company + ", t_createdate=" + t_createdate + ", t_clink=" + t_clink
				+ ", t_checkdate=" + t_checkdate + "]";
	}
	
}
