<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P4 Page</h1>
	<hr>
	
	<%
		String fruit = (String)request.getAttribute("fruit");
		String subject = (String)request.getAttribute("subject");
		String animal = (String)request.getAttribute("animal");
		String[] movie = (String[])request.getAttribute("movie");
	%>
	
	내가 좋아하는 과일: <%=fruit %><br>
	내가 좋아하는 과목: <%=subject %><br>
	내가 좋아하는 동물: <%=animal %><br>
	내가 좋아하는 영화: 
	<%
		for(int i = 0 ; i < movie.length; i ++){
	%>
		<%=movie[i] %>
	<%
		}
	%>
</body>
</html>