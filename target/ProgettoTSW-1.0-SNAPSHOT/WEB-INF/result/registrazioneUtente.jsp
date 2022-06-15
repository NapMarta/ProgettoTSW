<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione Utente</title>
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
    <div class="parent">
        <form action="" class="child">
            <p class="titolo">Registrazione Utente</p>
            <hr>
            <table>
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
                    <td>
                        <label for="email">Email</label><br>
                        <input type="email" placeholder="Inserisci Email" name="email" id="email" required>
                    </td>
                    <td>
                        <label for="psw">Password</label><br>
                        <input type="password" placeholder="Inserisci Password" name="psw" id="psw" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="psw-repeat">Ripetere Password</label><br>
                        <input type="password" placeholder="Ripetere Password" name="psw-repeat" id="psw-repeat" required>
                    </td>

                </tr>
            </table>
            <input type="submit" id="accedi" value="Registrati ora">
        </form>
        <br>
        <form action="RegistrazioneServlet" class="child1">
            <p class="testo">Hai già un account?<input type="submit" id="registrati" name="login" value="Login"></p>
        </form>


    </div>

</body>
</html>