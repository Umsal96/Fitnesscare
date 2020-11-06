package com.fitness.admin.hteboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitness.admin.common.mail.MailService;
import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.common.paging.PageMaker;
import com.fitness.admin.hteboard.service.HTEBoardService;
import com.fitness.admin.hteboard.vo.HTEBoardVO;
import com.fitness.admin.user.service.UserService;
import com.fitness.admin.user.vo.UserVO;

@Controller
public class HTEBoardController {

	@Autowired
	private HTEBoardService hTEBoardService;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="insertHTEBoard", method=RequestMethod.GET)
	public String insertHTEBoardForm(HTEBoardVO vo) {
		System.out.println("HTEBoardController.insertHTEBoardForm ����");
		return "insertHTEBoard";
	}
	
	@RequestMapping(value="insertHTEBoard", method=RequestMethod.POST)
	public String insertHTEBoard(HTEBoardVO vo) {
		System.out.println("HTEBoardController.insertHTEBoard ����");
		hTEBoardService.insertHTEBoard(vo);
		return "redirect:/getHTEBoardList.admin";
	}
	
	@RequestMapping(value="updateHTEBoard", method=RequestMethod.GET)
	public String updateHTEBoardForm(HTEBoardVO vo, Model model) {
		System.out.println("HTEBoardController.updateHTEBoardForm ����");
		model.addAttribute("hteboard", hTEBoardService.getHTEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "updateHTEBoard";
	}
	
	@RequestMapping(value="updateHTEBoard", method=RequestMethod.POST)
	public String updateHTEBoard(HTEBoardVO vo) {
		System.out.println("HTEBoardController.updateHTEBoard ����");
		hTEBoardService.updateHTEBoard(vo);
		return "redirect:/getHTEBoard.admin?ht_id=" + vo.getHt_id();
	}
	
	@RequestMapping("deleteHTEBoard")
	public String deleteHTEBoard(HTEBoardVO vo) {
		System.out.println("HTEBoardController.deleteHTEBoard ����");
		
		// �Խñ� ���� ���� vo��ü�� �̿�, ������� �̸��� �̸����� �����´�.
		UserVO uvo = getUserFromId(vo);
		String userName = uvo.getUser_name();
		String userEmail = uvo.getUser_email();
		
		// �Խñ� ����
		hTEBoardService.deleteHTEBoard(vo);
		
		// �Խñ� ������ ���� ����ڿ��� �ش� ����� ���Ϸ� �����Ѵ�.
		StringBuffer sb = new StringBuffer();
		sb.append(userName + "���� �ۼ��� �Խñ��� �����ڿ� ���� ���� ó���Ǿ����ϴ�.<br />");
		sb.append("�ڼ��� ������ ������(ghp0405@gmail.com)���� �����Ͽ��ֽʽÿ�.<br />");
		String str = sb.toString();
		mailService.sendMail(userEmail, userName + "���� �Խñ��� �����Ǿ����ϴ�.", str);
		
		return "redirect:/getHTEBoardList.admin";
	}
	
	@RequestMapping("getHTEBoard.admin")
	public String getHTEBoard(HTEBoardVO vo, Model model) {
		System.out.println("HTEBoardController.getHTEBoard ����");
		model.addAttribute("hteboard", hTEBoardService.getHTEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "getHTEBoard";
	}
	
	@RequestMapping("getHTEBoardList.admin")
	public String getHTEBoardList(Criteria cri, Model model) {
		System.out.println("HTEBoardController.getHTEBoardList ����");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(hTEBoardService.getHTEBoardCount());
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		
		List<HTEBoardVO> hteList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		hteList = hTEBoardService.getHTEBoardList(cri);
		for(int i = 0; i < hteList.size(); i++) {
			userList.add(i, getUserFromId(hteList.get(i)).getUser_name());
		}
		
		model.addAttribute("hteboardList", hteList);
		model.addAttribute("userList", userList);
		return "getHTEBoardList";
	}
	
	public UserVO getUserFromId(HTEBoardVO vo) {
		vo = hTEBoardService.getHTEBoard(vo);
		UserVO uvo = new UserVO();
		uvo.setUser_id(vo.getUser_id());
		return userService.getUser(uvo);
	}
	
}
