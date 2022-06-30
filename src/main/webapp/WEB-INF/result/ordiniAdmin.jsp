<%@ page import="model.beans.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Visualizzazione Ordine</title>
</head>
<body>

    <%
        ArrayList<Ordine> list = (ArrayList<Ordine>)request.getAttribute("listOrdini");
        if(list.size() == 0){
    %>
    <h3>Non ci sono ordini effettuati</h3>
    <%
    }else{
        for(Ordine ordine: list){
    %>
        <details class="">
            <summary>Data: <%=ordine.getDataPagamento()%> Totale: <%=ordine.getTotale()%>/
                Tipo Pagamento:<%=ordine.getTipoPagamento()%> Carta: <%=ordine.getNumeroCarta()%> Email Utente: <%=ordine.getEmailUtente()%></summary>
            <table>
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrizione</th>
                    <th>Prezzo</th>
                    <th>Quantità</th>
                    <th>Email Utente</th>
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
                        <%=prodottoQuantita.getPrezzo()%>
                    </td>
                    <td data-head="Quantita">
                        <%=prodottoQuantita.getQuantita()%>
                    </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td>
                        <form action="">
                            <input type="hidden">
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </details>

        <%}%>
    <%}%>
</body>
</html>