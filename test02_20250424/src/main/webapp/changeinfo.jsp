<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String custNo = request.getParameter("custNo");
    	String custName = request.getParameter("custName");
    	String phone = request.getParameter("phone");
    	String address = request.getParameter("address");
    	String joinDate = request.getParameter("joinDate");
    	String grade = request.getParameter("grade");
    	String city = request.getParameter("city");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<hr>
	<form action="ChangeMemberInfo" method="POST">
	<table border ="1">
		<tr>
			<td>회원번호</td>
			<td><input type="text" name="custno" value="<%=custNo%>"></td>
		</tr>
		<tr>
			<td>회원성명</td>
			<td><input type="text" name="custname" value="<%=custName%>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="<%=phone%>"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" value="<%=address%>"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td><input type="text" name="joinDate" value="<%=joinDate%>"></td>
		</tr>
		<tr>
			<td>고객등급</td>
			<td><input type="text" name="grade" value="<%=grade%>"></td>
		</tr>
		<tr>
			<td>도시코드</td>
			<td><input type="text" name="city" value="<%=city%>"></td>
		</tr>
		
	</table>
	<input type="submit" value="수정">
	</form>
	<a href="index.jsp">홈으로</a>
</body>
</html>