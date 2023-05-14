var ho = document.getElementsByName("ho")[0];
ho.addEventListener("keypress",function(event) {
	let pattern = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~1234567890]/
	if (pattern.test(event.key)) {
		event.preventDefault();
	}
})

var ten = document.getElementsByName("ten")[0];
ten.addEventListener("keypress",function(event) {
	let pattern = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~1234567890]/
	if (pattern.test(event.key)) {
		event.preventDefault();
	}
})

var sdt = document.getElementsByName("sdt")[0];
sdt.addEventListener("keypress",function(event) {
	if (event.charCode < 48 || event.charCode >57) {
		event.preventDefault();
	}
})

var cmnd = document.getElementsByName("cmnd")[0];
cmnd.addEventListener("keypress",function(event) {
	if (event.charCode < 48 || event.charCode >57) {
		event.preventDefault();
	}
})

