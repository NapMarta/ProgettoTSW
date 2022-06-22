<%@ page import="model.beans.Utente" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Homepage</title>
    <link href="css/homepage.css" rel="stylesheet" type="text/css"/>
    <script src="../../JavaScript/catalogo.js" type="text/javascript"></script>
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
        <form action="CatalogoServlet" method="get">
        <table>
            <tr>
                <td>
                    <button type="submit" value="Pizza" name="tipologia" class="btnUP">
                        <img src="https://img.icons8.com/ios-glyphs/60/C29436/pizza.png"/>
                    </button>
                </td>
                <td>
                    <button type="submit" value="Paninp" name="tipologia" class="btnUP">
                        <img src="https://img.icons8.com/ios-glyphs/60/C29436/hamburger.png"/>
                    </button>
                </td>
                <td>
                    <button type="submit" value="Fritto" name="tipologia" class="btnUP">
                        <img src="https://img.icons8.com/ios-glyphs/60/C29436/chips.png"/>
                    </button>
                </td>
                <td>
                    <button type="submit" value="Bibita" name="tipologia" class="btnUP">
                        <img src="https://img.icons8.com/ios-glyphs/60/C29436/beer.png"/>
                    </button>
                </td>
                <td>
                    <button type="submit" value="Dolce" name="tipologia" class="btnUP">
                        <img src="https://img.icons8.com/ios-glyphs/60/C29436/ice-cream-in-waffle-cone.png"/>
                    </button>
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
                    <span>Fritti</span>
                </td>
                <td>
                    <span>Bibite</span>
                </td>
                <td>
                    <span>Dolci</span>
                </td>
            </tr>
        </table>
        </form>
    </nav>
</div>

<div class="content">
    <%@include file="catalogo.jsp"%>
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
<%--                    <%--%>
<%--                        Utente utente = new Utente();--%>
<%--                        utente = (Utente) request.getAttribute("utente");--%>
<%--                        if(utente == null){--%>
<%--                    %>--%>
<%--                            <div class="dropup">--%>
<%--                                <a href="WEB-INF/result/login.jsp" class="dropbtn">--%>
<%--                                    <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                    <%--%>
<%--                        }else{--%>
<%--                    %>--%>
<%--                            <div class="dropup">--%>
<%--                                <button class="dropbtn" id="utente">--%>
<%--                                    <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>--%>
<%--                                </button>--%>
<%--                                <div class="dropup-content" id="elements">--%>
<%--                                    <form action="">--%>
<%--                                        <input type="submit" name="elements" value="Ordini Effettuati" id="ordini">--%>
<%--                                        <input type="submit" name="elements" value="Modifica Credenziali" id="credenziali">--%>
<%--                                        <input type="submit" name="elements" value="Lista dei desideri" id="listaDes">--%>
<%--                                        <input type="submit" name="elements" value="Logout" id="logout">--%>
<%--                                    </form>--%>
<%--                            </div>--%>
<%--                    <%--%>
<%--                        }--%>
<%--                    %>--%>

<%--&lt;%&ndash;                    <div class="dropup-content" id="elements">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <form action="">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="submit" name="elements" value="Ordini Effettuati" id="ordini">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="submit" name="elements" value="Modifica Credenziali" id="credenziali">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="submit" name="elements" value="Lista dei desideri" id="listaDes">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input type="submit" name="elements" value="Logout" id="logout">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </form>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </div>&ndash;%&gt;--%>

                </div>
            </td>
        </tr>
    </table>
</footer>
</body>
</html>