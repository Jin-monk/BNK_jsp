<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	
	<form action ="MemberServlet" method="GET">
		ID:   <input type="text" name="id" ><br>
		PW:   <input type="text" name="pw" ><br>
		NAME: <input type="text" name="name" ><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>