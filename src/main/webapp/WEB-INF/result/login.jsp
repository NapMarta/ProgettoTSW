<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="css/c.css" rel="stylesheet">
</head>
<body>
    <div class="parent">
        <p class="titolo">Login</p>
        <form action="LoginServlet" method="post" class="child">
            <label for="email">Email</label><br>            <!--admin@gmail.com-->
            <input type="email" id="email" name="email" placeholder="Email"><br>
            <label for="password">Password</label><br>      <!--admin-->
            <input type="password" id="password" name="password" placeholder="Password"><br><br>
            <input type="submit" value="Accedi" name="accedi" id="accedi"><br><br>
            <input type="submit" value="Sei un nuovo utente? Registrati" name="registrati" id="registrati">
        </form>
    </div>

</body>
</html>