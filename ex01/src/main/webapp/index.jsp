<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<ul>
		<li><a href="registForm.jsp">게시글 등록</a></li>
		<li><a href="boardList.jsp">문서 목록</a></li>
		<li><a href="test">test</a></li>
		<li><a href="test4">test4</a></li>
		
	</ul>
	<hr>
	<h1>GET 방식</h1>
	<form action="test1" method="GET">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>
	<br>
	<hr>
	<h1>POST 방식</h1>
	<form action="test2" method="POST">
		<input type="text" name="name" value="aaa">
		<input type="submit" value="전송">
	</form>
</body>
</html>