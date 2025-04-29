<%@page import="vo.MemberSales"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MemberSales> msList = (List<MemberSales>) request.getAttribute("msList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>회원이름</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (MemberSales ms : msList) {
		%>
			<tr>
				<td><%=ms.getCustNo()%></td>
				<td><%=ms.getCustName()%></td>
				<td><%=ms.getGrade()%></td>
				<td><%=ms.getSales()%></td>
			</tr>

		</tbody>
		<%
			}
		%>
	</table>
	<a href="index.jsp">홈으로</a>
</body>
</html>