function validateM(){
    const nome = document.modifica.nome.value;
    const nome_reg_exp = /^[A-z]{3,30}$/;

    const cognome = document.modifica.cognome.value;
    const cognome_reg_exp = /^[A-z]{3,30}$/;

    const passwordOld = document.modifica.pswdOld.value;

    const password = document.modifica.pswd.value;
    const password2 = document.modifica.pswrepeat.value;

    const password_reg_exp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,20})$/;


    if (!nome_reg_exp.test(nome) || (nome == "") || (nome == "undefined")) {
        alert("Inserire un nome corretto.");
        return false;

    }

    if(!cognome_reg_exp.test(cognome) || (cognome == "") || (cognome == "undefined")){
        alert("Inserire un cognome corretto.");
        return false;
    }

   if(password_reg_exp.test(passwordOld)){

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

   }else{
       alert("Inserire password corretta.");
       return false;
   }

}
