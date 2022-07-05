$(document).ready(function (){

    $("#domicilio").click(function () {

        $("#indirizzo").css("display","inline");
        const x = $('#totale').text();
        var totale = parseFloat(x);

        if(totale <= 20){
            $("#spedizione").text("3.00");
            $("#totale").text(totale + 3);
        }
    })

    $("#asporto, #cp").click(function () {

        $("#indirizzo").css("display","none");

        if($("#spedizione").text() == "3.00"){
            $("#spedizione").text("0.00");
            const x = $('#totale').text();
            var totale = parseFloat(x);
            $("#totale").text(totale - 3);
        }

    })


    $("#carta").click(function () {
        $("#numeroCarta").css("display","inline");
    })

    $("#contanti, #paypal").click(function () {
        $("#numeroCarta").css("display","none");
    })



});