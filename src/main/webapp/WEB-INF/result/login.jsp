<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Login</title>
    <link href="css/login.css" rel="stylesheet">
    <script type="text/javascript" src="JavaScript/registrazione.js"></script>
</head>
<body>
    <div class="parent">
        <p class="titolo">Login</p>
        <form action="LoginServlet" method="post" class="child">
            <label for="email">Email</label><br>            <!--admin@gmail.com-->
            <input type="email" id="email" name="email" placeholder="Email"><br>
            <label for="password">Password</label><br>      <!--admin-->
            <div class="visible">
                <input type="password" id="password" name="password" id="password" placeholder="Password">
                <button type="button"  class="btn" onclick="visible('password', 'psw-linea');">
                    <img src="https://img.icons8.com/ios/20/undefined/visible--v1.png" class="occhio"/>
                    <img src="https://img.icons8.com/ios/20/undefined/line--v1.png" class="linea" id="psw-linea"/>
                </button>
            </div>
            <br><br>
            <input type="submit" value="Accedi" name="accedi" id="accedi"><br><br>
            <input type="submit" value="Sei un nuovo utente? Registrati" name="registrati" id="registrati">
        </form>
    </div>

</body>
</html>