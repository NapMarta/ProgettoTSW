function showCarrello(){
    var x = document.getElementById("carrello");
    var body = document.body;
    if(x.style.display === "none"){
        x.style.display = "block";
        x.style.zIndex = "2";
        body.classList.add("home");
    }else{
        x.style.display = "none";
        body.classList.remove("home");
    }
}

function openNav() {
    document.getElementById("mySidebar").style.width = "250px";
    document.getElementById("notification").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidebar").style.width = "0";
    document.getElementById("notification").style.marginLeft= "0";
}