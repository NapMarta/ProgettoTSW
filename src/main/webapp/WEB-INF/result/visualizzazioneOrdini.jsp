
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Visualizzazione Ordine</title>
    </head>
    <body>
        <c:choose>
            <c:when>
                <h3>Non ci sono ordini effettuati</h3>
            </c:when>
            <c:otherwise>
                <c:forEach items="${listOrdini}" var="ordine">
                    <details class="">
                       <summary>Data: ${ordine.dataPagamento} / Totale: ${ordine.totale}</summary>
                        <table>
                            <thead>
                                <tr>
                                    <th>Prodotto</th>
                                    <th>Prezzo</th>
                                    <th>Quantità</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ordine.listaProdotti}" var="items">
                                    <tr>
                                        <td data-head="Prodotto">
<%--                                            foto--%>
                                        </td>
                                        <td data-head="Prezzo"></td>
                                        <td data-head="Quantita"></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </details>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
