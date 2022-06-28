<%@ page import="model.beans.Prodotto" %>
<%@ page import="model.beans.Utente" %>
<%@ page import="model.beans.ListaDeiDesideri" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Liste Desideri</title>
</head>
<body>
    <p>La mia lista dei desideri</p>
    <form action="ListaDesideri" method="post">
        <%
            ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");
            ArrayList<Prodotto> list = listaDeiDesideri.getListaProdotti();
            for (Prodotto prodotto: list){
        %>
            <p><img src="./PhotoController?codice=<%=prodotto.getCodice()%>"></p>
            <p><%=prodotto.getNome()%></p>
            <p><%=prodotto.getPrezzo()%>&#8364;</p>
            <input type="hidden" name="codice" value="<%=prodotto.getCodice()%>">
            <button type="submit" id="RimuoviDallaLista" name="cancella" value="cancella">
                <img src="https://img.icons8.com/fluency-systems-filled/30/000000/trash.png"/>
            </button>
            <hr>
        <%}%>
    </form>
</body>
</html>
