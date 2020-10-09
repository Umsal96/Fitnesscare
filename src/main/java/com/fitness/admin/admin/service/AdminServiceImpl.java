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
		System.out.println("AdminService.insertAdmin ����");
		adminDAO.insertAdmin(vo);
	}

	@Override
	public void updateAdmin(AdminVO vo) {
		System.out.println("AdminService.updateAdmin ����");
		adminDAO.updateAdmin(vo);
	}

	@Override
	public void deleteAdmin(AdminVO vo) {
		System.out.println("AdminService.deleteAdmin ����");
		adminDAO.deleteAdmin(vo);
	}
	
	@Override
	public AdminVO getAdmin(AdminVO vo) {
		System.out.println("AdminService.getAdmin ����");
		return adminDAO.getAdmin(vo);
	}

	@Override
	public List<AdminVO> getAdminList(AdminVO vo) {
		System.out.println("AdminService.getAdminList ����");
		return adminDAO.getAdminList(vo);
	}

}
