package com.fitness.admin.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.admin.admin.dao.AdminDAO;
import com.fitness.admin.admin.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public void insertAdmin(AdminVO vo) {
		System.out.println("AdminService.insertAdmin 角青");
		adminDAO.insertAdmin(vo);
	}

	@Override
	public void updateAdmin(AdminVO vo) {
		System.out.println("AdminService.updateAdmin 角青");
		adminDAO.updateAdmin(vo);
	}

	@Override
	public void deleteAdmin(AdminVO vo) {
		System.out.println("AdminService.deleteAdmin 角青");
		adminDAO.deleteAdmin(vo);
	}
	
	@Override
	public AdminVO getAdmin(AdminVO vo) {
		System.out.println("AdminService.getAdmin 角青");
		return adminDAO.getAdmin(vo);
	}

	@Override
	public List<AdminVO> getAdminList(AdminVO vo) {
		System.out.println("AdminService.getAdminList 角青");
		return adminDAO.getAdminList(vo);
	}

}
