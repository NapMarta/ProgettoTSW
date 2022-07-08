<%@ page import="model.beans.Prodotto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "/error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
        <title>Modifica Prodotto</title>
        <link href="css/modificheProdotto.css" rel="stylesheet">
        <script type="text/javascript" src="JavaScript/validazioniForm/validazioneProdotto.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <% Prodotto prodotto = (Prodotto) session.getAttribute("prodotto"); %>
        <div class="contentForm">
            <form action="ModificaProdotto" method="post" name="prodotto" onsubmit="return validateP();" enctype="multipart/form-data">
                <p class="titolo">Modifica Prodotto</p>
                <hr>
                <table>
                    <input type="hidden" name="id" value="<%= prodotto.getCodice()%>">
                    <tr>
                        <td>
                            <label for="nomeProdotto">Nome Prodotto</label><br>
                            <input type="text" id="nomeProdotto" name="nomeProdotto" value="<%= prodotto.getNome()%>">
                        </td>
                        <td>
                            <label for="prezzoProdotto">Prezzo</label><br>
                            <input type="number" id="prezzoProdotto" name="prezzoProdotto" min="0" step="0.01" value="<%= prodotto.getPrezzo()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="descrizione">Descrizione</label><br>
                            <input type="text" id="descrizione" name="descrizione" value="<%= prodotto.getDescrizione()%>">
                        </td>
                        <td>
                            <label for="tipologia">Tipologia</label><br>
                            <select id="tipologia" name="tipologia">
                                <option value="panino">Panino</option>
                                <option value="pizza">Pizza</option>
                                <option value="bibita">Bibita</option>
                                <option value="fritto">Fritto</option>
                                <option value="dolce">Dolce</option>
                            </select>
                    </tr>
                    <tr>
                        <td>
                            <input type="file" name="immagine" size="50" accept="image/*"><br><br>
                            <p><img id="imgProdotto" src="./PhotoController?codice=<%= prodotto.getCodice()%>"  name="immagineVecchia"></p><br/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Conferma modifica" name="modifica">
                        </td>
                    </tr>
                </table>
            </form>
            <form action="Ordini">
                <button type="submit" value="Home" name="homeAdmin" id="home">
                    <img src="https://img.icons8.com/material-rounded/30/000000/home.png"/>
                </button>
            </form>
        </div>
    </body>
</html>