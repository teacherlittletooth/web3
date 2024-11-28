<%@page import="model.Tarefa"%>
<%@include file="session/validar.jsp" %>
<%
    Tarefa t = (Tarefa)request.getAttribute("task");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> WEB III </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="icon" href="img/logotipo.png"/>
    </head>
    <body>

        <div class="mt-4 text-center container col-sm-10 col-md-6">
            <h1> Editar tarefa </h1>

            <form action="tarefa-controller" method="post" class="validar" novalidate onsubmit="return confirm('Deseja atualizar a tarefa?')">

                <input type="hidden" name="pagina" value="atualizar">
                <input type="hidden" name="id" value="<%= t.getId() %>">

                <div class="form-floating mt-3">
                    <input type="text" id="titulo" name="titulo" value="<%= t.getTitulo() %>" class="form-control" placeholder="Título da tarefa" required>
                    <label for="nome"> Título da tarefa </label>

                    <small class="invalid-feedback text-start">
                        Este campo é obrigatório.
                    </small>
                </div>

                <div class="form-floating mt-3">
                    <textarea id="descricao" name="descricao" class="form-control" placeholder="Descrição da tarefa"><%= t.getDescricao() %></textarea>
                    <label for="descricao"> Descrição </label>
                </div>

                <div class="mt-4 text-start">
                    <label>Status da tarefa</label>
                    <hr>
                    <div class="form-check">
                        <label for="a-fazer" class="form-check-label"> A fazer </label>
                        <input type="radio" id="a-fazer" name="status" value="A fazer" class="form-check-input"
                               <%= t.getStatusTarefa().equals("A fazer") ? "checked" : "" %>
                         >
                    </div>

                    <div class="form-check">
                        <label for="em-andamento" class="form-check-label"> Em andamento </label>
                        <input type="radio" id="em-andamento" name="status" value="Em andamento" class="form-check-input"
                                <%= t.getStatusTarefa().equals("Em andamento") ? "checked" : "" %>       
                        >
                    </div>

                    <div class="form-check">
                        <label for="concluido" class="form-check-label"> Concluído </label>
                        <input type="radio" id="concluido" name="status" value="Concluído" class="form-check-input"
                               <%= t.getStatusTarefa().equals("Concluído") ? "checked" : "" %>
                        >
                    </div>
                </div>

                <hr>

                <div class="d-grid mt-4">
                    <input type="submit" value="Atualizar" class="btn btn-success">
                    <input type="reset" value="Restaurar dados" class="btn btn-outline-danger mt-3">
                </div>

            </form>

        </div>


        <script src="js/bootstrap.min.js"></script>

        <script>
                        const campoData = document.getElementById("nasc");
                        const campoSenha = document.getElementById("senha");
                        const campoConfSenha = document.getElementById("confere-senha");
                        const minimo = document.getElementById("minimo");
                        const maiuscula = document.getElementById("maiuscula");
                        const especial = document.getElementById("especial");
                        const numero = document.getElementById("numero");

                        function validarSenha() {
                            campoConfSenha.minLength = campoSenha.value.length;

                            if (campoSenha.value === campoConfSenha.value) {
                                campoConfSenha.classList.add("is-valid");
                            } else {
                                campoConfSenha.minLength = 10000;
                            }

                            (campoSenha.value.length >= 6) ? minimo.style.color = "green" : minimo.style.color = "red";
                            (/[A-Z]/.test(campoSenha.value)) ? maiuscula.style.color = "green" : maiuscula.style.color = "red";
                            (/[^\w\s]/.test(campoSenha.value)) ? especial.style.color = "green" : especial.style.color = "red";
                            (/[\d]/.test(campoSenha.value)) ? numero.style.color = "green" : numero.style.color = "red";

                        }

                        function pegarData() {
                            let hoje = new Date();
                            let dataFormatada = (hoje.getFullYear() - 12) +
                                    "-" +
                                    ((hoje.getMonth() + 1 < 10) ?
                                            "0" + hoje.getMonth() + 1 :
                                            hoje.getMonth() + 1) +
                                    "-" +
                                    ((hoje.getDate() < 10) ?
                                            "0" + hoje.getDate() :
                                            hoje.getDate());

                            campoData.max = dataFormatada;
                        }

                        document.addEventListener("load", pegarData());
        </script>

        <script src="js/init-validation.js"></script>

    </body>
</html>
