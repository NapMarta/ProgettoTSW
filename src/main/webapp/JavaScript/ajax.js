$(document).ready(function(){

    $("#email").blur(function(event) { //Si attiva quando l’elemento HTML perde il focus

        const value = event.target.value;
        //console.log(value);

        $.get('CheckRegistrazioneServlet', {"emailValue" : value},
            function (response){
                //nell if non va nell'else, ma direttamente in fail
                if(response.registered){
                    const div = $("#email").parent();
                    const small = div.children('.small');
                    //console.log(small.text());
                    div.addClass('error');
                    small.text('Utente già registrato');
                }
                // else{
                //     const div = $("#email").parent();
                //     const small = div.children('.small');
                //     console.log(small.text());
                //     div.removeClass('error');
                //     small.text('');
                // }
            })
            .fail(function() {
                const div = $("#email").parent();
                const small = div.children('.small');
                //console.log(small.text());
                small.text('');
                //console.log('errore');
            });
    });
});
