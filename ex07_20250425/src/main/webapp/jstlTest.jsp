<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test</title>
</head>
<body>
	<h1>EL & JSTL</h1>
	<hr>
	<c:set var="msg" value="Hello" scope="session"/>
	<c:set var="msg" value="Hello" scope="page"/>
	<p>msg : ${msg }</p>
	
	<c:set var="age" scope="page">
		30
	</c:set>
	<p>age : ${age }</p>
	
	<a href="jstlTest2.jsp">jstlTest2 페이지로 가기</a>
	<hr>
	
	<c:set var="man" value="<%= new vo.Man() %>"/>
	<c:set target="${man }" property="name" value="James"/>
	<c:set target="${man }" property="age" value="33"/>
	<c:set target="${man }" property="job" value="학생"/>
	
	man 정보 : ${man }<br>
	
	<c:remove var="msg" scope="page"/>
	msg 정보 : (page): ${pageScope.msg }<br>
	msg 정보 : (session): ${sessionScope.msg }<br>
	
	<hr>
	
	<form action="jstlTest2.jsp">
		<label for="color">색상을 선택하세요.</label>
		<select id="color" name="color">
			<option value="1">빨강</option> 
			<option value="2">초록</option> 
			<option value="3">파랑</option> 
		</select>
		<input type="submit" value="전송">
	</form>
	<hr>
	
	<form action="jstlTest2.jsp">
		<label for="fruit">과일을 선택하세요.</label>
		<select name="fruit" id="fruit">
			<option value="1">사과</option>
			<option value="2">복숭아</option>
			<option value="3">포도</option>
		</select>
		<input type="submit" value="전송">
	</form>
	<hr>
	
	
	<c:forEach var="cnt" begin="1" end="10" step="1" varStatus="status">
		${cnt } <c:if test="${not status.last }">,</c:if>
	</c:forEach>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>index</th>
				<th>count</th>
				<th>cnt</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cnt" begin="1" end="14" step="2" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td>${status.count }</td>
					<td>${cnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	
	<c:forTokens var="city" items="서울,대전,대구,부산" delims=",">
		${city }<br>
	</c:forTokens>
	<br>
	<c:forTokens var="city" items="서울.대전,대구.부산" delims=".,">
		${city }<br>
	</c:forTokens>
	<hr>
	<%-- <c:import url="http://localhost:8090/ex07_20250425/header.jsp" var="data">
	${data }
	</c:import> --%>
	<c:url value="images/dog2.jpg" var="img" />
	<h3>${img }</h3>
	<img src="${img }" width="150" height="150" >
	<hr>
	<c:set var="n" value="30" scope="page" />
	숫자 : <c:out value="${n }" />
	숫자2 : ${n }
	
	<hr>
	
	<c:catch var="errmsg">
		예외발생 전 <br>
		<%=1/0 %>
		예외발생 후 <br>
	</c:catch>
	<c:out value="${errmsg }" />
	
</body>
</html>