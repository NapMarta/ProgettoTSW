<%@ page import="model.beans.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage = "/error.jsp" %>

<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Ordini Utenti</title>
    <link rel="stylesheet" href="css/elenco.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <p class="title">Ordini Utenti</p>

    <%
        ArrayList<Ordine> list = (ArrayList<Ordine>)request.getAttribute("listOrdini");
        if(list.size() == 0){
    %>
    <h3>Non ci sono ordini effettuati</h3>
    <%
    }else{
        for(Ordine ordine: list){
    %>
        <details>
            <summary>Data: <%=ordine.getDataPagamento()%> Totale: <%=ordine.getTotale()%>&#8364;/
                Tipo Pagamento:<%=ordine.getTipoPagamento()%> Carta: <%=ordine.getNumeroCarta()%> Email Utente: <%=ordine.getEmailUtente()%></summary>
            <table>
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrizione</th>
                    <th>Prezzo</th>
                    <th>Quantità</th>
                </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<ProdottoQuantita> listaProdotti = ordine.getListaProdotti();
                        for(ProdottoQuantita prodottoQuantita: listaProdotti){%>
                    <tr>
                        <td data-head="Nome">
                            <%=prodottoQuantita.getNome()%>
                        </td>
                        <td data-head="Descrizione">
                            <%=prodottoQuantita.getDescrizione()%>
                        </td>
                        <td data-head="Prezzo">
                            <%=prodottoQuantita.getPrezzo()%>&#8364;
                        </td>
                        <td data-head="Quantita">
                            <%=prodottoQuantita.getQuantita()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </details>
        <%}%>
    <%}%>

    <form action="Ordini">
        <button type="submit" value="Home" name="homeAdmin" id="home">
            <img src="https://img.icons8.com/material-rounded/30/000000/home.png"/>
        </button>
    </form>
</body>
</html>