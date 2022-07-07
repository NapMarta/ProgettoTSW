<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione Utente</title>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <link href="css/registrazione.css" rel="stylesheet">
    <script type="text/javascript" src="JavaScript/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="JavaScript/registrazione.js"></script>
    <script type="text/javascript" src="JavaScript/ajax.js"></script>
    <script type="text/javascript" src="JavaScript/ajaxPsw.js"></script>
    <script type="text/javascript" src="JavaScript/validazionePsw.js"></script>
    <script type="text/javascript" src="JavaScript/validazioniForm/validazioneRegistrazione.js"></script>
</head>
<body>

<span class="parent" id="container">
    <p class="titolo">Registrazione Utente</p>
    <hr>
    <table>
        <form action="Registrazione" class="child" method="post" name="registrazione" onsubmit="return validateR();">
            <tr>
                <td>
                    <label for="nome">Nome</label><br>
                    <input type="text" placeholder="Inserisci Nome" name="nome" id="nome" required>
                </td>
                <td>
                    <label for="cognome">Cognome</label><br>
                    <input type="text" placeholder="Inserisci Cognome" name="cognome" id="cognome" required>
                </td>
            </tr>
            <tr>
                <td><br>
                    <label for="email" class="email">Email</label><br>
                    <input type="email" placeholder="Inserisci Email" name="email" id="email" required>
                    <div class="small"></div>
                </td>
                <td>
                    <label for="pswd" class="tPsw">Password<br></label>
                    <span class="visible">
                        <input type="password" placeholder="Inserisci Password" name="pswd" id="pswd"
                               title=" Ammessi solo i caratteri @_\.,!?#" required>
                        <button type="button"  class="btn" onclick="visible('pswd', 'psw-linea');">
                            <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                            <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-linea"/>
                        </button>
                    </span>
                </td>
            </tr>
            <tr>
                <td><br>
                    <label for="psw-repeat" class="tPsw">Ripetere Password<br></label>
                    <span class="visible">
                        <input type="password" placeholder="Ripetere Password" name="pswrepeat" id="psw-repeat"
                               title=" Ammessi solo i caratteri @_\.,!?#" required>
                        <button type="button" class="btn" onclick="visible('psw-repeat', 'psw-repeat-linea');">
                            <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                            <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-repeat-linea"/>
                        </button>
                    </span><br><br>
                    <div id="CheckPasswordMatch"></div>
                </td>
                <td>
                    <div id="pswd_info">
                        <h4>Password deve avere i seguenti requisiti:</h4>
                        <ul>
                            <li id="letter" class="invalid">Una lettera <b>minuscola</b> </li>
                            <li id="capital" class="invalid">Una lettera <b>maiuscola</b></li>
                            <li id="number" class="invalid">Un <b>numero</b></li>
                            <li id="length" class="invalid">Minimo <b>8 caratteri</b></li>
                        </ul>
                    </div>
                </td>
            <tr>
                <td>
                    <input type="submit" name="registrazione" id="registrati" value="Registrati ora">
                </td>
            </tr>
        </form>
    </table>

    <form action="Registrazione" class="child1">
        <button type="submit" value="Home" name="home" id="home">
            <img src="https://img.icons8.com/material-rounded/30/000000/home.png"/>
        </button>
        <p class="testo">Hai già un account?<input type="submit" id="accedi" name="login" value="Login"></p>
    </form>



</span>

</body>
</html>