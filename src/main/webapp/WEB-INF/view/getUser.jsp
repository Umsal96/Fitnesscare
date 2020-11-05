<%@page import="com.fitess.common.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	UserVO userInfo = (UserVO) session.getAttribute("userInfo");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보</title>
</head>
<body>	
	<h1>회원정보</h1>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>UserName</th>
			<th>UserEmail</th>
			<th>UserNick</th>
			<th>UserPw</th>
			<th>TermOne</th>
			<th>TermTwo</th>
			<th>UserCheckDate1</th>
			<th>UserCheckDate2</th>	
		</tr>
		<tr>
			<td>${userInfo.user_id }</td>
			<td>${userInfo.user_name }</td>
			<td>${userInfo.user_email }</td>
			<td>${userInfo.user_nick }</td>
			<td>${userInfo.user_pw }</td>
			<td>${userInfo.term_one }</td>
			<td>${userInfo.term_two }</td>
			<td>${userInfo.user_check_date1 }</td>
			<td>${userInfo.user_check_date2 }</td>
		</tr>
		<tr>
			<th>TermType1</th>
			<th>TermType2</th>
			<th>UserRegDate</th>
			<th>UserLoginMethod</th>
			<th>UserLevel</th>
			<th>UserState</th>
			<th>UserReportCount</th>
		</tr>
		<tr>
			<td>${userInfo.term_type1 }</td>
			<td>${userInfo.term_type2 }</td>
			<td>${userInfo.user_regdate }</td>
			<td>${userInfo.user_loginMethod }</td>
			<td>${userInfo.user_level }</td>
			<td>${userInfo.user_state }</td>
			<td>${userInfo.user_report_count }</td>
		</tr>		
	</table>
	
	<a href="kakaoApiMap.jsp?id=${userInfo.user_id }">헬스 장소 공유 등록</a>
	<a href="comment.do?nick=${userInfo.user_nick }">댓글 달기</a>
</body>
</html>