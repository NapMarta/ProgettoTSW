<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inserimento Prodotto</title>
</head>
<body>
    <form action="" method="post">
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
                    <input type="file" name="immagine" value="" maxlength="255">	
                </td>
            </tr>
            <tr>
                <input type="submit" value="Conferma">
            </tr>
        </table>
    </form>
</body>
</html>