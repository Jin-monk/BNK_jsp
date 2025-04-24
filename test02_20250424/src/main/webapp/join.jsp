<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록 화면</h1>
	<hr>
	<form action="MemberService" method="POST">
		<!-- 회원번호: <input type="text" name="custno" ><br> -->
		회원성명: <input type="text" name="custname"><br>
		회원전화: <input type="text" name="phone"><br>
		회원주소: <input type="text" name="address"><br>
		가입일자: <input type="text" name="joindate"><br>
		고객등급: <input type="text" name="grade"><br>
		도시코드: <input type="text" name="city"><br>
		<input type="submit" value="등록">
	</form>
	
		<input type="button" onclick="f()" value="조회">
		<script>
			function f(){
				location.href="MemberServiceSelectAll"; 
			}
		</script>
		<a href="index.jsp">홈으로</a>
</body>
</html>