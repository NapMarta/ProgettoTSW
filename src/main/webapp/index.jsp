
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <link href="css/homepage.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="javaScript/homepage.js"></script>
</head>
<body>
    <table>
        <tr>
            <td>
                <img src="logo.jpeg" height="60" width="60">
            </td>
            <td>
                <h2>CookStock</h2>
            </td>
            <td>
                <img src="https://img.icons8.com/color/40/000000/instagram-new--v1.png"/>
            </td>
            <td>
                <img src="https://img.icons8.com/color/40/000000/facebook-new.png"/>
            </td>
        </tr>
    </table>
    <div class="navbarUP">
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/pizza.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/hamburger.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/chips.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/beer.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/ice-cream-in-waffle-cone.png"/></a>
    </div>


    <div class="navbarDOWN">
        <a href="#"><img src="https://img.icons8.com/ios/40/C29436/search--v1.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/40/C29436/shopping-cart--v1.png"/></a>
        <span class="dropup">
            <button class="dropbtn" onclick="isLogin()" id="utente">
                <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>
            </button>

            <div class="dropup-content" id="elements">
                <a href="#">Ordini Effettuati</a>
                <a href="#">Modifica Credenziali</a>
                <a href="#">Lista dei desideri</a>
                <a href="#">Logout</a>
            </div>
        </span>
        <a href="#"><img src="https://img.icons8.com/ios/40/C29436/info--v1.png"/></a>
    </div>
</body>
</html>
