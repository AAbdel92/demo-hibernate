jQuery(document).ready(function($) {
    $.ajax({
        type: 'GET',
        url: '/api/utilisateur/listeUtilisateur'
 
    }).done(function (data, textStatus, jqXHR) {
        $('#reponse').html(data.message);
 
    }).fail(function (jqXHR, textStatus, errorThrown) {
        if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
            var preLoginInfo = JSON.stringify({method: 'GET', url: '/'});
            $.cookie('restsecurity.pre.login.request', preLoginInfo);
            window.location = '/login.html';
 
        } else {
            alert('Houston, we have a problem...');
        }
    });
});