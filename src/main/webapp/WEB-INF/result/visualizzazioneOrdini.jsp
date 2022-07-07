<%@ page import="model.beans.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage = "/error.jsp" %>

<html>
    <head>
        <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
        <title>Visualizzazione Ordini</title>
        <link rel="stylesheet" href="css/elenco.css"/>

    </head>
    <body>

    <p class="title">I miei ordini</p>


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


                   <summary>Data: <%=ordine.getDataPagamento()%> / Totale: <%=ordine.getTotale()%>&#8364;</summary>
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

        <div>
            <form action="Ordini">
                <input type="submit" name="home" value="Ritorna agli acquisti">
            </form>
        </div>
    </body>
</html>
