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
    <link href="css/admin.css" rel="stylesheet">
    <script src="JavaScript/admin.js" type="javascript"/>
    <title>Admin View</title>
</head>
<body>

    <div class="topnav" id="Topnav">
        <form action="AdminServlet">
            <input type="submit" id="aggiungi" name="scelta" value="Aggiungi i prodotti">
<%--                class="active"--%>
            <input type="submit" id="rimuovi" name="scelta" value="Rimuovi i prodotti">
            <input type="submit" id="modifica" name="scelta" value="Modifica">
            <input type="submit" id="visualizza" name="scelta" value="Visualizza">
            <a class="icon" href="javascript:void(0);" onclick=" menu()">
            <img src="https://img.icons8.com/ios-filled/50/D1D1D1/menu--v1.png"/></a>
        </form>
        <span>Benvenuto Admin</span>
    </div>

</body>
</html>
