<%-- 
    Document   : listarPontoReciclagem
    Description: Página para listar, consultar, alterar e excluir Pontos de Reciclagem.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    // Instancia o controller para buscar os dados
    ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
    
    // Chama o método listar para obter todos os pontos de reciclagem
    // O filtro vazio "" significa que queremos todos os registros
    List<Object> pontos = controller.listar("");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Pontos de Reciclagem</title>
        <style>
            /* Estilos básicos para a tabela, para melhor visualização */
            body { font-family: sans-serif; }
            .container { width: 80%; margin: 0 auto; }
            table { width: 100%; border-collapse: collapse; margin-top: 20px; }
            th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }
            th { background-color: #f2f2f2; }
            tr:nth-child(even) { background-color: #f9f9f9; }
            a { text-decoration: none; color: #007bff; }
            .btn-inserir {
                display: inline-block;
                padding: 10px 15px;
                background-color: #28a745;
                color: white;
                border-radius: 5px;
                text-align: center;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Pontos de Reciclagem</h1>

            <a href="inserirPontoReciclagem.jsp" class="btn-inserir">Inserir Novo Ponto</a>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Ponto</th>
                        <th>ID da Empresa (PEJ)</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Laço de repetição para percorrer a lista de pontos --%>
                    <% for (Object obj : pontos) {
                        // Converte o Object para PontoReciclagem
                        PontoReciclagem ponto = (PontoReciclagem) obj;
                    %>
                    <tr>
                        <td><%= ponto.getId() %></td>
                        <td><%= ponto.getNome() %></td>
                        <td><%= ponto.getIdPEJ() %></td>
                        <td>
                            <%-- Link para a página de alteração, passando o ID do ponto --%>
                            <a href="alterarPontoReciclagem.jsp?id=<%= ponto.getId() %>">Alterar</a>
                            &nbsp;|&nbsp;
                            <%-- Link para a página de exclusão, passando o ID do ponto --%>
                            <a href="excluirPontoReciclagem.jsp?id=<%= ponto.getId() %>">Excluir</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
