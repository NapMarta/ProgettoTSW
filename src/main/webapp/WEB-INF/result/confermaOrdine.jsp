<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Conferma Ordine</title>
        <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
    </head>
    <body>
        <form method="post" action="">
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
            <div>
                Totale: ${ordine.totale}
                Data Pagamento: ${ordine.dataPagamento}
            </div>
            <div>
                <label>Seleziona il tipo di pagamento:</label>
                <span>
                    <input type="radio" id="contanti" name="tipoPagamento" value="Contanti"
                           checked>
                    <label for="contanti">Asporto</label>
                </span>
                <span>
                    <input type="radio" id="carta" name="tipoPagamento" value="Carta di credito">
                    <label for="carta">Domicilio</label>
                </span>
                <span>
                    <input type="radio" id="paypal" name="tipoPagamento" value="PayPal">
                    <label for="paypal">Consumazione sul posto</label>
                </span>
            </div>
            <div>
                <input type="text" name="numeroCarta" maxlength="27">
            </div>
            <div>
                <input type="submit" value="Conferma Ordine">
            </div>
        </form>
    </body>
</html>
