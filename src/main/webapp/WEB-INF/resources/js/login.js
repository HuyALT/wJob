var x = document.getElementById("login");
var y = document.getElementById("register");
var z = document.getElementById("btn");

var error = document.getElementById("error-username");

function register() {
	x.style.left = "-400px";
	y.style.left = "50px";
	z.style.left = "110px";
}

function login() {
	x.style.left = "50px";
	y.style.left = "450px";
	z.style.left = "0";
}

function ready_load() {
	if (error.textContent.length > 0) {
		register();
	}
}