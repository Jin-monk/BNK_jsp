<%@page import="ex04.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  	 	List<Member> mList = (List<Member>)request.getAttribute("mList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 결과</h1>
	<hr>
	<ul><%
		for(Member m : mList){
	%>
		<li>ID:   <%=m.getId() %><br></li>
		<li>PW:   <%=m.getPw() %><br></li>
		<li>NAME: <%=m.getName() %><br></li>
		<li>GRADE:<%=m.getGrade() %><br></li>
	
	<%
		}
	%>
	</ul>
	<a href="index.jsp">처음으로</a>
</body>
</html>