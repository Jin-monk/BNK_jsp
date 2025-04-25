<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String loginCheck = request.getParameter("loginCheck");
	
	if(loginCheck.equals("user")){
%>	
		<!-- action 태그는 자바가 아닌 뷰에 들어가야 하는것이라 스트릿프립을 끊어서 사용함. -->
		<jsp:forward page="userMain.jsp">
		<jsp:param name="userName" value="홍길동" />
		</jsp:forward>

<%	
	}else{
%>
		<jsp:forward page="managerMain.jsp">
		<jsp:param name="userName" value="관리자" />
		</jsp:forward>

<%
	}
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