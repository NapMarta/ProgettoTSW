<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <link href="css/homepage.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="javaScript/homepage.js"></script>
</head>
<body>

<div class="navbarTot">
    <header>
        <table>
            <tr>
                <td id="logo">
                    <a href="index.jsp">
                        <img src="logo.jpeg" height="60" width="60">
                    </a>
                </td>
                <td>
                    <h2 id="nomePub">CookStock</h2>
                </td>
                <td id="social">
                    <a href="https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwjOiKy6_674AhUTi_0HHSNhAJcQFnoECAgQAQ&url=https%3A%2F%2Fwww.instagram.com%2F&usg=AOvVaw1cBeRoOpMhZ3-x5M1sA3Fm">
                        <img src="https://img.icons8.com/color/40/000000/instagram-new--v1.png" class="social"/>
                    </a>
                    <a href="https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwjEnbyEgK_4AhWfgv0HHbLNDGgQFnoECAgQAQ&url=https%3A%2F%2Fit-it.facebook.com%2F&usg=AOvVaw0QAHe3HHSlIy5N1ZAXMlWx">
                        <img src="https://img.icons8.com/color/40/000000/facebook-new.png" class="social"/>
                    </a>
                </td>
            </tr>
        </table>
    </header>

    <nav class="navbarUp">
        <table>
            <tr>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/pizza.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/hamburger.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/chips.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/beer.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/ice-cream-in-waffle-cone.png"/></a>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Pizza</span>
                </td>
                <td>
                    <span>Hamburger</span>
                </td>
                <td>
                    <span>Patatine</span>
                </td>
                <td>
                    <span>Bibite</span>
                </td>
                <td>
                    <span>Dolci</span>
                </td>
            </tr>
        </table>
    </nav>
</div>

<div class="content">
</div>

<footer class="navbarDown">
    <table>
        <tr>
            <td>
                <div class="search">
                    <form action="">
                        <input type="text" placeholder="Search..." name="search" id="search-input">
                        <button type="submit" id="search-button">
                            <a href="#"><img src="https://img.icons8.com/ios/40/C29436/search--v1.png"/></a>
                        </button>
                    </form>
                </div>
            </td>
            <td>
                <a href="#" class="notification">
                    <img src="https://img.icons8.com/ios-glyphs/40/C29436/shopping-cart--v1.png"/>
                    <span class="badge">0</span>
                </a>
            </td>
            <td>
                <div class="dropup">
                    <button class="dropbtn" id="utente">
                        <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>
                    </button>
                    <div class="dropup-content" id="elements">
                        <form action="">
                            <input type="submit" name="elements" value="Ordini Effettuati" id="ordini">
                            <input type="submit" name="elements" value="Modifica Credenziali" id="credenziali">
                            <input type="submit" name="elements" value="Lista dei desideri" id="listaDes">
                            <input type="submit" name="elements" value="Logout" id="logout">
                        </form>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</footer>
</body>
</html>