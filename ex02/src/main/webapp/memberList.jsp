<%@page import="ex02.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	// getAttribute 사용하여 데이터를 get하여 받음.
    	// 타입이 Object 타입이기 때문에 형변환을 함.
    	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
    
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberList Page</h1>
	<hr>
	<table border="1">
		<thead>
		</thead>
		<tbody>
		<!-- 반복시작 -->
		<%
			for(MemberVO m : list){
		%>
			<tr>
				<%-- <td><%=m.getId() %></td>
				<td><%=m.getPw() %></td>
				<td><%=m.getName() %></td>
				<td><%=m.getTel() %></td> --%>
			</tr>
		<%
			}
		%>
				
	
		</tbody>
	</table>
	
	
</body>
</html>