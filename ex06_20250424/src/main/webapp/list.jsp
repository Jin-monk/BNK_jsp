<%@page import="ex06_20250424.A"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%! int gn = 1; %> <!-- 정의문  - 전역을 뜻한다.-->

<%-- <%=  %> <!-- 표현식 --> --%>
<%-- 스크립플릿 안에 들어가 있는 것은 전역이 아닌 지역에 속한다. --%>
	
	
	
	<% 
		int ln = 1;
		//gn++ ;
		//ln++ ;
		
		List<A> list = new ArrayList<>();
		list.add(new A("홍길동",23));
		list.add(new A("홍길동2",24));
		list.add(new A("홍길동3",25));
		
		pageContext.setAttribute("list", list);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 주석 -->
	<%-- 주석  --%>
	gn: <%=gn++ %><br>
	ln: <%=ln++ %><br>
	<table border = "1">
		<thead>
			<tr>
				<th>no</th>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${list }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${a.name}</td>
				<td>${a.age}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>