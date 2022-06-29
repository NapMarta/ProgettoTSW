//
//
// const myInput = document.getElementById("psw");
// const letter = document.getElementById("letter");
// const capital = document.getElementById("capital");
// const number = document.getElementById("number");
// const length = document.getElementById("length");
//
// // When the user clicks on the password field, show the message box
// myInput.onfocus = function(event) {
//     const x = document.getElementById("message");
//     x.style.display = "block";
//     console.log(myInput.value);
// }
//
// // When the user clicks outside of the password field, hide the message box
// myInput.onblur = function() {
//     document.getElementById("message").style.display = "none";
// }
//
// // When the user starts to type something inside the password field
// myInput.onkeyup = function() {
//     // Validate lowercase letters
//     var lowerCaseLetters = /[a-z]/g;
//     if(myInput.value.match(lowerCaseLetters)) {
//         letter.classList.remove("invalid");
//         letter.classList.add("valid");
//     } else {
//         letter.classList.remove("valid");
//         letter.classList.add("invalid");
//     }
//
//     // Validate capital letters
//     var upperCaseLetters = /[A-Z]/g;
//     if(myInput.value.match(upperCaseLetters)) {
//         capital.classList.remove("invalid");
//         capital.classList.add("valid");
//     } else {
//         capital.classList.remove("valid");
//         capital.classList.add("invalid");
//     }
//
//     // Validate numbers
//     var numbers = /[0-9]/g;
//     if(myInput.value.match(numbers)) {
//         number.classList.remove("invalid");
//         number.classList.add("valid");
//     } else {
//         number.classList.remove("valid");
//         number.classList.add("invalid");
//     }
//
//     // Validate length
//     if(myInput.value.length >= 8) {
//         length.classList.remove("invalid");
//         length.classList.add("valid");
//     } else {
//         length.classList.remove("valid");
//         length.classList.add("invalid");
//     }
// }

$(document).ready(function() {

    $("#pswd").keyup(function() {
        const pswd = $("#pswd").val();
        if ( pswd.length < 8 ) {
            $('#length').removeClass('valid').addClass('invalid');
        } else {
            $('#length').removeClass('invalid').addClass('valid');
        }

        if ( pswd.match(/[A-z]/) ) {
            $('#letter').removeClass('invalid').addClass('valid');
        } else {
            $('#letter').removeClass('valid').addClass('invalid');
        }

        //validate capital letter
        if ( pswd.match(/[A-Z]/) ) {
            $('#capital').removeClass('invalid').addClass('valid');
        } else {
            $('#capital').removeClass('valid').addClass('invalid');
        }

        //validate number
        if ( pswd.match(/\d/) ) {
            $('#number').removeClass('invalid').addClass('valid');
        } else {
            $('#number').removeClass('valid').addClass('invalid');
        }

    }).focus(function() {
        $('#pswd_info').show();
    }).blur(function() {
        $('#pswd_info').hide();
    });

});