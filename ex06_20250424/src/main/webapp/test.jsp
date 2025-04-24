<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="header.jsp" %>
	<hr>
	<h2>본 페이지 - ${x }</h2>
	
	<!-- header에서 pagesetAttiribute에서 값이 읽어지기때문에 include 해서 파일을 추가시키면 하나의 파일이 된다. -->
	<input type="button" onclick="f()" value="클릭"/>
	<script>
		function f(){
			alert("버튼이 클릭됨."); <!-- 알림창 -->
			location.href="test?name=james"; /* 위치를 바꾼다. */
		}
	</script>
	
</body>
</html>