<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <link rel="stylesheet" href="css/carrello.css"/>
    <script src="JavaScript/carrello.js" type="text/javascript"></script>
</head>
<body>

    <form action="">
    <%  session = request.getSession(false);
        ArrayList<ProdottoQuantita> list = (ArrayList<ProdottoQuantita>) session.getAttribute("list");
        if(list != null){
            for (ProdottoQuantita p: list) {
    %>

            <div>
                <p><% p.getNome();%></p>
                <select><% p.getQuantita();%></select>
                <p><% p.getPrezzo();%></p>
                <button type="submit" id="RimuoviDalCarrello">
                    <img src="https://img.icons8.com/fluency-systems-filled/30/000000/trash.png"/>
                </button>
            </div>

    <%
    }

    %>

        <input type="submit" name="conferma" value="Conferma ordine">
        <input type="submit" name="continuaAcquisti" value="Ritorna agli acquisti">
    </form>

    <% } else { %>
        <div> Il carrello è vuoto</div>

    <% } %>



</body>
</html>
