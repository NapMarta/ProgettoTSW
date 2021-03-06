<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage = "/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Login</title>
    <link href="css/login.css" rel="stylesheet">
    <script type="text/javascript" src="JavaScript/registrazione.js"></script>
    <script type="text/javascript" src="JavaScript/validazioniForm/validazioneLogin.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="parent">
        <p class="titolo">Login</p>

        <form action="Login" method="post" class="child" name="login" onsubmit="return validate();">
            <%
                Boolean error = (Boolean) request.getAttribute("error");
                if(error != null){%>
                    <span class="error">
                       Email e/o password errati
                    </span><br>
            <%}%>

            <br><br>
            <label for="email">Email</label><br>
            <input type="email" id="email" name="email" placeholder="Email"><br>
            <label for="password">Password</label><br>
            <div class="visible">
                <input type="password" id="password" name="psw" id="password" placeholder="Password">
                <button type="button"  class="btn" onclick="visible('password', 'psw-linea');">
                    <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                    <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-linea"/>
                </button>
            </div>
            <br><br>
            <input type="submit" value="Accedi" name="accedi" id="accedi">
            <br>
        </form>
        <form action="Login" class="other">
            <button type="submit" value="Home" name="home" id="home">
                <img src="https://img.icons8.com/material-rounded/30/000000/home.png"/>
            </button>
            <input type="submit" value="Sei un nuovo utente? Registrati" name="registrati" id="registrati">
        </form>
    </div>

</body>
</html>