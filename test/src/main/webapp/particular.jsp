<%@page import="java.sql.PreparedStatement"%>
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

String stu_no = request.getParameter("STU_NO");

String query = "SELECT * FROM A_STUDENT WHERE STU_NO =" + stu_no ;
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
rs.next();

String stuNo9 = rs.getString("STU_NO");
String stuName = rs.getString("STU_NAME");
String stuDept = rs.getString("STU_DEPT");
String stuGrade = rs.getString("STU_GRADE");
String stuClass = rs.getString("STU_CLASS");
String stuHeight = rs.getString("STU_HEIGHT");
String stuWeight = rs.getString("STU_WEIGHT");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>A_STUDENT 상세페이지</h1>
	<br>
	<h4>
		번호:
		<%=stuNo9%></h4>
	<h4>
		이름:
		<%=stuName%>
	</h4>
	<h4>
		학과:
		<%=stuDept%></h4>
	<h4>
		학년:
		<%=stuGrade%></h4>
	<h4>
		반:
		<%=stuClass%></h4>
	<h4>
		키:
		<%=stuHeight%></h4>
	<h4>
		몸무게:
		<%=stuWeight%></h4>

	<a href="A_STUDENT.jsp">목록으로 돌아가기</a>
</body>
</html>