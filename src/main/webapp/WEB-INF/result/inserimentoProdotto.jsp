
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Inserimento Prodotto</title>
    <link href="css/modificheProdotto.css" rel="stylesheet">
    <script type="text/javascript" src="JavaScript/validazioniForm/validazioneProdotto.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <div class="contentForm">
        <form action="AggiungiProdotto" method="post" name="prodotto" onsubmit="return validateP();" enctype="multipart/form-data">
            <p class="titolo">Inserimento Prodotto</p>
            <hr>
            <table>
                <tr>
                    <td>
                        <label for="nomeProdotto">Nome Prodotto</label><br>
                        <input type="text" id="nomeProdotto" name="nomeProdotto" placeholder="Nome Prodotto">
                    </td>
                    <td>
                        <label for="prezzoProdotto">Prezzo</label><br>
                        <input type="number" id="prezzoProdotto" name="prezzoProdotto" min="0" step="0.01">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descrizione">Descrizione</label><br>
                        <input type="text" id="descrizione" name="descrizione" placeholder="Descrizione">
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
                        <input type="file" name="immagine" value="" size="50" accept="image/*" required>
                        <br><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Conferma" name="conferma">
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