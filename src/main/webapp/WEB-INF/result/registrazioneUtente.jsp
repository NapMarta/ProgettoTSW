<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione Utente</title>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <link href="css/registrazione.css" rel="stylesheet">
    <script type="text/javascript" src="JavaScript/registrazione.js"></script>
</head>
<body>

<span class="parent">
            <p class="titolo">Registrazione Utente</p>
            <hr>
            <table>
                <form action="RegistrazioneServlet" class="child">

                <tr>
                    <td>
                        <label for="nome">Nome</label><br>
                        <input type="text" placeholder="Inserisci Nome" name="nome" id="nome" required>
                    </td>
                    <td>
                        <label for="cognome">Cognome</label><br>
                        <input type="text" placeholder="Inserisci Cognome" name="nome" id="cognome" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">Email</label><br>
                        <input type="email" placeholder="Inserisci Email" name="email" id="email" required>
                    </td>
                    <td>
                        <label for="psw">Password<br></label>
                        <span class="visible">
                            <input type="password" placeholder="Inserisci Password" name="psw" id="psw" required>
                            <input type="checkbox"  class="btn" onclick="visible('psw', 'psw-linea');">
                                <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                                <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-linea"/>
                            </input>
                        </span>

                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="psw-repeat">Ripetere Password<br></label>
                        <span class="visible">
                            <input type="password" placeholder="Ripetere Password" name="psw-repeat" id="psw-repeat" required>
                            <input type="checkbox" class="btn" onclick="visible('psw-repeat', 'psw-repeat-linea');">
                                <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                                <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-repeat-linea"/>
                            </input>
                        </span>
                    </td>
                    <td></td>
                <tr>
                    <td>
                        <input type="submit" id="accedi" value="Registrati ora">
                    </td>
                </tr>
                </form>
            </table>
                <form action="RegistrazioneServlet" class="child1">
                    <p class="testo">Hai già un account?<input type="submit" id="registrati" name="login" value="Login"></p>
                </form>
    </span>

<%--    <div id="message">--%>
<%--        <h3>Password must contain the following:</h3>--%>
<%--        <p id="letter" class="invalid">A <b>lowercase</b> letter</p>--%>
<%--        <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>--%>
<%--        <p id="number" class="invalid">A <b>number</b></p>--%>
<%--        <p id="length" class="invalid">Minimum <b>8 characters</b></p>--%>
<%--    </div>--%>

</body>
</html>