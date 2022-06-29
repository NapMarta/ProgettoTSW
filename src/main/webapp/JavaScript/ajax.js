$(document).ready(function(){

    $("#email").blur(function(event) { //Si attiva quando l’elemento HTML perde il focus

        const value = event.target.value;
        //console.log(value);

        $.get('CheckRegistrazioneServlet', {"emailValue" : value},
            function (response){
                const div = $("#email").parent();
                const small = div.children('.small');

                if(response.registered){

                    //console.log(small.text());
                    div.addClass('error');
                    small.text('Utente già registrato');
                    small.css({"font-size": "10px","color": "red"});
                }else{
                    small.text('');
                    div.removeClass('error');
                    //console.log(small.text());
                }
            })
            .fail(function() {
                const div = $("#email").parent();
                const small = div.children('.small');
                //console.log(small.text());
                small.text('Errore. Riprova');
                small.css({"font-size": "10px","color": "red"});
                console.log('errore');
            });
    });
});
