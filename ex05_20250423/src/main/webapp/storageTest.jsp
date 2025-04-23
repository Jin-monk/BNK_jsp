<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// jsp에서 제공하는 내장객체 
  		// 이 페이지 내에서만 유효한 저장소.
    	pageContext.setAttribute("x","page_X");
    	// + 다른 페이지로 복사가 가능함.
    	request.setAttribute("x", "request_X");
    	// + 페이지에 국한되는 것이 아닌 브라우저(사용자)에 귀속됨. 해당 세션의 접속자한테만 개인의 저장소
    	session.setAttribute("x", "session_X");
    	// + 프로젝트(서비스)를 이용하는 모든 이용자가 이용할 수 있는 저장소.
    	application.setAttribute("x","application_X");
    	
    	String s= "Hello";
    	pageContext.setAttribute("s",s);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	page 저장소 값: <%= pageContext.getAttribute("x") %><br>
	request 저장소 값: <%= request.getAttribute("x") %><br>
	session 저장소 값: <%= session.getAttribute("x") %><br>
	application 저장소 값: <%= application.getAttribute("x") %>
	<hr>
	<!--http는 비연결성이여서 기억을 하지 않는다. -->
	<!-- EL 표기법 : ${ 1}  -->
	<!-- 4대 저장소에 있는 값을 읽을 때 사용한다.   -->
	<%-- page 저장소 값: ${x }<br>
	request 저장소 값: ${x }<br>
	session 저장소 값: ${x }<br><!--session은 기억을 한다. 특수한성격, 서버를 중단하고 재시작하여야 반영됨.   -->
	application 저장소 값: ${x } --%>
	
	<hr>
	page 저장소 값: ${pageScope.x }<br>
	request 저장소 값: ${requestScope.x }<br>
	session 저장소 값: ${sessionScope.x }<br>
	application 저장소 값: ${applicationScope.x }
	
	<hr>
	s(EL) : ${s }<br>
	s(표현식) : <%=s %>
	
	<hr>
	파라미터 y : ${param.y }<br>
</body>
</html>