var  inputdate = document.getElementById("datepost");

var datenow = new Date();

var day = datenow.getDate();

var month = datenow.getMonth()+1;


var year = datenow.getFullYear();

var validate;

if (month<10) {
	validate = year +"-0"+month+"-"+day
}

inputdate.min = validate.toString();

var sdt = document.getElementsByName("sdt")[0];
sdt.addEventListener("keypress",function(event) {
	if (event.charCode < 48 || event.charCode >57) {
		event.preventDefault();
	}
})