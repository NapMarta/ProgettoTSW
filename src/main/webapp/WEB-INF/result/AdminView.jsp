
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="css/admin.css" rel="stylesheet">
    <script src="JavaScript/admin.js" type="text/javascript"></script>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Admin View</title>
</head>
<body>

    <div class="topnav" id="nav">
        <form action="AdminServlet">
            <input type="submit" id="aggiungi" name="scelta" value="Aggiungi prodotto">
            <input type="submit" id="rimuovi" name="scelta" value="Rimuovi prodotto">
            <input type="submit" id="modifica" name="scelta" value="Modifica prodotto">
            <input type="submit" id="visualizza" name="scelta" value="Visualizza ordini">
            <a class="icon" href="javascript:void(0);" onclick="menu();">
            <img src="https://img.icons8.com/ios-filled/40/D1D1D1/menu--v1.png"/>
            </a>
        </form>
    </div>
    <span>Benvenuto Admin</span>

    <c:forEach items="${prodottoList}" var="prodotto">
        <p>${prodotto.nome}</p><br/>
        <p>${prodotto.tipologia}</p><br/>
        <p>${prodotto.descrizione}</p><br/>
        <p>${prodotto.prezzo}</p><br/>
        <p><img src="./PhotoController?id=${prodotto.codice}" style="width:100px"></p><br/>
    </c:forEach>
</body>
</html>
