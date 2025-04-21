<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  		//1.파라미터 받기
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	String writer = request.getParameter("writer");
    	
  		//2. DB접속하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
  		Connection conn = DriverManager.getConnection(
  				"jdbc:oracle:thin:@localhost:1521:testdb",
  				"green",
  				"1234"
  				);
  		//3. 쿼리 실행하기 (INSERT)
  		String query = "INSERT INTO TBL_BOARD VALUES(SEQ_BOARD.NEXTVAL,?,?,?,SYSDATE)";
  		PreparedStatement pstmt = conn.prepareStatement(query);
  		pstmt.setString(1, title);
  		pstmt.setString(2, content);
  		pstmt.setString(3, writer);
  		
  		pstmt.executeUpdate();
  		//4. 페이지 이동하기.
    	response.sendRedirect("index.jsp");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>