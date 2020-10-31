package com.fitness.admin.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitness.admin.comment.service.CommentService;
import com.fitness.admin.comment.vo.CommentVO;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	// �Ʒ� DML ��ɵ��� form action �Ǵ� url�� ���� �����ǹǷ� controller�� ����
	@RequestMapping("insertComment.admin")
	public String insertComment(CommentVO vo) {
		System.out.println("CommentController.insertComment ����");
		// ���� ����, ������ cmt_id�� �����ͼ� cmt_ref�� �־������
		commentService.insertComment(vo);
		// ��� �Խ����� cmt_type���� ���� return url���� �޶�������
		return "redirect:/getQEBoard.admin?q_id=" + vo.getTarget_id();
	}
	
	@RequestMapping("updateComment.admin")
	public void updateComment(CommentVO vo) {
		System.out.println("CommentController.updateComment ����");
		commentService.updateComment(vo);
	}
	
	@RequestMapping("deleteComment.admin")
	public void deleteComment(CommentVO vo) {
		System.out.println("CommentController.deleteComment ����");
		commentService.deleteComment(vo);
	}
	
}
