<%-- 
    Document   : parametros
    Created on : 30 de ago. de 2025, 15:53:28
    Author     : raife
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Parametro"%>
<%@page import="reciclabackend.controller.ControllerParametro"%>
<%@page import="java.util.List"%>

<%
    ControllerParametro sisCont = new ControllerParametro();
    List<Object> parametros = sisCont.listar();
%>

<!DOCTYPE html>
<html>
    <title>Listar - Parametro</title>
    <head><!-- head -->
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 10px;
                text-align: center;
                border: 2px solid black;
            }
            .btn {
                display: inline-block;
                padding: 10px 20px;
                margin: 10px 0;
                background-color: #007bff; /* Cor de fundo do botão */
                color: white; /* Cor do texto */
                text-align: center;
                text-decoration: none; /* Remove o sublinhado */
                border-radius: 5px; /* Bordas arredondadas */
                font-size: 16px;
            }
            .deletar {
                color: red; /* Cor de fundo do botão */
            }
        </style>
        <script type="text/javascript">
            function confirmarExclusao(url, codigo) {
                // Exibe a caixa de diálogo de confirmação
                if (confirm("Tem certeza que deseja excluir o item " + codigo + "?")) {
                    // Se o usuário confirmar, redireciona para a URL de exclusão
                    window.location.href = url;
                }
            }
        </script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    </head>
    <body>
       <div class="container"/>
       <h1>Listar Parametro</h1>
       <a href="inserirParametro.jsp" class="btn"> Inserir </a><!-- Inserir Parametro -->
        <div>
            
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Percorrendo a lista de parâmetros e exibindo os dados na tabela
                        for (Object obj : parametros) {
                            Parametro parametro = (Parametro) obj;
                    %>
                        <tr>
                            <td><%= parametro.getCod() %></td>  <!-- Exibe o ID do parâmetro -->
                            <td><%= parametro.getDescricao() %></td>  <!-- Exibe o nome do parâmetro -->
                            <td>
                                <a href="alterarParametro.jsp?id=<%= parametro.getId() %>">
                                    <i class="fa-solid fa-pen-to-square"></i>
                                </a> |
                                <a href="javascript:void(0);" onclick="confirmarExclusao('excluirParametro.jsp?id=<%= parametro.getId() %>', <%= parametro.getCod() %>)">
                                    <i class="fa fa-trash deletar"></i>
                                </a>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
    </body>
</html>
