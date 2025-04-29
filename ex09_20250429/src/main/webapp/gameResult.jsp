<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int user = (Integer) request.getAttribute("user");
int com = (Integer) request.getAttribute("com");
String result = (String) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* {
	text-align: center;
}

.cardimg {
	height: 100px;
	width: 100px;
	border: 2px solid black;
}

#vs {
	font-size: 20px;
	font-weight: bold;
	margin: 0 20px;
}

#button {
	margin: 0 20px;
}

#vsResult {
	margin-right: 140px;
}

#result {
	font-size: 20px;
	font-weight: bold;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>가위바위보 결과</h1>
	<hr>

	<img src="images/${userImg }" id="myImg" width="100" class="cardimg">
	<span id="vs">VS</span>
	<img src="images/${comImg }" id="comImg" width="100" class="cardimg">
	<br>
	<span id="vsResult">ME</span>COM






	<p>가위바위보 결과 : ${result }</p>
	<a href="game.jsp">다시하기</a>
	<script>
	
	</script>
</body>
</html>