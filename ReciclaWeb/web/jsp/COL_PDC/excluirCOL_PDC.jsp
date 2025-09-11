<%-- 
    Document   : excluirColPdc
    Created on : 10 de set. de 2025
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.controller.ControllerColPdc"%>

<%
    String idStr = request.getParameter("ID");
    String mensagem = "";

    if (idStr != null && !idStr.trim().isEmpty()) {
        try {
            int id = Integer.parseInt(idStr);
            ControllerColPdc controller = new ControllerColPdc();
            boolean sucesso = controller.excluir(id);

            if (sucesso) {
                mensagem = "ColPdc excluído com sucesso!";
            } else {
                mensagem = "Não foi possível excluir o ColPdc com ID = " + id;
            }
        } catch (Exception e) {
            mensagem = "Erro ao excluir ColPdc: " + e.getMessage();
        }
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>EXCLUIR - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Excluir ColPdc</h1>

            <form method="post">
                <label for="id">ID do Col_Pdc:</label>
                <input type="text" id="id" name="ID" required>
                <br>
                <button class="btn waves-effect waves-light" type="submit">Excluir</button>
            </form>

            <% if (!mensagem.isEmpty()) { %>
                <p><%= mensagem %></p>
            <% } %>
        </div>
    </body>
</html>
