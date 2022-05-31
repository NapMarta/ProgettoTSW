<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione Utente</title>
</head>
<body>
    <form action="" method="post">
        <table>
            <tr>
                <td>
                    <label for="nomeUtente">Nome</label>
                    <input type="text" id="nomeUtente" name="nomeUtente">
                </td>
                <td>
                    <label for="cognomeUtente">Cognome</label>
                    <input type="text" id="cognomeUtente" name="cognomeUtente">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="emailUtente">Email</label>
                    <input type="email" id="emailUtente" name="emailUtente">
                </td>
                <td>
                    <label for="passwordUtente">Password</label>
                    <input type="password" id="passwordUtente" name="passwordUtente">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Conferma Dati">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>