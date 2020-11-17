function loginCheck() {
	if (document.frm.customerid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.customerid.focus();
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
	if (document.frm.customerid.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.formm.customerid.focus();
		return;
	}
	var url = "idCheck.mo?customerid=" + document.frm.customerid.value;
	window
			.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function idok(customerid) {
	opener.frm.customerid.value = document.frm.customerid.value;  
	opener.frm.reid.value = document.frm.customerid.value;
	self.close();
}

function joinCheck() {
	if (document.frm.customername.value.length == 0) {
		alert("이름을 써주세요.");
		frm.customername.focus();
		return false;
	}
	if (document.frm.customerid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.customerid.focus();
		return false;
	}
	if (document.frm.customerid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.customerid.focus();
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
		frm.customerid.focus();
		return false;
	}
	return true;
}