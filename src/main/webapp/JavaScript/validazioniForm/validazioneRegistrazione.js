function validateR(){

    const email_reg_exp = /^[A-z0-9\.\+-]+@[A-z0-9\.-]+\.[A-z]{2,6}$/;
    const email = document.registrazione.email.value;

    const password = document.registrazione.pswd.value;

    const password_reg_exp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([@_\.,!?#]*)(([a-zA-Z0-9]([@_\.,!?#]*)){8,20})$/;
    const password2 = document.registrazione.pswrepeat.value;

    const nome = document.registrazione.nome.value;
    const nome_reg_exp = /^[A-z ]{3,30}$/;

    const cognome = document.registrazione.cognome.value;
    const cognome_reg_exp = /^[A-z ]{3,30}$/;


    if (!nome_reg_exp.test(nome) || (nome == "") || (nome == "undefined")) {
        alert("Inserire un nome corretto.");
        return false;

    }
    if(!cognome_reg_exp.test(cognome) || (cognome == "") || (cognome == "undefined")){
        alert("Inserire un cognome corretto.");
        return false;
    }

    if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
        alert("Inserire un indirizzo email corretto.");
        return false;

    }

    if(password_reg_exp.test(password)){
        if(password_reg_exp.test(password2)){
            if(password == password2){

            }else{
                alert("Password non corrispondono");
                return false;
            }
        }
        else{
            alert("Inserire password2 corretta.");
            return false;
        }

    }
    else{
        alert("Inserire password1 corretta.");
        return false;
    }

}

