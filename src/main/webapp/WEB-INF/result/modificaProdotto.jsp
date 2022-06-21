<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    <title>Modifica Prodotto</title>
</head>
<body>
<form action="ModificaProdottoServlet" method="put" enctype="multipart/form-data">
    <table>
        <input type="text" name="id" value="${prodotto.codice}">
        <tr>
            <td>
                <label for="nomeProdotto">Nome Prodotto</label>
                <input type="text" id="nomeProdotto" name="nomeProdotto" value="${prodotto.nome}">
            </td>
            <td>
                <label for="prezzoProdotto">Prezzo</label>
                <input type="number" id="prezzoProdotto" name="prezzoProdotto" min="0" step="0.01" value="${prodotto.prezzo}">
            </td>
        </tr>
        <tr>
            <td>
                <label for="descrizione">Descrizione</label>
                <input type="text" id="descrizione" name="descrizione" value="${prodotto.descrizione}">
            </td>
            <td>
                <label for="tipologia">Tipologia</label>
                <select id="tipologia" name="tipologia" value="${prodotto.tipologia}">
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
                <p><img src="./PhotoController?codice=${prodotto.codice}" style="width:100px"></p><br/>

            </td>
        </tr>
        <tr>
            <input type="submit" value="Conferma">
        </tr>
    </table>
</form>
</body>
</html>