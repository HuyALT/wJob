var frm = document.getElementById("change-pass").onsubmit = function(event) {
	let password = document.getElementsByName("new-pass")[0];
	let confirm_password = document.getElementsByName("confirm-pass")[0];
	let error = document.getElementById("error-text");
	
	if (password.value !== confirm_password.value) {
		error.style.display = "block"
		event.preventDefault()
	}
	else {
		error.style.display = "none"
	}
}
var e = document.getElementById("error-old-pass");
function hidden_message() {
	e.textContent = '';
}
function alert_changepass() {
	alert("Đổi mật khẩu thành công")
}