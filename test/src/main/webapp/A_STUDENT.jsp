<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="test.Emp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>A_STUDENT List Page</h1>
	<hr>
	<%
		String url = ("jdbc:oracle:thin:@localhost:1521:testdb");
		String id = "green";
		String pw = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, id, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM a_student");
		
		/* while(rs.next()){
			List<Emp> eList = new ArrayList<>();
			Emp emp = new Emp();
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			
			emp.setEmpno(empno);
			emp.setEname(ename);
			eList.add(emp);
			
			
			for(Emp e: eList){
				
			} 
		}*/
	%>
	
	<table border = "1">
		<thead>
			<tr>
				<th>STU_NO</th>
				<th>STU_NAME</th>
				<th>STU_DEPT</th>
				<th>STU_GRADE</th>
				<th>STU_CLASS</th>
				<th>STU_GENDER</th>
				<th>STU_HEIGHT</th>
				<th>STU_WEIGHT</th>
			</tr>
		</thead>
		<tboby>
		<%
			while(rs.next()){
		%>
			<tr>
				<td><%=rs.getString("STU_NO") %></td>
				<td> 
					<a href="particular.jsp?STU_NO=<%=rs.getString("STU_NO") %>">
						<%=rs.getString("STU_NAME") %>	
					</a>
				</td>
				<td><%=rs.getString("STU_DEPT") %></td>
				<td><%=rs.getString("STU_GRADE") %></td>
				<td><%=rs.getString("STU_CLASS") %></td>
				<td><%=rs.getString("STU_GENDER") %></td>
				<td><%=rs.getString("STU_HEIGHT") %></td>
				<td><%=rs.getString("STU_WEIGHT") %></td>
				
			</tr>
		<%
			}
		%>
	
	
	</table>
</body>
</html>