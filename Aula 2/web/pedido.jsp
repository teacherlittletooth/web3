<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
    </head>
    <body>
        <h1>Dados do pedido:</h1>
        <h3> <%= request.getAttribute("prod") %> </h3>
        <h3> R$ <%= request.getAttribute("valor") %> </h3>
        <h3> <%= request.getAttribute("quant") %> </h3>
        <h3> R$ <%= request.getAttribute("sub") %> </h3>
    </body>
</html>
