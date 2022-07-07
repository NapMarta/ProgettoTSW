function validate(){

    const email_reg_exp = /^[A-z0-9\.\+-]+@[A-z0-9\.-]+\.[A-z]{2,6}$/;
    const email = document.login.email.value;

    const password = document.login.psw.value;
    const password_reg_exp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([@_\.,!?#]*)(([a-zA-Z0-9]([@_\.,!?#]*)){8,20})$/;


    if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
        alert("Inserire un indirizzo email corretto.");
        return false;

    }

    if (!password_reg_exp.test(password) || (password == "") || (password == "undefined")) {
        alert("Inserire una password corretta.");
        return false;
    }

}

