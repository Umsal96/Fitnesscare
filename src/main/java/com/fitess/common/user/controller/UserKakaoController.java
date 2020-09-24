package com.fitess.common.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fitess.common.user.service.UserKakaoService;
import com.fitess.common.user.service.UserService;
import com.fitess.common.user.vo.UserVO;

@Controller
public class UserKakaoController {
	
	@Autowired
	private UserKakaoService userkakaoService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/kakaoredirect.do")
	public String K_loginUser(@RequestParam("code") String code, Model model, HttpSession session) {
		// System.out.println("code : " + code);

		String access_Token = userkakaoService.getAccessToken(code);
		HashMap<String, Object> userInfo = userkakaoService.getUserInfo(access_Token);
		System.out.println("login Controller :" + userInfo);
		
		//kakao api�� �̿��� �̸��� ��������
		String kakaoId = (String) userInfo.get("email");
		
		//������ �̸����� �̿��ؼ� ������ �ִ��� Ȯ��
		UserVO KakaoUser = userService.userLogin(kakaoId);
		
		//�ִٸ� �α��� ȭ������ �̵�
		if (KakaoUser != null) {
			model.addAttribute("userInfo", KakaoUser);
			return "getUser";
		}
		
		if (userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("userNick", userInfo.get("nickname"));
			session.setAttribute("access_Token", access_Token);
		}
		return "redirect:/kakaoredirect.jsp";
	}

	@RequestMapping("/insertKakaoUser.do")
	public String insertKakaoUser(UserVO vo) {
		System.out.println("controller���� kakao ���� ȸ������");
		userkakaoService.insertKakaoUser(vo);
		return "redirect:/getUserList.do";
	}
}
