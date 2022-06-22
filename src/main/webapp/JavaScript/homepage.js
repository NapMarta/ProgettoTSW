function show(id) {
    let pizza = document.getElementById("pizza");
    let panino = document.getElementById("panino");
    let fritto = document.getElementById("fritto");
    let bibita = document.getElementById("bibita");
    let dolce = document.getElementById("dolce");

    switch (id){
        case "pizza":
            pizza.classList.add("active");
            panino.classList.remove("active");
            fritto.classList.remove("active");
            bibita.classList.remove("active");
            dolce.classList.remove("active");
            break;

        case "panino":
            panino.classList.add("active");
            pizza.classList.remove("active");
            fritto.classList.remove("active");
            bibita.classList.remove("active");
            dolce.classList.remove("active");
            break;

        case "fritto":
            fritto.classList.add("active");
            panino.classList.remove("active");
            pizza.classList.remove("active");
            bibita.classList.remove("active");
            dolce.classList.remove("active");
            break;

        case "bibita":
            bibita.classList.add("active");
            panino.classList.remove("active");
            fritto.classList.remove("active");
            pizza.classList.remove("active");
            dolce.classList.remove("active");
            break;

        case "dolce":
            dolce.classList.add("active");
            panino.classList.remove("active");
            fritto.classList.remove("active");
            bibita.classList.remove("active");
            pizza.classList.remove("active");
            break;


    }

}