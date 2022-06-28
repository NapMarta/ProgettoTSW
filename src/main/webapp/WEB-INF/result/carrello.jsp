<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page import="model.beans.Carrello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="stylesheet" href="css/carrello.css"/>
    <script src="JavaScript/carrello.js" type="text/javascript"></script>
</head>
<body>


    <%  session = request.getSession(false);
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        ArrayList<ProdottoQuantita> list = carrello.getListaProdotti();
    %>
    <c:choose>
        <c:when  test = "${list != 'null' || list.size() !='0'}">
            <% for (ProdottoQuantita p: list) { %>

                <form action="Aggiungi" method="post">
                    <p><%= p.getNome()%></p>
                    <input type="hidden" name="cod" value="<%=p.getCodice()%>">
                    <button name="quantita" value="meno">
                        <img src="https://img.icons8.com/ios-glyphs/20/000000/minus.png"/>
                    </button>
                    <p><%= p.getQuantita()%></p>
                    <button name="quantita" value="piu">
                        <img src="https://img.icons8.com/ios-glyphs/20/000000/macos-maximize.png"/>
                    </button>

                    <p><%= p.getPrezzo()%></p>
                    <button type="submit" id="RimuoviDalCarrello" name="cancella" value="cancella">
                        <img src="https://img.icons8.com/fluency-systems-filled/30/000000/trash.png"/>
                    </button>
                    <hr>
                </form>


            <%}%>
            <form action="EffettuaOrdine">
                <p>Totale: <%= carrello.getTotale()%> €</p>
                <p>Numero prodotti: <%= carrello.getNumeroProdotti()%></p>
                <input type="submit" name="conferma" value="Conferma ordine">
                <input type="submit" name="continuaAcquisti" value="Ritorna agli acquisti">
            </form>
        </c:when>

    </c:choose>





</body>
</html>
