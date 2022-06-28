function validazioneEmail () {

    // var x = document.getElementById("email");
    // x.value = x.value.toUpperCase();

    const value = event.target.value;
    console.log(value);

    $.get('CheckRegistrazioneServlet', {"emailValue" : value},
        function (resp){
            if(resp.registered){
                const div = $("#email").parent();
                const small = div.children('small');
                //console.log(small);
                div.addClass('error');
                small.text('Utente già registrato');
            }else{
                const div = $("#email").parent();
                const small = div.children('small');
                //console.log(small);
                div.removeClass('error');
            }
        }
    ).fail(function () {
        console.log('errore');
    });
};