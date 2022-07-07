<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage = "true" %>
<html>
<head>
    <title>Errore</title>
    <style>
        body{
            text-align: center;
        }

        img{
            width: 150px;
        }
        a{
            color: red;
        }

        a:hover{
            color: black;
        }
    </style>
</head>
<body>
    <h1>Errore</h1>
    <img src="error.jpg">
    <div class="message">
        Siamo spiacenti, si è verificato un errore durante l'esecuzione.<br/><br/>

    </div>

    <a href="index.jsp">Torna alla homepage!</a>
</body>
</html>