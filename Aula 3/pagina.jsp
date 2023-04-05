<%-- 
    Document   : pagina
    Created on : 5 de abr. de 2023, 11:35:14
    Author     : QI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Aula 3</title>
        <meta name="description" content="Aula 3 da disciplina de Java para Web">
        <meta name="keywords" content="web3, java, jsp, http, qi, professor dentinho">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="https://pt.seaicons.com/wp-content/uploads/2015/11/car-icon1.png">
    </head>
    <body>
        <h1>Exemplos de diretivas:</h1>
        <% out.println("Realizando cálculo com Java<br><hr>"); %>
        
        <%-- Diretiva "Declaration": serve para declarar
        variáveis e executar lógicas --%>
        <%!
            float x = 3.14f;
            float raio = 5f;
            float result = x * (raio * raio);
        %>
        
        <%-- Diretiva "Expression": serve para apresentar
        algum retorno à página --%>
        <%= result %>
    </body>
</html>
