function checkPasswordMatch() {
    const password = $("#pswd").val();
    const confirmPassword = $("#psw-repeat").val();
    if (password != confirmPassword){
        $("#CheckPasswordMatch").text('Passwords does not match!');
        $("#CheckPasswordMatch").css({"font-size": "10px","color": "red"});
    }

    else{
        $("#CheckPasswordMatch").text('Passwords match.');
        $("#CheckPasswordMatch").css({"font-size": "10px","color": "green"});
    }
}

$(document).ready(function () {
    $("#psw-repeat").keyup(checkPasswordMatch);
    $("#pswd").keyup(checkPasswordMatch);
});

