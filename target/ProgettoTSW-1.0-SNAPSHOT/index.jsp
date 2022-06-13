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
                    <img src="logo.jpeg" height="60" width="60">
                </td>
                <td>
                    <h2 id="nomePub">CookStock</h2>
                </td>
                <td id="social">
                    <img src="https://img.icons8.com/color/40/000000/instagram-new--v1.png" class="social"/>
                    <img src="https://img.icons8.com/color/40/000000/facebook-new.png" class="social"/>
                </td>
            </tr>
        </table>
    </header>

    <nav class="navbarUp">
        <table>
            <tr>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/80/C29436/pizza.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/80/C29436/hamburger.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/80/C29436/chips.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/80/C29436/beer.png"/></a>
                </td>
                <td>
                    <a href="#"><img src="https://img.icons8.com/ios-glyphs/80/C29436/ice-cream-in-waffle-cone.png"/></a>
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
    <%--        <c:forech>--%>
    <%--            --%>
    <%--        </c:forech>--%>
</div>

<footer class="navbarDown">
    <table>
        <tr>
            <td>
                <form class="search" action="">
                    <input type="text" placeholder="Search..." name="search">
                    <button type="submit"><img src="https://img.icons8.com/ios/40/C29436/search--v1.png"/></button>
                </form>
            </td>
            <td>
                <a href="#"><img src="https://img.icons8.com/ios-glyphs/40/C29436/shopping-cart--v1.png"/></a>

            </td>
            <td>
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
            </td>
            <td>
                <a href="#"><img src="https://img.icons8.com/ios/40/C29436/info--v1.png"/></a>
            </td>
        </tr>
    </table>
</footer>
</body>
</html>

<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <link href="css/home.css"  rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--    <div class="home">--%>
<%--        <img src="logo.jpeg" id="logo"><br>--%>
<%--        <p id="nome">CookStock</p>--%>
<%--    </div>--%>
<%--    <hr>--%>
<%--    <div class="home2">--%>
<%--        <a href="WEB-INF/result/homepage.jsp">HomePage</a><br>--%>
<%--    </div>--%>
<%--    <div class="home2">--%>
<%--        <a href="WEB-INF/result/login.jsp">Login/Registrati</a><br>--%>
<%--    </div>--%>

<%--    <footer>--%>
<%--        <p>Copyright © 2022. CookStock tutti i diritti riservati.</p>--%>
<%--    </footer>--%>

<%--</body>--%>
<%--</html>--%>