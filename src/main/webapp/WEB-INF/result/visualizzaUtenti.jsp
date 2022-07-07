<%@ page import="model.beans.Utente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.ProdottoQuantita" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage = "/error.jsp" %>

<html>
<head>
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Visualizzazione Utenti</title>
    <link href="css/visUtenti.css" rel="stylesheet" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<%
    ArrayList<Utente> list = (ArrayList<Utente>)request.getAttribute("listUtenti");
    if(list.size() == 0){
%>
        <h3>Non ci sono ordini effettuati</h3>
<%
}else{%>
<p class="title">Visualizzazione Utenti</p>


<table>
    <thead>
    <tr>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
<%
    for(Utente utente: list){
%>
        <tr>
            <td data-head="Nome">
                <%=utente.getNome()%>
            </td>
            <td data-head="Cognome">
                <%=utente.getCognome()%>
            </td>
            <td data-head="Email">
                <%=utente.getEmail()%>
            </td>
        </tr>
    <%}%>
       </tbody>
    </table>
    <br><br><br>

    <form action="Ordini">
        <button type="submit" value="Home" name="homeAdmin" id="home">
            <img src="https://img.icons8.com/material-rounded/30/000000/home.png"/>
        </button>
    </form>
<%}%>

</body>
</html>