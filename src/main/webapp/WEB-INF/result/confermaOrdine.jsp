<%@ page import="model.beans.Ordine" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Conferma Ordine</title>
        <link rel="icon" type="image/jpeg" href="logo.jpeg"/>
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
            <div>
                <p>Totale: ${ordine.totale} </p>
                <p>Costo di spedizione:</p>
<%--                <%--%>
<%--                Ordine ordine = (Ordine) session.getAttribute("ordine");--%>
<%--                if(ordine.getTipologia().equals("D") && ordine.getTotale() < 20){--%>
<%--                %>--%>
<%--                    <span>3.00 &#8364;</span>--%>
<%--                <% }else{%>--%>
<%--                    <span>0.00 &#8364;</span>--%>
<%--                <%}%>--%>

                <p>Data Pagamento: ${ordine.dataPagamento}</p>
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
