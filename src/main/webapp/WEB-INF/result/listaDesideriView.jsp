<%@ page import="model.beans.Prodotto" %>
<%@ page import="model.beans.Utente" %><%--
  Created by IntelliJ IDEA.
  User: Utente
  Date: 28/06/2022
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Liste Desideri</title>
</head>
<body>
    <p>Le mie liste dei desideri</p>
    <form>
        <% Prodotto p = (Prodotto) request.getAttribute("prodotto");
            Utente utente = (Utente) session.getAttribute("utente");


            %>
    </form>
</body>
</html>
