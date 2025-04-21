<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
/*스크립트릿*/

<%
	//request, response --> 내장객체. jsp에 필요하므로 이미 만들어져 있음. 

	//파라미터를 받아서 변수에 할당.
	//http://localhost:8080/test/req1.jsp?username=aaa&age=21
	//?username=법진&age=28&hobbis=독서&hobbies=코딩&bgcolor=blue
	String param1 = request.getParameter("username");
	String param2 = request.getParameter("age");
	String[] hobbies = request.getParameterValues("hobbies");
	
	String bgcolor = request.getParameter("bgcolor");
	
	System.out.println(param1);
	System.out.println(param2);
	System.out.println(hobbies[0]);
	System.out.println(hobbies[1]);
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		background-color : <%=bgcolor%>
	}
</style>
</head>
<body>

	<h1>REQ1 Page</h1>
	<hr>
	username = <%=param1 %><br>
	age = <%=param2 %><br>
	hobby1 = <%=hobbies[0] %><br>
	hobby2 = <%=hobbies[1] %>
	
</body>
</html>