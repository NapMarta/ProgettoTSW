<%@ page import="model.beans.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage = "/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifica Credenziali</title>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <script type="text/javascript" src="JavaScript/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="JavaScript/registrazione.js"></script>
    <script type="text/javascript" src="JavaScript/ajaxPsw.js"></script>
    <script type="text/javascript" src="JavaScript/validazionePsw.js"></script>
    <link href="css/registrazione.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="JavaScript/validazioniForm/validazioneModCredenziali.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>


<span class="parent" id="container">
    <p class="titolo">Modifica Credenziali</p>
    <hr>
    <table>
        <form action="ModificaCredenziali" name="modifica" class="child" onsubmit="return validateM();" method="post">

            <%
                Utente utente = (Utente) session.getAttribute("utente");
            %>

            <%
                boolean ris = (boolean) request.getAttribute("ris");
                if(!ris){
            %>
                <span class="error">Modifica non riuscita!!!</span>
            <%
                }
            %>

            <tr>
                <td>
                    <input type="hidden" name="codice" value="<%=utente.getId()%>">
                    <label for="nome">Nome</label><br>
                    <input type="text" name="nome" id="nome" value="<%=utente.getNome()%>" required>
                </td>
                <td>
                    <label for="cognome">Cognome</label><br>
                    <input type="text" name="cognome" id="cognome" value="<%=utente.getCognome()%>" required>
                </td>
            </tr>
            <tr>
                <td><br><br>
                    <label for="email" class="email">Email</label><br>
                    <input type="email"  name="email" id="email" value="<%=utente.getEmail()%>" readonly>
                </td>
                <td>
                    <input type="hidden" name="pswDB" id="pswDB" value="<%=utente.getPasswordUtente()%>">
                    <br>
                    <label for="pswdOld" class="psw">Password attuale<br></label>
                    <span class="visible">
                        <input type="password"name="pswdOld" id="pswdOld" placeholder="Password precedente"
                               title=" Ammessi solo i caratteri @_\.,!?#" required>
                        <button type="button"  class="btn" onclick="visible('pswdOld', 'psw-old-linea');">
                            <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                            <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-old-linea"/>
                        </button>
                    </span>
                    <div class="msg"></div>

                </td>
            </tr>
            <tr class="nuovaPsw">
                <td> <br>
                    <label for="pswd" class="psw">Nuova Password<br></label>
                    <span class="visible">
                        <input type="password"name="pswd" id="pswd" placeholder="Inserire Password"
                               title=" Ammessi solo i caratteri @_\.,!?#" required>
                        <button type="button"  class="btn" onclick="visible('pswd', 'psw-linea');">
                            <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                            <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-linea"/>
                        </button>
                    </span>
                </td>
                <td><br>
                    <label for="psw-repeat" class="psw">Ripetere Password<br></label>
                    <span class="visible">
                        <input type="password" name="pswrepeat" id="psw-repeat" placeholder="Ripetere Password"
                               title=" Ammessi solo i caratteri @_\.,!?#" required>
                        <button type="button" class="btn" onclick="visible('psw-repeat', 'psw-repeat-linea');">
                            <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                            <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-repeat-linea"/>
                        </button>
                    </span>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="pswd_infoModifica">
                        <h4>Password deve avere i seguenti requisiti:</h4>
                        <ul>
                            <li id="letter" class="invalid">Una lettera <b>minuscola</b> </li>
                            <li id="capital" class="invalid">Una lettera <b>maiuscola</b></li>
                            <li id="number" class="invalid">Un <b>numero</b></li>
                            <li id="length" class="invalid">Minimo <b>8 caratteri</b></li>
                        </ul>
                    </div>
                </td>
                <td>
                    <br>
                    <div id="CheckPasswordMatch"></div>
                </td>
            </tr>
        <tr>
            <td>
                    <input type="submit" id="modifica" name="modifica" value="Modifica" class="btnConferma">
                    </form>
            </td>
            <td>
                    <form action="ModificaCredenziali" method="post" class="annulla">
                        <input type="submit" id="annulla" name="annulla" value="Annulla" class="btnConferma">
                    </form>
            </td>
        </tr>
    </table>
</span>

</body>
</html>
