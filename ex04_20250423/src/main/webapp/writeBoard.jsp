<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Write Board Page</h1>
	<hr>
	
	<form action="BoardServlet" method="POST">
		제목 :  <input type="textarea" name="title"><br>
		내용 :  <input type="textarea" name="content"><br>
		작성일자 : <input type="text" name="date">
		<input type="submit" value="작성">
	</form>
	<br>
	<a href="onlyMember.jsp">회원 전용 페이지</a>
</body>
</html>