<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page import="model.beans.Carrello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage = "/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/carrello.css"/>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <p class="title">Il mio carrello</p>
    <%  session = request.getSession(false);
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        ArrayList<ProdottoQuantita> list = carrello.getListaProdotti();
    %>
    <c:choose>
        <c:when  test = "${list != 'null' || list.size() !='0'}">
            <% for (ProdottoQuantita p: list) { %>

                <form action="Aggiungi" method="post" class="formProdotto">
                    <span><%= p.getNome()%></span>
                    <input type="hidden" name="cod" value="<%=p.getCodice()%>">
                    <button name="quantita" value="meno">
                        <img src="https://img.icons8.com/ios-glyphs/20/000000/minus.png"/>
                    </button>
                    <span><%= p.getQuantita()%></span>
                    <button name="quantita" value="piu">
                        <img src="https://img.icons8.com/ios-glyphs/20/000000/macos-maximize.png"/>
                    </button>

                    <span><%= p.getPrezzo()%>&#8364;</span>
                    <button type="submit" id="RimuoviDalCarrello" name="cancella" value="cancella" class="cancella">
                        <img src="https://img.icons8.com/fluency-systems-filled/30/000000/trash.png"/>
                    </button>
                    <hr>
                </form>


            <%}%>
            <form action="EffettuaOrdine" class="formConferma">
                <p>Totale provvisorio: <%= carrello.calcolaTotale()%>&#8364;</p>
                <p>Numero prodotti: <%= carrello.calcolaNumeroProdotti()%></p>
                <input type="submit" name="conferma" value="Conferma ordine">
                <input type="submit" name="continuaAcquisti" value="Ritorna agli acquisti">
            </form>
        </c:when>

    </c:choose>


</body>
</html>
