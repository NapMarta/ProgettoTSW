<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/inizio.css" rel="stylesheet">
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>CookStock</title>
</head>
<body>
    <div class="home">
        <img src="logo.jpeg" id="logo" alt="logo sito web"><br>
        <p id="nome">CookStock</p>
    </div>
    <hr>
    <form action="HomeServlet" method="get">
        <input type="submit" name="home" value="HomePage">
        <input type="submit" name="login" value="Login/Registrati">
    </form>

    <footer>
        <p>Copyright © 2022. CookStock tutti i diritti riservati.</p>
        <p>Via Roma 54, Avellino (AV) Tel. <a href="tel:0825447586">0825447586</a></p>
        <p>Made With &#x2764;</p>
    </footer>

</body>
</html>