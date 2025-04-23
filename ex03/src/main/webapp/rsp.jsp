<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String result = (String)request.getAttribute("result");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>가위바위보 결과</h1>
	<hr>
	결과 값: <%=result %>
	<br>
	<a href="index.jsp">돌아가기</a>
</body>
</html>