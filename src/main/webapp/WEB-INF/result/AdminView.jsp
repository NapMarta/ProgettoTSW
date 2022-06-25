
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="css/admin.css" rel="stylesheet">
    <script src="JavaScript/admin.js" type="text/javascript"></script>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Admin View</title>
    <link rel="stylesheet" href="css/catalogo.css">
</head>
<body>

    <div class="topnav" id="nav">
        <form action="Admin">
            <input type="submit" id="aggiungi" name="scelta" value="Aggiungi prodotto">
            <input type="submit" id="ordini" name="scelta" value="Visualizza ordini">
            <input type="submit" id="utenti" name="scelta" value="Visualizza utenti">
            <input type="submit" id="logout" name="scelta" value="Logout">
            <a class="icon" href="javascript:void(0);" onclick="menu();">
            <img src="https://img.icons8.com/ios-filled/40/D1D1D1/menu--v1.png"/>
            </a>
        </form>
    </div>
    <span>Benvenuto Admin</span>

    <div class="content">
        <c:forEach items="${prodottoList}" var="prodotto">
            <form action="AdminServlet" method="post">
                <figure>
                    <figcaption class="column">
                        <p><img src="./PhotoController?codice=${prodotto.codice}"></p><br>
                        <div class="descrizione">
                            <p>${prodotto.nome}</p>
                            <p>${prodotto.tipologia}</p>
                            <p>${prodotto.descrizione}</p>
                            <p>${prodotto.prezzo}</p>
                        </div>
                        <div class="btnProdotto">
                            <input type="hidden" name="codice" value="${prodotto.codice}">
                            <input type="submit" id="rimuovi" name="scelta" value="Rimuovi prodotto">
                            <input type="submit" id="modifica" name="scelta" value="Modifica prodotto">
                        </div>
                    </figcaption>
                </figure>
            </form>
        </c:forEach>
    </div>
</body>
</html>
