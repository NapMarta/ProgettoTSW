function validateO(){

    const data = document.getElementById("data").innerText;
    const data_reg_exp= /^\d{4}-\d{2}-\d{2}$/;

    const tipologia = document.ordine.tipologia.value;

    const tipoPagamento = document.ordine.tipoPagamento.value;

    const numCarta = document.ordine.numeroCarta.value;
    const num_carta_credito_reg_exp=/^\d{16}$/;

    const cap = document.ordine.cap.value;
    const cap_reg_exp=/^\d{5}$/;

    const indirizzo = document.ordine.via.value;
    const indirizzo_reg_exp=/^[A-z0-9',\. ]{3,30}, [A-z0-9,\. ]{2,3}$/;

    const citta = document.ordine.citta.value;
    const citta_reg_exp=/^[A-z' ]{3,20}$/;

    const t = document.getElementById("totale").innerText;
    const totale = parseFloat(t);

    if (!data_reg_exp.test(data) || (data == "") || (data == "undefined")) {
        alert("Inserire una data corretta.");
        return false;

    }

    if(tipologia === 'D'){
        if (!indirizzo_reg_exp.test(indirizzo) || (indirizzo == "") || (indirizzo == "undefined")) {
            alert("Inserire un indirizzo corretto.");
            return false;
        }
        if (!citta_reg_exp.test(citta) || (citta == "") || (citta == "undefined")) {
            alert("Inserire una città corretta.");
            return false;
        }
        if (!cap_reg_exp.test(cap) || (cap == "") || (cap == "undefined")) {
            alert("Inserire un cap corretto.");
            return false;
        }

    }

    if(tipoPagamento === 'Carta di credito'){
        if(!num_carta_credito_reg_exp.test(numCarta) || (numCarta == "") || (numCarta == "undefined")) {
            alert("Inserire un numero di carta corretto.");
            return false;
        }
    }

    if ((isNaN(totale)) || (totale <= 0) || (t == "undefined")) {
        alert("Inserire almeno un prodotto nel carrello.");
        return false;
    }

}
