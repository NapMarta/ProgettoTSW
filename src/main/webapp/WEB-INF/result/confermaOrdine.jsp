<%@ page import="model.beans.Ordine" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Conferma Ordine</title>
        <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
        <link href="css/confermaOrdine.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="JavaScript/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="JavaScript/confermaOrdine.js"></script>
    </head>
    <body>
        <form method="post" action="EffettuaOrdine">
            <div>
                <label>Seleziona il tipo di ordine:</label>
                <span>
                    <input type="radio" id="asporto" name="tipologia" value="A"
                           checked>
                    <label for="asporto">Asporto</label>
                </span>
                    <span>
                    <input type="radio" id="domicilio" name="tipologia" value="D">
                    <label for="domicilio">Domicilio</label>
                </span>
                    <span>
                    <input type="radio" id="cp" name="tipologia" value="CP">
                    <label for="cp">Consumazione sul posto</label>
                </span>
            </div>
            <div id="indirizzo">
                <label for="via">Via:</label>
                <input type="text" name="via" id="via">
                <label for="via">Città:</label>
                <input type="text" name="citta" id="citta">
                <label for="via">CAP:</label>
                <input type="text" name="cap" id="cap">
            </div>
            <div>
                <p>Totale: <span id="totale">${ordine.totale}</span>&#8364;</p>
                <p>Costo di spedizione:<span id="spedizione">0.00</span>&#8364;</p>
                <p>Data Pagamento: ${ordine.dataPagamento}</p>
            </div>
            <div>
                <label>Seleziona il tipo di pagamento:</label>
                <span>
                    <input type="radio" id="contanti" name="tipoPagamento" value="Contanti" checked>
                    <label for="contanti">Contanti</label>
                </span>
                <span>
                    <input type="radio" id="carta" name="tipoPagamento" value="Carta di credito">
                    <label for="carta">Carta di credito</label>
                </span>
                <span>
                    <input type="radio" id="paypal" name="tipoPagamento" value="PayPal">
                    <label for="paypal">PayPal</label>
                </span>
            </div>
            <div>
                <input type="text" name="numeroCarta" id="numeroCarta" maxlength="27">
            </div>
            <div>
                <input type="submit" value="Conferma Ordine">
            </div>
        </form>
    </body>
</html>
