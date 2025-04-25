<%@page import="vo.OrderList"%>
<%@page import="java.util.List"%>
<%@page import="dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//주문 목록 홈페이지 , dao에서 받아와서 html 출력
    	OrderDao orderdao = new OrderDao();
  		List<OrderList> orderList = orderdao.selectAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="index.jsp" %>
	<h1>주문목록</h1>
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>할인점코드</th>			
				<th>점포명</th>			
				<th>주문번호</th>			
				<th>주문일자</th>			
				<th>제품코드</th>			
				<th>제품명</th>			
				<th>주문수량</th>			
				<th>단가</th>			
				<th>소비자가격</th>			
				<th>할인가격</th>			
			</tr>
		</thead>
		<tbody>
			<%
				for(OrderList ol : orderList){
			%>
			<tr>
				<td><%=ol.getShopNo() %></td>
				<td><%=ol.getShopName() %></td>
				<td><%=ol.getOrderNo() %></td>
				<td><%=ol.getOrderDate() %></td>
				<td><%=ol.getPCode() %></td>
				<td><%=ol.getPName() %></td>
				<td><%=ol.getAmount() %></td>
				<td><%=ol.getCost() %></td>
				<td><%=ol.getCustPrice() %></td>
				<td><%=ol.getDisPrice() %></td>
			</tr>
			<%
				}
			%>
			
		
		</tbody>
	</table>
	<a href="index.jsp">홈으로 </a><br>
</body>
</html>