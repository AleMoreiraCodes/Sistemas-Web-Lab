<%-- 
    Document   : menu
    Created on : 5 de out. de 2023, 21:52:38
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu JSP</title>
    </head>
    <body>
        <h1>Laboratório de Programação de Sistemas Web</h1>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="welcome">
            <button type="submit">Boas vindas</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="erroJava">
            <button type="submit">Erro Java</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="erroHtml">
            <button type="submit">Erro HTML</button>
        </form>
        <form action="Controller" method="post">
            <input type="hidden" name="operacao" value="sair">
            <button type="submit">Sair</button>
        </form>
    </body>
</html>
