package com.fitess.common.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitess.common.user.service.MapKakaoService;
import com.fitess.common.user.vo.HealthTeamVO;

@Controller
public class MapKakaoController {
	@Autowired
	private MapKakaoService mapkakaoservice;
	
	@RequestMapping("/insertMap.do")
	public String insertMap(HealthTeamVO vo) {
		System.out.println("controller에서 map 등록");
		mapkakaoservice.insertMap(vo);
		return "redirect:/getMapList.do";
	}
	@RequestMapping("/getMapList.do")
	public String getMapList(HealthTeamVO vo, Model model) {
		System.out.println("controller에서 게시판 목록 보기");
		model.addAttribute("mapList", mapkakaoservice.getMapList(vo));
		return "getMapList";
	}
	@RequestMapping("/getMap.do")
	public String getMap(HealthTeamVO vo, Model model) {
		System.out.println("controller에서 글 하나 가셔오기");
		model.addAttribute("mapOne", mapkakaoservice.getMap(vo));
		return "getMap";
	}
}
