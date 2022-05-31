<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="LoginServlet" method="post">
    <label for="email">Email</label><br>            <!--admin@gmail.com-->
    <input type="email" id="email" name="email"><br>
    <label for="password">Password</label><br>      <!--admin-->
    <input type="password" id="password" name="password">
    <input type="submit" value="Conferma">
</form>
<!--in seguito da inserire in un allert js-->
<%
    String error = (String) request.getAttribute("error");
    if(error != null){
%>
    <%=error%>
<%}%>
</body>
</html>