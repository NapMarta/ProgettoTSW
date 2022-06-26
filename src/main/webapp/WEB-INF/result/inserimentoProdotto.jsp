
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Inserimento Prodotto</title>
    <link href="css/modificheProdotto.css" rel="stylesheet">
</head>
<body>

    <div class="contentForm">
        <form action="AggiungiProdotto" method="post" enctype="multipart/form-data">
            <p class="titolo">Inserimento Prodotto</p>
            <table>
                <tr>
                    <td>
                        <label for="nomeProdotto">Nome Prodotto</label><br>
                        <input type="text" id="nomeProdotto" name="nomeProdotto">
                    </td>
                    <td>
                        <label for="prezzoProdotto">Prezzo</label><br>
                        <input type="number" id="prezzoProdotto" name="prezzoProdotto" min="0" step="0.01">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="descrizione">Descrizione</label><br>
                        <input type="text" id="descrizione" name="descrizione">
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
                        <input type="file" name="immagine" value="" size="50">
                        <br><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Conferma">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>