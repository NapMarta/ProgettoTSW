function checkPasswordMatch() {
    const password = $("#pswd").val();
    const confirmPassword = $("#psw-repeat").val();
    if (password != confirmPassword){
        $("#CheckPasswordMatch").text('Password non corrispondono!');
        $("#CheckPasswordMatch").css({"font-size": "10px","color": "red"});
    }

    else{
        $("#CheckPasswordMatch").text('Password corrispondono.');
        $("#CheckPasswordMatch").css({"font-size": "12px","color": "green"});
    }
}

$(document).ready(function () {
    $("#psw-repeat").keyup(checkPasswordMatch);
    $("#pswd").keyup(checkPasswordMatch);
});

