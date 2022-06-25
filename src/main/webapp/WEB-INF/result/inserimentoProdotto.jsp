



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Inserimento Prodotto</title>
</head>
<body>
    <form action="AggiungiProdotto" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    <label for="nomeProdotto">Nome Prodotto</label>
                    <input type="text" id="nomeProdotto" name="nomeProdotto">
                </td>
                <td>
                    <label for="prezzoProdotto">Prezzo</label>
                    <input type="number" id="prezzoProdotto" name="prezzoProdotto" min="0" step="0.01">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="descrizione">Descrizione</label>
                    <input type="text" id="descrizione" name="descrizione">
                </td>
                <td>
                    <label for="tipologia">Tipologia</label>
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
                </td>
            </tr>
            <tr>
                <input type="submit" value="Conferma">
            </tr>
        </table>
    </form>
</body>
</html>