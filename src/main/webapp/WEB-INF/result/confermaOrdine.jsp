<%@ page import="model.beans.Ordine" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage = "/error.jsp" %>
<html>
    <head>
        <title>Conferma Ordine</title>
        <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
        <link href="css/confermaOrdine.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="JavaScript/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="JavaScript/confermaOrdine.js"></script>
        <script type="text/javascript" src="JavaScript/validazioniForm/validazioneOrdine.js"></script>
    </head>
    <body>
    <div class="parent">
        <p class="titolo">Conferma Ordine</p><hr>
        <form method="post" name="ordine" onsubmit="return validateO();" action="EffettuaOrdine">
            <div>
                <label>Seleziona il tipo di ordine:</label><br>
                <span>
                    <input type="radio" id="asporto" name="tipologia" value="A"
                           checked>
                    <label for="asporto">Asporto</label><br>
                </span>
                <span>
                    <input type="radio" id="domicilio" name="tipologia" value="D">
                    <label for="domicilio">Domicilio</label><br>
                        <span id="indirizzo">
                            <label for="via">Via: </label> <input type="text" name="via" id="via" class="dom"
                                                                  title="Inserire nel formato: Via,Numero civico"><br>
                            <label for="citta">Città:</label><input type="text" name="citta" id="citta" class="dom"><br>
                            <label for="cap">CAP:</label><input type="text" name="cap" id="cap" class="dom"><br>
                        </span>
                </span>
                <span>
                    <input type="radio" id="cp" name="tipologia" value="CP">
                    <label for="cp">Consumazione sul posto</label>
                </span>
            </div>
            <div>
                <p>Costo di spedizione:<span id="spedizione">0.00</span>&#8364;</p>
                <p>Totale: <span id="totale" name="totale">${ordine.totale}</span>&#8364;</p>
                <p>Data Pagamento: <span name="data" id="data">${ordine.dataPagamento}</span></p>
            </div>
            <div>
                <label>Seleziona il tipo di pagamento:</label><br>
                <span>
                    <input type="radio" id="contanti" name="tipoPagamento" value="Contanti" checked>
                    <label for="contanti">Contanti</label><br>
                </span>
                <span>
                    <input type="radio" id="carta" name="tipoPagamento" value="Carta di credito">
                    <label for="carta">Carta di credito</label>
                    <span>
                        <input type="text" name="numeroCarta" id="numeroCarta" maxlength="16"
                        title="Inserire il numero della carta(16 cifre)">
                    </span><br>
                </span>
                <span>
                    <input type="radio" id="paypal" name="tipoPagamento" value="PayPal">
                    <label for="paypal">PayPal</label><br><br>
                </span>
            </div>

            <div>
                <input type="submit" name="concludiOrdine" value="Concludi Ordine">
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
