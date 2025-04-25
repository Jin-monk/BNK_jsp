<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
	<h1>주문 등록</h1>
	<hr>
	<form action="Registration" method="POST">
		<table border="1">
			<thead>
				<tr>
					<td>주문번호</td>
					<td><input type="text" name="orderNo" required><br></td>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>주문점포</td>
					<td><select name="shopNo">
							<option>점포선택</option>
							<option value="S001">AA할인점</option>
							<option value="S002">BB할인점</option>
							<option value="S003">CC할인점</option>
							<option value="S004">DD할인점</option>
					</select></td>
				</tr>

				<tr>
					<td>주문일자</td>
					<td><input type="text" name="orderDate" required></td>
				</tr>

				<tr>
					<td>제품코드</td>
					<td><select name="pCode">
							<option>제품선택</option>
							<option value="AA01">삼각김밥</option>
							<option value="AA02">도시락</option>
							<option value="AA03">봉지만두</option>
							<option value="AA04">컵라면</option>
							<option value="AA05">아메리카노</option>
							<option value="AA06">콜라</option>
					</select></td>
				</tr>

				<tr>
					<td>주문수량</td>
					<td><input type="text" name="amount" required></td>
				</tr>

				<tr>
					<td colspan='2'><input type="submit" value="주문등록"> <input
						type="reset" value="다시쓰기"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<a href="index.jsp">홈으로 </a><br>
</body>
</html>