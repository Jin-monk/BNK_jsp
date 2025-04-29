<%@page import="vo.PCodeList"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//제품코드조회
OrderDao orderDao = new OrderDao();
List<PCodeList> pCList = orderDao.selectByPCodeList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
	<h1>제품코드조회</h1>
	<hr>

	<table border="1">
		<thead>
			<tr>
				<th>제품코드</th>
				<th>제품명</th>
				<th>단가</th>
				<th>할인율(10%)</th>
				<th>할인율(15%)</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (PCodeList pcl : pCList) {
			%>
			<tr>
				<td><%=pcl.getPCode()%></td>
				<td><%=pcl.getPName()%></td>
				<td><%=pcl.getCost()%></td>
				<td><%=pcl.getDiscount10()%></td>
				<td><%=pcl.getDiscount15()%></td>
			</tr>
			<%
			}
			%>


		</tbody>
	</table>
	<a href="index.jsp">홈으로 </a><br>
</body>
</html>