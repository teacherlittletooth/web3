<%-- 
    Document   : pagina
    Created on : 5 de abr. de 2023, 21:24:05
    Author     : QI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cafézes</title>
        <meta name="description" content="Blog sobre esportes, culinária e música">
        <meta name="keywords" content="esporte, culinária, música, html, java">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="https://cdn-icons-png.flaticon.com/128/544/544338.png">
    </head>
    
    <body>
        <h1>Exemplos do uso de JSP</h1>
        <%-- Uso geral --%>
        <%
            //Aqui estamos escrevendo código JAVA
            String x = "<h3>Hello ";
            String y = "JSP!</h3>";
            out.print(x + y);
        %>
        
        <%-- Declaração --%>
        <%!
            float pi = 3.1415f;
            float raio = 4f;
            float result = pi * (raio * raio);
        %>
        
        <%-- Expressão --%>
        <%= "<hr>" + result + "<p>Resultado</p>" %>
        
    </body>
</html>
