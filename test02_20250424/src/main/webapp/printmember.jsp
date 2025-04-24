<%@page import="java.util.List"%>
<%@page import="vo.Member"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Member member = new Member();
MemberDao memberdao = new MemberDao();
List<Member> mList = (List<Member>) request.getAttribute("memberAll");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록 조회/수정</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>도시코드</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Member m : mList) {
			%>
			<tr>
				<td><%=m.getCustNo()%></td>
				<td>
					<a href="changeinfo.jsp?custNo=<%=m.getCustNo()%>
					&&custName=<%=m.getCustName()%>
					&&phone=<%=m.getPhone()%>
					&&address=<%=m.getAddress()%>
					&&joinDate=<%=m.getJoinDate()%>
					&&grade=<%=m.getGrade()%>
					&&city=<%=m.getCity()%>">
						<%=m.getCustName()%>
					</a>
				</td>
				<td><%=m.getPhone()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=m.getJoinDate()%></td>
				<td><%=m.getGrade()%></td>
				<td><%=m.getCity()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="index.jsp">홈으로</a>
</body>
</html>