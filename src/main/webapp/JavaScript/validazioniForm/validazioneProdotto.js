//per l'inserimento e la modifica del prodotto

function validateP() {

    const nome = document.prodotto.nomeProdotto.value;
    const nome_reg_exp = /^[A-z0-9' ]{3,30}$/;

    const p = document.prodotto.prezzoProdotto.value;

    const prezzo = parseFloat(p);

    const descrizione = document.prodotto.descrizione.value;
    const descrizione_reg_exp = /^[A-z0-9',\. ]{3,200}$/;

    if (!nome_reg_exp.test(nome) || (nome == "") || (nome == "undefined")) {
        alert("Inserire un nome corretto.");
        return false;
    }

    if ((isNaN(prezzo)) || (prezzo < 0) || (prezzo == "undefined")) {
        alert("Inserire un prezzo corretto.");
        return false;
    }

    if (!descrizione_reg_exp.test(descrizione) || (descrizione == "") || (descrizione == "undefined")) {
        alert("Inserire una descrizione corretta.");
        return false;
    }
}