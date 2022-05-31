<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nuovo Ordine</title>
</head>
<body>
    <form action="" method="post">
        <table>
            <tr>
                <td>
                    <label>Tipologia Ordine</label><br>
                    <input type="radio" id="asporto" nome="tipologiaOrdine" value="A"> 
                    <label for="asporto">Asporto</label><br>
                    <input type="radio" id="domicilio" nome="tipologiaOrdine" value="D"> 
                    <label for="domicilio">Domicilio</label><br>
                    <input type="radio" id="consumazioneSulPosto" nome="tipologiaOrdine" value="CP"> 
                    <label for="consumazioneSulPosto">Consumazione sul posto</label><br>
                </td>
                <td>

                </td>
                <td>
                    <label>Tipo Pagamento</label><br>
                    <input type="radio" id="contanti" nome="tipoPagamento" value="Contanti"> 
                    <label for="contanti">Contanti</label><br>
                    <input type="radio" id="cartaCredito" nome="tipoPagamento" value="Carta di credito"> 
                    <label for="cartaCredito">Carta di credito</label><br>
                    <input type="radio" id="paypal" nome="tipoPagamento" value="PayPal"> 
                    <label for="paypal">PayPal</label><br>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td>
                    <label>Sconto</label>
                </td>
                <td>
                    <label>Totale</label>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Conferma">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>