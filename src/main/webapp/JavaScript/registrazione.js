function visible(id, linea) {
    let x = document.getElementById(id);
    let y = document.getElementById(linea);
    if (x.type === "password") {

        x.classList.add("active");
        x.type = "text";
        y.style.visibility = "hidden";

    } else {
        x.type = "password";
        y.style.visibility = "visible";
        x.classList.remove("active");
    }
}
