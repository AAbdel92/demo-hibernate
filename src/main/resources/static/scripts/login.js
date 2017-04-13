$(document).ready(function() {
	
	$('#submit').click(function () {
	var requestBody = {};
	requestBody["username"] = $('#username').val();
	requestBody["password"] = $('#password').val();
		$.ajax({
			method : "POST",
			url: "http://localhost:8080/login",
			contentType : "application/json",
			withCredentials: true,
			crossDomain : true,
			dataType : 'json',
			success: function() {
				// window.location.href = "C:\Users\Simplon\git\demo-projet-front\demo-hibernate-front/index.html";
				console.log("gg");
			},
			error : function() {
				console.log("fail");
			}
		});
	});	
});
