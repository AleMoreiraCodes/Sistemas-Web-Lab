<%-- 
    Document   : welcome
    Created on : 5 de out. de 2023, 21:56:19
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Conteúdos vistos</h1>
        <ol>
            <li>Servlet</li>
            <li>Controle de Sessão</li>
            <li>JSP</li>
            <li>Banco de dados</li>
            <li>MVC</li>
        </ol>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="menu">
            <button type="submit">Menu</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="sair">
            <button type="submit">Sair</button>
        </form>
    </body>
</html>
