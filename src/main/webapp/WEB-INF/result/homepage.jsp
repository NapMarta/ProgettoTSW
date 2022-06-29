<%@ page import="model.beans.Utente" %>
<%@ page import="model.beans.Carrello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Homepage</title>
    <link href="css/homepage.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/catalogo.css">
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
        <form action="Catalogo" method="get">
            <table>
                <tr>
                    <td>
                        <button type="submit" value="Pizza" name="tipologia" class="btnUP">
                            <img src="https://img.icons8.com/ios-glyphs/60/C29436/pizza.png" id="pizza"/>
                        </button>
                    </td>
                    <td>
                        <button type="submit" value="Panino" name="tipologia" class="btnUP">
                            <img src="https://img.icons8.com/ios-glyphs/60/C29436/hamburger.png" id="panino"/>
                        </button>
                    </td>
                    <td>
                        <button type="submit" value="Fritto" name="tipologia" class="btnUP">
                            <img src="https://img.icons8.com/ios-glyphs/60/C29436/chips.png" id="fritto"/>
                        </button>
                    </td>
                    <td>
                        <button type="submit" value="Bibita" name="tipologia" class="btnUP">
                            <img src="https://img.icons8.com/ios-glyphs/60/C29436/beer.png" id="bibita"/>
                        </button>
                    </td>
                    <td>
                        <button type="submit" value="Dolce" name="tipologia" class="btnUP">
                            <img src="https://img.icons8.com/ios-glyphs/60/C29436/ice-cream-in-waffle-cone.png" id="dolce"/>
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

<%
    Utente utente = (Utente) session.getAttribute("utente");
%>

<div class="content">
    <c:forEach items="${prodottoList}" var="prodotto">
        <form action="Aggiungi" method="post">
            <figure>
                <figcaption class="column">
                    <p><img src="./PhotoController?codice=${prodotto.codice}"></p>
                    <div class="btnProdotto">
                        <button type="submit" id="AggiungiCarrello" name="aggiungiCarrello" value="carrello" onclick="alert('Prodotto aggiunto al carrello')">
                            <img src="https://img.icons8.com/ios-glyphs/30/C29436/add-shopping-cart.png"/>
                        </button>
                        <button type="submit" id="AggiungiPreferiti" name="aggiungiDesideri" value="lista">
                            <img src="https://img.icons8.com/ios-glyphs/30/C29436/favorite-cart.png"/>
                        </button>
                    </div>
                    <div class="descrizione">
                        <p>${prodotto.nome}</p>
                        <p>${prodotto.descrizione}</p>
                        <p class="prezzo">${prodotto.prezzo}&#8364;</p>
                        <input type="hidden" name="codice" value="${prodotto.codice}">
                        <input type="hidden" name="tipologia" value="${prodotto.tipologia}">
                    </div>
                </figcaption>
            </figure>
        </form>
    </c:forEach>
</div>

<footer class="navbarDown">
    <table>
        <tr>
            <td>
                <div class="search">
                    <form action="SearchProdotto">
                        <input type="search" placeholder="Cerca..." autocomplete="off"  name="search" id="search-input">
                        <button type="submit" id="search-button">
                            <img src="https://img.icons8.com/ios/40/C29436/search--v1.png"/>
                        </button>
                    </form>
                </div>
            </td>
            <td>
                <%Carrello carrello = (Carrello) session.getAttribute("carrello");%>
                <form action="Carrello">
                    <button type="submit" class="notification" name="carrello" value="Carrello">
                        <img src="https://img.icons8.com/ios-glyphs/40/C29436/shopping-cart--v1.png"/>
                        <span class="badge"><%=carrello.calcolaNumeroProdotti()%></span>
                    </button>
                </form>
            </td>
            <td>
                <%
                    if(utente != null){
                %>
                        <div class="dropup">
                            <button class="dropbtn" id="utente">
                                <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>
                            </button>
                            <div class="dropup-content" id="elements">
                                <form action="OperazioniUtente">
                                    <input type="submit" name="elements" value="Ordini Effettuati" id="ordini">
                                    <input type="submit" name="elements" value="Modifica Credenziali" id="credenziali">
                                    <input type="submit" name="elements" value="Lista dei desideri" id="listaDes">
                                    <input type="submit" name="elements" value="Logout" id="logout">
                                </form>
                            </div>
                        </div>
                <%  }else{  %>
                        <div class="dropup">
                            <form action="Utente" method="get">
                                <button class="dropbtn log" type="submit" name="utente" value="login">
                                    <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>
                                </button>
                            </form>
                        </div>
                <%}%>
            </td>
        </tr>
    </table>
</footer>
</body>
</html>