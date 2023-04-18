<%-- 
    Document   : inicio
    Created on : 18 de abr. de 2023, 11:14:45
    Author     : QI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
    </head>
    <body>
        <h1>Seja bem vindo <%= request.getAttribute("nomeDoVivente") %>!</h1>
    </body>
</html>
