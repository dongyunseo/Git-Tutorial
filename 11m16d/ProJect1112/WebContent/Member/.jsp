<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>SignUp</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/middle.css">
<link rel="stylesheet" href="../css/footer.css">
<script type="text/javascript">
	function loginCheck() {
		if (document.frm.customerId.value.length == 0) {
			alert("아이디를 써주세요");
			frm.customerId.focus();
			return false;
		}
		if (document.frm.customerpw.value == "") {
			alert("암호는 반드시 입력해야 합니다.");
			frm.customerpw.focus();
			return false;
		}
		return true;
	}

	function idCheck() {
		if (document.frm.customerId.value == "") {
			alert('아이디를 입력하여 주십시오.');
			document.formm.customerId.focus();
			return;
		}
		var url = "idCheck.mo?customerId=" + document.frm.customerId.value;
		window
				.open(url, "_blank_1",
						"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	}

	function idok(customerId) {
		opener.frm.customerId.value = document.frm.customerId.value;
		opener.frm.reid.value = document.frm.customerId.value;
		self.close();
	}

	function joinCheck() {
		if (document.frm.customername.value.length == 0) {
			alert("이름을 써주세요.");
			frm.customername.focus();
			return false;
		}
		if (document.frm.customerId.value.length == 0) {
			alert("아이디를 써주세요");
			frm.customerId.focus();
			return false;
		}
		if (document.frm.customerId.value.length < 4) {
			alert("아이디는 4글자이상이어야 합니다.");
			frm.customerId.focus();
			return false;
		}
		if (document.frm.customerpw.value == "") {
			alert("암호는 반드시 입력해야 합니다.");
			frm.customerpw.focus();
			return false;
		}
		if (document.frm.customerpw.value != document.frm.customerpw_check.value) {
			alert("암호가 일치하지 않습니다.");
			frm.customerpw.focus();
			return false;
		}
		if (document.frm.reid.value.length == 0) {
			alert("중복 체크를 하지 않았습니다.");
			frm.customerId.focus();
			return false;
		}
		return true;
	}
</script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
.container {
	width: 500px;
	margin: 40px auto;
	line-height: 16px;
}

h5 {
	text-align: center;
}

h5 span {
	color: teal;
}

.n {
	font-size: 13px;
}

#signup {
	background-color: rgb(255, 80, 90);
	color: white;
	border: 0;
	border-radius: 5px;
	padding: 10px 224px;
}

.bottom input {
	background-color: white;
	border: 0;
	color: teal;
	font-size: 16px;
}

i {
	color: lightgray;
}

input {
	border: 1px solid lightgray;
	border-radius: 3px;
}
</style>

</head>

<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/header.jsp" />
		</div>

		<div class="container">
			<h5>
				<span>회원 가입</span> 페이지입니다.
			</h5>
			<hr />
			<br />
			<form method="post" name="frm" action="signupNew.mo">
				<input type="text" placeholder="이름" name="customername" required
					style="height: 30px; width: 495px" /><br /> <br />
				<table>
					<tr>
						<td><input type="text" placeholder="아이디" name="customerId"
							required style="height: 30px; width: 495px;" id="customerId">
							<input type="hidden" name="reid" size="20"> <input
							type="button" value="중복 체크" onclick="idCheck()"></td>
					</tr>
				</table>
				<input type="password" placeholder="비밀번호" name="customerpw" required
					style="height: 30px; width: 495px" /><br /> <br /> <input
					type="text" placeholder="주소" name="customeradd" required
					style="height: 30px; width: 495px" /><br /> <br /> <input
					type="text" placeholder="이메일" name="cutomereamil" required
					style="height: 30px; width: 495px" /><br /> <br /> <input
					type="text" placeholder="생년월일" name="cutomerbir" required
					style="height: 30px; width: 495px" /><br /> <br /> <input
					type="text" placeholder="휴대폰 번호" name="customerphone" required
					style="height: 30px; width: 495px" /><br /> <br />

				<p>
					<input type="submit" value="가입하기" id="signup" /><br /> <br />
				</p>
			</form>
			<hr />
		</div>
		<div id="bott">
			<jsp:include page="../section/footer.jsp" />
		</div>
	</div>

</body>
</html>