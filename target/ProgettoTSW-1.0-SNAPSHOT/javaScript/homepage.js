window.onscroll = function() {myFunction()};

var navbarUP = document.getElementById("navbarUP");
var sticky = navbarUP.offsetTop;

function myFunction() {
    if (window.pageYOffset >= sticky) {
        navbarUP.classList.add("sticky")
    } else {
        navbarUP.classList.remove("sticky");
    }
}