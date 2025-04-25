<%@page import="vo.ShopOrderList"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// 	점포별 주문현황. dao에서 받아와서 html 출력.
OrderDao orderDao = new OrderDao();
List<ShopOrderList> sOList = orderDao.selectByShopNo();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
	<h1>점포별 주문현황 </h1>
	<hr>

	<table border="1">
		<thead>
			<tr>
				<th>할인점코드</th>
				<th>제품코드</th>
				<th>제품명</th>
				<th>주문총수량</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (ShopOrderList sol : sOList) {
			%>
			<tr>
				<td><%=sol.getSCode()%></td>
				<td><%=sol.getPCode()%></td>
				<td><%=sol.getPName()%></td>
				<td><%=sol.getAllAmount()%></td>
			</tr>
			<%
			}
			%>


		</tbody>
	</table>
	<a href="index.jsp">홈으로 </a><br>
</body>
</html>