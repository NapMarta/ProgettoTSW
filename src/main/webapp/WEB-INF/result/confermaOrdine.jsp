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
    <div class="parent">
        <p class="titolo">Conferma Ordine</p><hr>
        <form method="post" action="EffettuaOrdine">
            <div>
                <label>Seleziona il tipo di ordine:</label>
                <span>
                    <input type="radio" id="asporto" name="tipologia" value="A"
                           checked>
                    <label for="asporto">Asporto</label><br>
                </span>
                    <span>
                    <input type="radio" id="domicilio" name="tipologia" value="D">
                    <label for="domicilio">Domicilio</label><br>
                </span>
                    <span>
                    <input type="radio" id="cp" name="tipologia" value="CP">
                    <label for="cp">Consumazione sul posto</label><br><br>
                </span>
            </div>
            <div id="indirizzo">
                <label for="via">Via:</label>
                <input type="text" name="via" id="via"><br>
                <label for="via">Città:</label>
                <input type="text" name="citta" id="citta"><br>
                <label for="via">CAP:</label>
                <input type="text" name="cap" id="cap"><br>
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
                    <label for="contanti">Contanti</label><br>
                </span>
                <span>
                    <input type="radio" id="carta" name="tipoPagamento" value="Carta di credito">
                    <label for="carta">Carta di credito</label><br>
                </span>
                <span>
                    <input type="radio" id="paypal" name="tipoPagamento" value="PayPal">
                    <label for="paypal">PayPal</label><br><br>
                </span>
            </div>
            <div>
                <input type="text" name="numeroCarta" id="numeroCarta" maxlength="27"><br>
            </div>
            <div>
                <input type="submit" value="Conferma Ordine">
            </div>
        </form>
        <form action="Ordini">
            <button type="submit" value="Home" name="home" id="home">
                <img src="https://img.icons8.com/material-rounded/30/000000/home.png"/>
            </button>
        </form>
    </div>
    </body>
</html>
