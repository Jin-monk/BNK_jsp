<%@page import="ex04.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member member = (Member)session.getAttribute("loginInfo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 전용 페이지</h1>
	<hr>
	
	<% if (member != null) { %>
    	<h2>환영합니다, <%= member.getName() %>님!</h2>
   		<a href="writeBoard.jsp	">게시글 작성</a><br>
   		<a href="boardList.jsp">게시글 조회</a><br><br>
   		
   		<a href="logout.jsp">로그아웃</a><br>
   		<a href="index.jsp">처음으로 돌아가기</a>
   		
   		
	<% } else { %>
   		<h2>로그인이 필요합니다.</h2>
    	<a href="login.jsp">로그인하러 가기</a>
	<% } %>
</body>
</html>