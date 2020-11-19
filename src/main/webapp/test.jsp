<%@page import="java.util.List"%>
<%@page import="com.fitess.common.user.vo.UserVO"%>
<%@page import="com.fitess.common.user.dao.MyPageDAOImpl"%>
<%@page import="com.fitess.common.user.dao.MyPageDAO"%>
<%@page import="com.fitess.common.user.dao.UserDAOImpl"%>
<%@page import="com.fitess.common.user.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyPageDAOImpl dao = MyPageDAOImpl.getInstance();
	char result = dao.getUserLevel(1);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=result %>
</body>
</html>