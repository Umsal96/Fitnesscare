<%@ page import="com.fitness.admin.hteboard.dao.HTEBoardDAO"%>
<%@ page import="com.fitness.admin.hteboard.vo.HTEBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTEBoard</title>
</head>
<body>
	<h1>${hteboard.ht_title}</h1>
	<a href="/getHTEBoardList.admin">위치 공유 게시판 목록으로</a>
	<c:choose>
		<c:when test="${hteboard.ht_type eq 0}">
			<a href="/deleteHTEBoard.admin?ht_id=${hteboard.ht_id}">일반게시글 삭제</a>
		</c:when>
		<c:when test="${hteboard.ht_type eq 1}">
			<a href="/updateHTEBoard.admin?ht_id=${hteboard.ht_id}">공지사항 수정</a>
			<a href="/deleteHTEBoard.admin?ht_id=${hteboard.ht_id}">공지사항 삭제</a>
		</c:when>
	</c:choose>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${hteboard.ht_id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${hteboard.ht_title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${userName}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><fmt:formatDate value="${hteboard.ht_regdate}" dateStyle="default" /></td>
		</tr>
		<tr>
			<th>댓글수</th>
			<td>${hteboard.ht_commentcnt}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${hteboard.ht_content}</td>
		</tr>
		<tr>
			<th>글종류</th>
			<c:choose>
				<c:when test="${hteboard.ht_type eq 0}">
					<td>일반 게시글</td>
				</c:when>
				<c:when test="${hteboard.ht_type eq 1}">
					<td>공지사항</td>
				</c:when>
				<c:otherwise><td>오류</td></c:otherwise>
			</c:choose>
		</tr>
	</table>
	<br />
</body>
</html>