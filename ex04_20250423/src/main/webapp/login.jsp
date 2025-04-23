<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<hr>
	
	<form action="login" method="POST">
		ID: <input type="text" name="id">
		PW: <input type="text" name="pw">
		<input type="submit" value="로그인">
	</form>
	<a href="index.jsp">처음으로 돌아가기</a>
	
</body>
</html>