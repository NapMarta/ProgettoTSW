<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/home.css"  rel="stylesheet">
</head>
<body>
    <div class="home">
        <img src="logo.jpeg" id="logo"><br>
        <p id="nome">CookStock</p>
    </div>
    <hr>
    <form action="HomeServlet" method="get">
        <input type="submit" name="home" value="HomePage">
        <input type="submit" name="login" value="Login/Registrati">
    </form>

    <footer>
        <p>Copyright © 2022. CookStock tutti i diritti riservati.</p>
    </footer>

</body>
</html>