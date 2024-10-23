<%-- Comentário JSP --%>

<%
  String[] produtos = {
    "Banana",
    "Maçã",
    "Pera",
    "Uva",
    "Mamão",
    "Bergamota",
    "Melancia",
    "Abacate",
    "Laranja"
  };
  
  double[] precos = {
     5.89,
     4.78,
     5.79,
     8.49,
     9.59,
     3.99,
     15.00,
     6.48,
     2.49
  };
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Produtos </title>
    </head>
    <body>
        <h1> Lista de produtos </h1>
        <p> Confira a nossa lista de produtos! </p>
        
        <table border="1">
            <thead>
                <tr>
                    <th> Produto </th>
                    <th> Preço </th>
                </tr>
            </thead>
            <tbody>
                <% for(int i=0; i < produtos.length; i++) { %>
                <tr>
                    <td> <%= produtos[i] %> </td>
                    <td> R$ <%= String.format("%.2f", precos[i]) %> </td>
                </tr>
                <% } %>
            </tbody>
        </table>

        
        <hr>
        <a href="index.html"> Voltar ◀️ </a>
    </body>
</html>
