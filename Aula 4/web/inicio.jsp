<%
  String nome = "";
  boolean logged = false;
  if(request.getSession().getAttribute("qi") != null ) {
    nome = (String)request.getSession().getAttribute("qi");
    logged = true;
  } 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Controle de sessão </title>
    </head>
    <body>
        <% if(logged) { %>
        
        <h1> Bem vindo(a) <%= nome %> ! </h1>
        <a href="destroy-session"> Destruir sessão </a>
        
        <% } else { %>
            
        <h1>Acesso negado! Precisa fazer login.</h1> 
        <meta http-equiv="refresh" content="3; url=index.html">
             
        <% } %>
    </body>
</html>
