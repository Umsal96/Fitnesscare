package com.fitness.admin.qeboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitness.admin.comment.service.CommentService;
import com.fitness.admin.comment.vo.CommentVO;
import com.fitness.admin.common.mail.MailService;
import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.common.paging.PageMaker;
import com.fitness.admin.qeboard.service.QEBoardService;
import com.fitness.admin.qeboard.vo.QEBoardVO;
import com.fitness.admin.user.service.UserService;
import com.fitness.admin.user.vo.UserVO;

@Controller
@EnableAsync
public class QEBoardController {

	@Autowired
	private QEBoardService qEBoardService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private MailService mailService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="insertQEBoard.admin", method=RequestMethod.GET)
	public String insertQEBoardForm(QEBoardVO vo) {
		System.out.println("QEBoardController.insertQEBoardForm ����");
		return "insertQEBoard";
	}
	
	@RequestMapping(value="insertQEBoard.admin", method=RequestMethod.POST)
	public String insertQEBoard(QEBoardVO vo) {
		System.out.println("QEBoardController.insertQEBoard ����");
		qEBoardService.insertQEBoard(vo);
		return "redirect:/getQEBoardList.admin";
	}
	
	@RequestMapping(value="updateQEBoard.admin", method=RequestMethod.GET)
	public String updateQEBoardForm(QEBoardVO vo, Model model) {
		System.out.println("QEBoardController.updateQEBoardForm ����");
		model.addAttribute("qeboard", qEBoardService.getQEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		return "updateQEBoard";
	}
	
	@RequestMapping(value="updateQEBoard.admin", method=RequestMethod.POST)
	public String updateQEBoard(QEBoardVO vo) {
		System.out.println("QEBoardController.updateQEBoard ����");
		qEBoardService.updateQEBoard(vo);
		return "redirect:/getQEBoard.admin?q_id=" + vo.getQ_id();
	}
	
	@RequestMapping("deleteQEBoard.admin")
	public String deleteQEBoard(QEBoardVO vo) {
		System.out.println("QEBoardController.deleteQEBoard ����");
		
		// vo�� ������ �����ϱ� ����, uvo�� �̿��Ͽ� ������� �̸��� �̸��� ������ �����´�.
		// �ش� �۾� ������ deleteQEBoard()�� �����ϸ�, vo��ü�� �������鼭 ������ �������� ���ϰ� �ȴ�.
		UserVO uvo = getUserFromId(vo);
		String userName = uvo.getUser_name();
		String userEmail = uvo.getUser_email();
		
		qEBoardService.deleteQEBoard(vo);
		
		// �Խñ��� ���� ������ ����� �ۼ��ڿ��� ���Ϸ� �˷��ش�.
		StringBuffer sb = new StringBuffer();
		sb.append(userName + "���� �ۼ��� �Խñ��� �����ڿ� ���� ���� ó���Ǿ����ϴ�.<br />");
		sb.append("�ڼ��� ������ ������(ghp0405@gmail.com)���� �����Ͽ��ֽʽÿ�.<br />");
		String str = sb.toString();
		mailService.sendMail(userEmail, userName + "���� �Խñ��� �����Ǿ����ϴ�.", str);
		
		return "redirect:/getQEBoardList.admin";
	}
	
	@RequestMapping("getQEBoard.admin")
	public String getQEBoard(QEBoardVO vo, Model model) {
		System.out.println("QEBoardController.getQEBoard ����");
		model.addAttribute("qeboard", qEBoardService.getQEBoard(vo));
		model.addAttribute("userName", getUserFromId(vo).getUser_name());
		
		// ��� ����
		CommentVO cvo = new CommentVO();
		cvo.setCmt_type("question");
		cvo.setTarget_id(vo.getQ_id());
		model.addAttribute("commentList", commentService.getCommentList(cvo));
		
		return "getQEBoard";
	}
	
	@RequestMapping("getQEBoardList.admin")
	public String getQEBoardList(Model model, Criteria cri) {
		System.out.println("QEBoardController.getQEBoardList ����");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(qEBoardService.getQEBoardCount());
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		
		// �ۼ��ڶ��� user_id ��� ���� ����� �̸��� ���� �� �ֵ���
		// ����� �̸����� ���� list�� �����.
		List<QEBoardVO> qeList = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		qeList = qEBoardService.getQEBoardList(cri);
		for(int i = 0; i < qeList.size(); i++) {
			userList.add(i, getUserFromId(qeList.get(i)).getUser_name());
		}
		
		model.addAttribute("qeboardList", qEBoardService.getQEBoardList(cri));
		model.addAttribute("userList", userList);
		return "getQEBoardList";
	}
	
	// vo ��ü�� id���� �������� �ۼ����� ������ �������� �޼���
	public UserVO getUserFromId(QEBoardVO vo) {
		vo = qEBoardService.getQEBoard(vo);
		UserVO uvo = new UserVO();
		uvo.setUser_id(vo.getUser_id());
		return userService.getUser(uvo);
	}
	
}
