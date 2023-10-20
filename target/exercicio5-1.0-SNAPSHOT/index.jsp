<%-- 
    Document   : index.jsp
    Created on : 26 de set. de 2023, 12:41:27
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn</title>
    </head>
    <body>
        <h1>Atividade 5</h1>
        <form name="firstname" method="Post" action="Controller">
            <input type="text" name="username" placeholder="usuario"><br>
            <input type="password" name="password"  placeholder="senha"><br>
            <input type="hidden" name="operacao" value="login">
            <button type="submit">LogIn</button>
            <% String message = (String) request.getSession().getAttribute("message");
            if ( message != null ) {
            %> 
            <h2><%= message %></h2>
            <%}%>
        </form>
    </body>
</html>
