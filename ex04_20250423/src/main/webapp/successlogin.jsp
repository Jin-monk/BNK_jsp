<%@page import="ex04.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member member=(Member)session.getAttribute("loginInfo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Success</h1>
	<hr>
	<h3><%=member.getName()%>님 환영합니다 ! </h3>
	<a href="index.jsp">처음으로 돌아가기</a>
</body>
</html>