<%@ page import="model.beans.Prodotto" %>
<%@ page import="model.beans.Utente" %>
<%@ page import="model.beans.ListaDeiDesideri" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage = "/error.jsp" %>
<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Liste Desideri</title>
    <link rel="stylesheet" href="css/carrello.css"/>
</head>
<body>
    <p class="title">La mia lista dei desideri</p>
    <form action="ListaDesideri" method="post" class="formProdotto">
        <%
            ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");
            ArrayList<Prodotto> list = listaDeiDesideri.getListaProdotti();
            for (Prodotto prodotto: list){
        %>
            <div><img id="imgProdotto" src="./PhotoController?codice=<%=prodotto.getCodice()%>"></div>
            <br>
            <span><%=prodotto.getNome()%></span>
            <span><%=prodotto.getPrezzo()%>&#8364;</span>
            <input type="hidden" name="codice" value="<%=prodotto.getCodice()%>">
            <button type="submit" id="RimuoviDallaLista" name="cancella" value="cancella" class="cancella">
                <img src="https://img.icons8.com/fluency-systems-filled/30/000000/trash.png"/>
            </button>
            <hr>
        <%}%>
    </form>
    <form action="EffettuaOrdine" class="formConferma">
        <input type="submit" name="continuaAcquisti" value="Ritorna agli acquisti">
    </form>
</body>
</html>
