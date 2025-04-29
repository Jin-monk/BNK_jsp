<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	text-align: center;
}

.cardimg {
	height: 100px;
	width: 100px;
	border: 2px solid black;
}

#vs {
	font-size: 20px;
	font-weight: bold;
	margin: 0 20px;
}

#button {
	margin: 0 20px;
}

#vsResult {
	margin-right: 140px;
}

#result {
	font-size: 20px;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>가위바위보</h1>


	<button onclick="play(1)">가위</button>
	<button onclick="play(2)" id="button">바위</button>
	<button onclick="play(3)">보</button>

	<hr>


	<p id="result">결과</p>

	<img src="" id="myImg" width="100" class="cardimg">
	<span id="vs">VS</span>
	<img src="" id="comImg" width="100" class="cardimg">
	<br>
	<span id="vsResult">ME</span>COM

	<p>전적</p>
	<p id="record">?</p>

	<script>
		let total = 0;
		let win = 0;
		let lose = 0;
		let draw = 0;
		const lastResult = document.getElementById("result");
		let myChoice;
		function play(myChoice) {

			const computerChoice = Math.floor(Math.random() * 3) + 1;

			console.log(computerChoice);

			if (myChoice === computerChoice) {
				result = '비겼습니다.';
				draw++;
			} else if ((myChoice === 1 && computerChoice === 3)
					|| (myChoice === 2 && computerChoice === 1)
					|| (myChoice === 3 && computerChoice === 2)) {
				result = '이겼습니다! ';
				win++;
			} else if ((myChoice === 1 && computerChoice === 2)
					|| (myChoice === 2 && computerChoice === 3)
					|| (myChoice === 3 && computerChoice === 1)) {
				result = '졌습니다.';
				lose++;
			}
			total++;

			console.log(myChoice);
			console.log(computerChoice);
			console.log(result);

			lastResult.innerText = `${result}`;
			//승리
			if (myChoice === 1 && computerChoice === 3) {
				document.getElementById("myImg").src = "images/가위.png"
				document.getElementById("comImg").src = "images/보.png"

			} else if (myChoice === 2 && computerChoice === 1) {
				document.getElementById("myImg").src = "images/바위.png"
				document.getElementById("comImg").src = "images/가위.png"

			} else if (myChoice === 3 && computerChoice === 2) {
				document.getElementById("myImg").src = "images/보.png"
				document.getElementById("comImg").src = "images/바위.png"

			}
			//패배
			else if (myChoice === 1 && computerChoice === 2) {
				document.getElementById("myImg").src = "images/가위.png"
				document.getElementById("comImg").src = "images/바위.png"

			} else if (myChoice === 2 && computerChoice === 3) {
				document.getElementById("myImg").src = "images/바위.png"
				document.getElementById("comImg").src = "images/보.png"

			} else if (myChoice === 3 && computerChoice === 1) {
				document.getElementById("myImg").src = "images/보.png"
				document.getElementById("comImg").src = "images/가위.png"

			}
			//무승부
			else if (myChoice === 1 && computerChoice === 1) {
				document.getElementById("myImg").src = "images/가위.png"
				document.getElementById("comImg").src = "images/가위.png"

			} else if (myChoice === 2 && computerChoice === 2) {
				document.getElementById("myImg").src = "images/바위.png"
				document.getElementById("comImg").src = "images/바위.png"

			} else if (myChoice === 3 && computerChoice === 3) {
				document.getElementById("myImg").src = "images/보.png"
				document.getElementById("comImg").src = "images/보.png"

			}
			document.getElementById("record").innerText = `\${total}전 \${win}승 \${draw}무 \${lose}패`;
		}
	</script>
</body>
</html>