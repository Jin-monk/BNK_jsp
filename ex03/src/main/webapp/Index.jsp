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
	
	<h2>GET 방식 1 - a 태그 활용</h2>
	<a href="p1.jsp">p1 페이지로 가기 (jsp로 바로 연결)</a><br>	
	<a href="p1">p1 페이지로 가기 (servlet를 통해 연결)</a>
	
	<h2>GET 방식 2 - a 태그 활용(파라미터 보내기 --> 쿼리스트링 만들기)</h2>
	<a href="p2.jsp?name=James&age=26">p2 페이지로 가기 (jsp로 바로 연결)</a><br>	
	<a href="p2?name=James&age=26">p2 페이지로 가기 (servlet를 통해 연결)</a>
	
	
	<h2>GET 방식 3 - form 활용 (쿼리스트링 자동 생성)</h2>
	<form action="p3.jsp" method="GET">
		<!-- ?fruit=apple -->
		<input type="text" name="fruit" value="apple"><br>
		<input type="radio" name="subject" value="JAVA">JAVA
		<input type="radio" name="subject" value="SQL">SQL
		<input type="radio" name="subject" value="HTML/CSS">HTML/CSS<br>
		<select name="animal">
			<option value="강아지">강아지</option>
			<option value="고양이">고양이</option>
			<option value="tiger">호랑이</option>
		</select><br>
		<input type="checkbox" name ="movie" value="The Round Up1">범죄도시1
		<input type="checkbox" name ="movie" value="The Round Up2">범죄도시2
		<input type="checkbox" name ="movie" value="The Round Up3">범죄도시3
		<input type="checkbox" name ="movie" value="The Round Up4">범죄도시4
		<input type="submit" value="전송">
	</form>
	
	
	
	<h2>GET 방식 3-2 - form 활용 (쿼리스트링 자동 생성) - 서블릿 활용</h2>
	<form action="p4" method="GET">
		<!-- ?fruit=apple -->
		<input type="text" name="fruit" value="apple"><br>
		<input type="radio" name="subject" value="JAVA">JAVA
		<input type="radio" name="subject" value="SQL">SQL
		<input type="radio" name="subject" value="HTML/CSS">HTML/CSS<br>
		<select name="animal">
			<option value="강아지">강아지</option>
			<option value="고양이">고양이</option>
			<option value="tiger">호랑이</option>
		</select><br>
		<input type="checkbox" name ="movie" value="The Round Up1">범죄도시1
		<input type="checkbox" name ="movie" value="The Round Up2">범죄도시2
		<input type="checkbox" name ="movie" value="The Round Up3">범죄도시3
		<input type="checkbox" name ="movie" value="The Round Up4">범죄도시4
		<input type="submit" value="전송">
	</form>
	<!-- 더하기 계산기 -->
	<hr> 
	<h1> 더하기 계산기</h1>
	<form action="p5" method = "GET">
		<input type="text" name="num1" > +
		<input type="text" name="num2" >
		<input type="submit" value="더하기" name="더하기" >
		<input type="submit" value="곱하기" name="곱하기" >
	</form>
	<br>
	
	<!-- 가위바위보 게임 -->
	<hr>
	<h1> 가위바위보 게임 </h1>
	<form action="rsp" method = "GET">
		<input type="radio" name="turn" value="가위">가위
		<input type="radio" name="turn" value="바위">바위
		<input type="radio" name="turn" value="보">보
		<input type="submit" value="결과보기">
	</form>
	
</body>
</html>