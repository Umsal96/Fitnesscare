package com.fitness.admin.common.mail;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// ������ ���� ���� ���� ���, �񵿱�� �����ϵ��� �����ϸ� 
// ���� ������ �۾��� ���� �����ϱ� ������ 
// �ٸ� ���� ���� �۾��� ���� ������ ��ٸ� �ʿ䰡 ����. 
@Controller
@EnableAsync
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="sendMail.admin", method = RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request,
							   HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; Charset=euc-kr'>");
		sb.append("<h1>" + "��ǰ�Ұ�" + "</h1><br />");
		sb.append("�Ű� ������ �Ұ��մϴ�.<br /><br />");
		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&'"
				+ "mailGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>");
		sb.append("<img src='http://image.kyobobook.co.kr/images/book/xlarge/425/'"
				+ "x9788956746425.jpg /> </a><br />");
		sb.append("</a>");
		sb.append("<a href='http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&'"
				+ "mailGb=KOR&barcode=9788956746425&orderClick=LAG&Kc=#N'>��ǰ����</a>");
		sb.append("</body></html>");
		String str = sb.toString();
		mailService.sendMail("ghp008@naver.com", "�׽�Ʈ �����Դϴ�.", str);
		mailService.sendPreConfiguredMail("�׽�Ʈ ����2�Դϴ�.");
		out.print("������ ���½��ϴ�!!!"); 
		
	}
	
}