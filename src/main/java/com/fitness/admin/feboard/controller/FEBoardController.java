package com.fitness.admin.feboard.controller;

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
import com.fitness.admin.feboard.service.FEBoardService;
import com.fitness.admin.feboard.vo.FEBoardVO;
import com.fitness.admin.user.service.UserService;
import com.fitness.admin.user.vo.UserVO;

@Controller
public class FEBoardController {

	@Autowired
	private FEBoardService fEBoardService;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="insertFEBoard", method=RequestMethod.GET)
	public String insertFEBoardFrom(FEBoardVO vo) {
		System.out.println("FEBoardController.insertFEBoardFrom ����");
		return "insertFEBoard";
	}
	
	@RequestMapping(value="insertFEBoard", method=RequestMethod.POST)
	public String insertFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardController.insertFEBoard ����");
		fEBoardService.insertFEBoard(vo);
		return "redirect:/getFEBoardList.admin";
	}
	
	@RequestMapping(value="updateFEBoard", method=RequestMethod.GET)
	public String updateFEBoardFrom(FEBoardVO vo, Model model) {
		System.out.println("FEBoardController.updateFEBoardFrom ����");
		model.addAttribute("feboard", fEBoardService.getFEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "updateFEBoard";
	}
	
	@RequestMapping(value="updateFEBoard", method=RequestMethod.POST)
	public String updateFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardController.updateFEBoard ����");
		fEBoardService.updateFEBoard(vo);
		return "redirect:/getFEBoard.admin?free_id=" + vo.getFree_id();
	}
	
	@RequestMapping("deleteFEBoard")
	public String deleteFEBoard(FEBoardVO vo) {
		System.out.println("FEBoardController.deleteFEBoard ����");
		
		// delete �۾� ��, free_id�� �̿��Ͽ� ������� �̸� �� �̸��� ������ �����´�.
		UserVO uvo = getUserFromId(vo);
		String userName = uvo.getUser_name();
		String userEmail = uvo.getUser_email();
		
		// �Խñ� ����
		fEBoardService.deleteFEBoard(vo);
		
		// �Խñ� ������ ���� ����� ����ڿ��� ���Ϸ� ����
		StringBuffer sb = new StringBuffer();
		sb.append(userName + "���� �ۼ��� �Խñ��� �����ڿ� ���� ���� ó���Ǿ����ϴ�. <br />");
		sb.append("�ڼ��� ������ ������(ghp0405@gmail.com)���� �����Ͽ��ֽʽÿ�.<br />");
		String str = sb.toString();
		mailService.sendMail(userEmail, userName + "���� �Խñ��� �����Ǿ����ϴ�.", str);
		
		return "redirect:/getFEBoardList.admin";
	}
	
	@RequestMapping("getFEBoard")
	public String getFEBoard(FEBoardVO vo, Model model) {
		System.out.println("FEBoardController.getFEBoard ����");
		model.addAttribute("feboard", fEBoardService.getFEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "getFEBoard";
	}
	
	@RequestMapping("getFEBoardList")
	public String getFEBoardList(Criteria cri, Model model) {
		System.out.println("FEBoardController.getFEBoardList ����");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(fEBoardService.getFEBoardCount());
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		
		// �ۼ��ڶ��� user_id ��� ���� ����� �̸��� ���� �� �ֵ���
		// ����� �̸����� ���� list�� �����.
		List<FEBoardVO> feList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		feList = fEBoardService.getFEBoardList(cri);
		for(int i = 0; i < feList.size(); i++) {
			userList.add(i, getUserFromId(feList.get(i)).getUser_name());
		}
		
		model.addAttribute("feboardList", feList);
		model.addAttribute("userList", userList);
		return "getFEBoardList";
	}
	
	// vo��ü�� id���� �������� ������� ������ �������� �޼���
	public UserVO getUserFromId(FEBoardVO vo) {
		vo = fEBoardService.getFEBoard(vo);
		UserVO uvo = new UserVO();
		uvo.setUser_id(vo.getUser_id());
		return userService.getUser(uvo);
	}
	
}
