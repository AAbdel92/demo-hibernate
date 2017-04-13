$(document).ready(function($) {
	
	 $('#loginForm').submit(function (event) {
	        event.preventDefault();
	        var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
	        $.ajax({
	            data: data,
	            timeout: 1000,
	            type: 'POST',
	            url: '/login'
	 
	        }).done(function(data, textStatus, jqXHR) { 
	        	
//	        	window.location = "/index.html";
	        	$('#loginForm').toggleClass('hidden');
	        	$('#logout').toggleClass('show');
	        	afficherListe();
	 
	        }).fail(function(jqXHR, textStatus, errorThrown) {
	            alert('Booh! Wrong credentials, try again!');
	        });
	    }),
	
	afficherListe(),
		
	$('#logout').click(function() {
		$.ajax({
			type: 'GET',
			url: '/logout'
		}).done(function () {
//			window.location = '/login.html';
			$('#loginForm').toggleClass('show');
			$('#logout').toggleClass('hidden');
		}).fail(function () {
			window.location = 'index.html';
		});
	})	
})

function afficherListe() {
	$.ajax({
        type: 'GET',
        url: '/api/utilisateur/listeUtilisateur'
 
    }).done(function (data, textStatus, jqXHR) {
        $('#reponse').html(JSON.stringify(data));
 
    }).fail(function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
//            var preLoginInfo = JSON.stringify({method: 'GET', url: '/'});
//            $.cookie('restsecurity.pre.login.request', preLoginInfo);
            $('#reponse').html('veuillez vous identifier !');
 
        } else {
            alert('Houston, we have a problem...');
        }
    });
}