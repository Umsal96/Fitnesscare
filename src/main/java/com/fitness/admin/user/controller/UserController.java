package com.fitness.admin.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitness.admin.common.mail.MailService;
import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.common.paging.PageMaker;
import com.fitness.admin.user.service.UserService;
import com.fitness.admin.user.vo.UserVO;

@Controller
@EnableAsync
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MailService mailService;
	
	@RequestMapping("suspendUser.admin")
	public String suspendUser(UserVO vo, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		System.out.println("UserController.suspendUser ����");
		userService.suspendUser(vo);
		
		// ��� ������ ��ǿ� ���� ������ ��� ����ڿ��� �����Ѵ�.
		StringBuffer sb = new StringBuffer();
		sb.append("�����ڿ� ���� " + vo.getUser_email() + "������ �����Ǿ����ϴ�.<br />");
		sb.append("�ڼ��� ������ ������(ghp0405@gmail.com)���� �����Ͽ� �ֽʽÿ�.");
		String str = sb.toString();
		mailService.sendMail(vo.getUser_email().toString(), 
				vo.getUser_email().toString() + " ������ �����Ǿ����ϴ�.", str);
		
		return "redirect:/getUserList.admin";
	}
	
	@RequestMapping("unsuspendUser.admin")
	public String unsuspendUser(UserVO vo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("UserController.unsuspendUser ����");
		userService.unsuspendUser(vo);
		
		// ��� ���� ������ ��ǿ� ���� ������ ��� ����ڿ��� �����Ѵ�.
		StringBuffer sb = new StringBuffer();
		sb.append(vo.getUser_email() + "������ ���� ������ �����Ǿ����ϴ�. <br />");
		sb.append("�ڼ��� ������ ������(ghp0405@gmail.com)���� �����Ͽ� �ֽʽÿ�.");
		String str = sb.toString();
		mailService.sendMail(vo.getUser_email().toString(), 
				vo.getUser_email().toString() + " ������ ���� ������ �����Ǿ����ϴ�.", str);
		
		return "redirect:/getUserList.admin";
	}
	
	@RequestMapping("getUser.admin")
	public String getUser(UserVO vo, Model model) {
		System.out.println("UserController.getUser ����");
		model.addAttribute("user", userService.getUser(vo));
		return "getUser";
	}
	
	@RequestMapping("getUserList.admin")
	public String getUserList(Model model, Criteria cri) {
		System.out.println("UserController.getUserList ����");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userService.getUserCount());
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("userList", userService.getUserList(cri));
		return "getUserList";
	}
	
}
