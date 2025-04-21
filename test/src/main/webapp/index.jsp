<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index page</h1>
	<hr>

	<form action="req1.jsp" method="GET">
		username : <input type="text" name="username"><br> age :
		<input type="text" name="age"><br> hobby : <input
			type="checkbox" name="hobbies" value="독서">책읽기&nbsp; <input
			type="checkbox" name="hobbies" value="코딩">코딩하기<br>

		bgcolor: <select name="bgcolor">
			<option value="blue">블루</option>
			<option value="red">레드</option>
		</select><br> <input type="submit" value="전송">
	</form>
	<hr>
	<a href="A_STUDENT.jsp">학생목록보기</a>
	<br>
	<a href="a.jsp">A Page 가기</a>
	<!-- <a href="b.jsp">B Page 가기 </a> -->

	<form action="a.jsp" method="get">
	
	</form>
	
</body>
</html>