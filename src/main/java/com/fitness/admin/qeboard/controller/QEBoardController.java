package com.fitness.admin.qeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitness.admin.common.paging.Criteria;
import com.fitness.admin.common.paging.PageMaker;
import com.fitness.admin.qeboard.service.QEBoardService;
import com.fitness.admin.qeboard.vo.QEBoardVO;

@Controller
public class QEBoardController {

	@Autowired
	private QEBoardService qEBoardService;
	
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
		return "updateQEBoard";
	}
	
	@RequestMapping(value="updateQEBoard.admin", method=RequestMethod.POST)
	public String updateQEBoard(QEBoardVO vo) {
		System.out.println("QEBoardController.updateQEBoard ����");
		qEBoardService.updateQEBoard(vo);
		return "redirect:/getQEBoard.admin?q_id=" + vo.getQ_id();
	}
	/* ���� ����
	@RequestMapping("deleteQEBoard.admin")
	public String deleteQEBoard(QEBoardVO vo) {
		System.out.println("QEBoardController.deleteQEBoard ����");
		qEBoardService.deleteQEBoard(vo);
		return "redirect:/getQEBoardList.admin";
	}
	*/
	
	@RequestMapping("getQEBoard.admin")
	public String getQEBoard(QEBoardVO vo, Model model) {
		System.out.println("QEBoardController.getQEBoard ����");
		model.addAttribute("qeboard", qEBoardService.getQEBoard(vo));
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
		
		model.addAttribute("qeboardList", qEBoardService.getQEBoardList(cri));
		return "getQEBoardList";
	}
	
}
