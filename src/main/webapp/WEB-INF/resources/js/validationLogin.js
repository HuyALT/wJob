var frm = document.getElementById("register").onsubmit = function(event) {
	let password = document.getElementsByName("password-reg")[0];
	let confirm_password = document.getElementsByName("confirmpassword")[0];
	let error = document.getElementById("error-text");
	
	if (password.value !== confirm_password.value) {
		error.style.display = "block"
		event.preventDefault()
	}
	else {
		error.style.display = "none"
	}
}