<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String url = ("jdbc:oracle:thin:@localhost:1521:testdb");
	String id = "green";
	String pw = "1234";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(url, id, pw);
	Statement stmt = conn.createStatement();
	stmt.executeUpdate("INSERT INTO A_STUDENT VALUES('20171748','법진','전자로봇','4','A','M',170,70)");
    
    //바로 b.jsp로 갈거라고 응답함. 그래서 a가 열리기 전에 바로 b로 감. 
    	response.sendRedirect("A_STUDENT.jsp");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>A Page</h1>
	<hr>
	A.jsp 페이지입니다.<br>
	
	<a href="b.jsp">B Page 돌아가기</a>
</body>
</html>