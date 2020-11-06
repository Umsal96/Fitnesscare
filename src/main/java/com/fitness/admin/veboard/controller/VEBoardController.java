package com.fitness.admin.veboard.controller;

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
import com.fitness.admin.user.service.UserService;
import com.fitness.admin.user.vo.UserVO;
import com.fitness.admin.veboard.service.VEBoardService;
import com.fitness.admin.veboard.vo.VEBoardVO;

@Controller
public class VEBoardController {

	@Autowired
	private VEBoardService vEBoardService;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="insertVEBoard.admin", method=RequestMethod.GET)
	public String insertVEBoardForm(VEBoardVO vo) {
		System.out.println("VEBoardController.insertVEBoardForm ����");
		return "insertVEBoard";
	}
	
	@RequestMapping(value="insertVEBoard.admin", method=RequestMethod.POST)
	public String insertVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardController.insertVEBoard ����");
		vEBoardService.insertVEBoard(vo);
		return "redirect:/getVEBoardList.admin";
	}
	
	@RequestMapping(value="updateVEBoard.admin", method=RequestMethod.GET)
	public String updateVEBoardForm(VEBoardVO vo, Model model) {
		System.out.println("VEBoardController.updateVEBoardForm ����");
		model.addAttribute("veboard", vEBoardService.getVEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "updateVEBoard";
	}
	
	@RequestMapping(value="updateVEBoard.admin", method=RequestMethod.POST)
	public String updateVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardController.updateVEBoard ����");
		vEBoardService.updateVEBoard(vo);
		return "redirect:/getVEBoard.admin?ex_id=" + vo.getEx_id();
	}
	
	@RequestMapping("deleteVEBoard.admin")
	public String deleteVEBoard(VEBoardVO vo) {
		System.out.println("VEBoardController.deleteVEBoard ����");
		
		// �Խñ��� �����ϱ� ��, vo��ü�� id���� �̿��Ͽ� ������� �̸� �� �̸����� �˾Ƴ���.
		vo = vEBoardService.getVEBoard(vo);
		UserVO uvo = new UserVO();
		uvo.setUser_id(vo.getUser_id());
		uvo = userService.getUser(uvo);
		String userName = uvo.getUser_name();
		String userEmail = uvo.getUser_email();
		
		vEBoardService.deleteVEBoard(vo);
		
		// ����ڿ��� �Խñ� ������ ���� ����� ���Ϸ� ����
		StringBuffer sb = new StringBuffer();
		sb.append(userName + "���� �ۼ��� �Խñ��� �����ڿ� ���� ���� ó���Ǿ����ϴ�.<br />");
		sb.append("�ڼ��� ������ ������(ghp0405@gmail.com)���� �����Ͽ��ֽʽÿ�.<br />");
		String str = sb.toString();
		mailService.sendMail(userEmail, userName + "���� �Խñ��� �����Ǿ����ϴ�.", str);
		
		return "redirect:/getVEBoardList.admin";
	}
	
	@RequestMapping("getVEBoard.admin")
	public String getVEBoard(VEBoardVO vo, Model model) {
		System.out.println("VEBoardController.getVEBoard ����");
		model.addAttribute("veboard", vEBoardService.getVEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "getVEBoard";
	}
	
	@RequestMapping("getVEBoardList.admin")
	public String getVEBoardList(Model model, Criteria cri) {
		System.out.println("VEBoardController.getVEBoardList ����");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(vEBoardService.getVEBoardCount());
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		
		List<VEBoardVO> veList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		veList = vEBoardService.getVEBoardList(cri);
		for(int i = 0; i < veList.size(); i++) {
			userList.add(i, getUserFromId(veList.get(i)).getUser_name());
		}
		
		model.addAttribute("veboardList", vEBoardService.getVEBoardList(cri));
		model.addAttribute("userList", userList);
		return "getVEBoardList";
	}
	
	public UserVO getUserFromId(VEBoardVO vo) {
		vo = vEBoardService.getVEBoard(vo);
		UserVO uvo = new UserVO();
		uvo.setUser_id(vo.getUser_id());
		return userService.getUser(uvo);
	}
	
}
