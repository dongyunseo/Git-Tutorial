<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>SignUp</title>
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/signupPage.css">
<link rel="stylesheet" href="../css/footer.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function idCheck() {
		var id = $('.id').val();
		$.ajax({
			type : 'POST',
			url : '../UserRegisterCheckServlet',
			data : {id : id},
			success : function(result) {
				if (result == -1) {
					alert("아이디 생성이 가능합니다.")
					$(".signupbtn").prop("disabled", false);
					$(".signupbtn").css("background-color","#19c4197e");
					$('.id').css('background-color', '#19c4197e');
				} else {
					alert("중복된 아이디 입니다.");
					$(".signupbtn").prop("disabled", true);
	                $(".signupbtn").css("background-color", "#aaaaaa");
					$('.id').css('background-color', '#FFCECE');
				}
			}
		})
	}
</script>
</head>

<body>
	<div id="top">
		<div id="header">
			<jsp:include page="../section/detail_header.jsp" />
		</div>
		<div class="container">
			<h5>
				<span>회원 가입</span> 페이지입니다.
			</h5>
			<hr />
			<br />
			<form method="post" name="registerform" action="signupNew.so"
				onsubmit="return signUp_Check()" style="text-align: center;">
				<input type="text" placeholder="아이디" name="id" required id="join_text_box" class="id"> 
				<br />
				<br /> 
				<input type="button" class="validateIdSubmit" name="validateIdSubmit" onclick="idCheck()" value="중복확인"> 
				<input type="hidden"name="id_Check" value="idUncheck"> 
				<br /> 
				<br /> 
				<inputtype="password" placeholder="비밀번호" name="pwd" required id="join_text_box" /> 
				<br /> 
				<br /> 
				<input type="text" placeholder="이 름" name="name" required id="join_text_box" /> 
				<br />
				<br /> 
				<input type="email" placeholder="이 메 일" name="email" required id="join_text_box" /> 
				<br /> 
				<br /> 
				<input type="text" placeholder="지 번" name="zip_num" required id="join_text_box" /> 
				<br />
				<br /> 
				<input type="text" placeholder="주 소" name="address" required id="join_text_box" /> 
				<br /> 
				<br /> 
				<input type="text" placeholder="전화 번호" name="phone" required id="join_text_box" /> 
				<br />
				<br />
				<p>
					<input type="submit" value="가입하기" id="signup1" class="signupbtn"
						disabled="disabled" /><br /> <br />
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