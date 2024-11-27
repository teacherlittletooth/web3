<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.UsuarioDAO"%>
<%@include file="session/validar.jsp" %>

<%  
    UsuarioDAO dao = new UsuarioDAO();
    ArrayList<Usuario> list = dao.getAllUsers();
    SimpleDateFormat formatBd = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatBr = new SimpleDateFormat("dd/MM/yyyy");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> WEB III </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="icon" href="img/computador.png"/>
    </head>
    <body>
        <main class="container">
            <h1>Página inicial</h1>

            <a href="session/finalizar.jsp" class="btn btn-primary" id="btn-logout"> Sair </a>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th> Cod </th>
                        <th> Nome </th>
                        <th> Email </th>
                        <th> Nascimento </th>
                        <th> Notícias </th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Usuario u : list) {%>
                    <tr>
                        <td> <%= u.getId()%> </td>
                        <td> <%= u.getNome()%> </td>
                        <td> <%= u.getEmail()%> </td>
                        <td> <%= formatBr.format(formatBd.parse(u.getNascimento()))%> </td>
                        <td> <%= u.isNoticias() ? "Sim" : "Não"%> </td>
                        <td>
                            <a onclick="excluir(<%= u.getId()%>, '<%= u.getNome()%>')" title="Excluir <%= u.getNome()%>" > 🗑️ </a> 
                        </td>
                        <td>
                            <a href="usuario-controller?pagina=editar&id=<%= u.getId()%>" title="Atualizar <%= u.getNome()%>" > ️✏️ </a> 
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </main>

        <script>
            function excluir(id, nome) {
                if (confirm("Deseja excluir o usuário " + nome + "?")) {
                    window.location.href = "usuario-controller?pagina=excluir&id=" + id;
                } else {
                    alert("Exclusão cancelada!");
                }
            }
        </script>

    </body>
</html>
