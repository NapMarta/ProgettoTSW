<%--
  Created by IntelliJ IDEA.
  User: Marta
  Date: 07/05/2022
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Benvenuto Admin</h1>
    <form action="AdminServlet">
        <p>Scegli l'operazione da effettuare:</p>
        <input type="radio" id="aggiungi" name="scelta" value="Aggiungi" >
            <label for="aggiungi">Aggiungi i prodotti</label><br>
        <input type="radio" id="rimuovi" name="scelta" value="Rimuovi">
            <label for="rimuovi">Rimuovi i prodotti</label><br>
        <input type="radio" id="modifica" name="scelta" value="Modifica">
            <label for="modifica">Modifica i prodotti</label><br>
        <input type="radio" id="visualizza" name="scelta" value="Visualizza">
            <label for="visualizza">Visualizza gli ordini dei clienti</label><br>
        <input type="submit" value="Conferma">
    </form>
</body>
</html>
