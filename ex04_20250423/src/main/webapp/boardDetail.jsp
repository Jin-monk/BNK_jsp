<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   		String bno = request.getParameter("bno");
   
   		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:testdb",
			"green",
			"1234");
    
    	String query = "SELECT * FROM BOARD9 WHERE BNO = ? ";
    	PreparedStatement pstmt = conn.prepareStatement(query);
    	pstmt.setString(1,bno);
    	ResultSet rs = pstmt.executeQuery();
    	rs.next();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Datail Page</h1>
	<hr>
		<ul>
			<li>게시판 번호: <%=rs.getString("bno") %></li>
			<li>게시글 제목: <%=rs.getString("title") %></li>
			<li>게시글 내용: <%=rs.getString("content") %></li>
			<li>게시글 작성자: <%=rs.getString("writer") %></li>
			<li>게시 날짜: <%=rs.getString("regdate") %></li>
		</ul>
	<a href="onlyMember.jsp">회원 전용 페이지</a>
</html>