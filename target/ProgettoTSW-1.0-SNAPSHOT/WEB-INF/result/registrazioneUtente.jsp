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
            <p>Registrazione Utente</p>
            <hr>

            <label for="email">Email</label><br>
            <input type="email" placeholder="Inserisci Email" name="email" id="email" required><br>
            <label for="psw">Password</label><br>
            <input type="password" placeholder="Inserisci Password" name="psw" id="psw" required><br>

            <label for="psw-repeat">Ripetere Password</label><br>
            <input type="password" placeholder="Ripetere Password" name="psw-repeat" id="psw-repeat" required><br><br>

            <input type="submit" id="accedi" value="Registrati ora"><br><br>
            <p class="testo">Hai già un account?<input type="submit" id="registrati" value="Login"></p>
        </form>


    </div>

</body>
</html>