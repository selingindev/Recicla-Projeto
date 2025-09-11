<%-- 
    Document   : pontoColeta
    Created on : 09 de set. de 2025
    Author     : ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoColeta"%>
<%@page import="reciclabackend.controller.ControllerPontoColeta"%>
<%@include file="../../inc/materalizeWeb.inc" %>

<%
    request.setCharacterEncoding("UTF-8");
    Object _usu = session.getAttribute("UsuarioLogado");
    if (_usu == null) {
        response.sendRedirect("../../jsp/contacess/login.jsp");
        return;
    }

    String idStr = request.getParameter("id");
    PontoColeta p = null;
    String msg = null;
    boolean confirmado = "POST".equalsIgnoreCase(request.getMethod());

    if (!confirmado) {
        // Primeira vez: mostrar dados
        try {
            if (idStr == null) throw new Exception("ID não informado.");
            int id = Integer.parseInt(idStr);
            ControllerPontoColeta ctrl = new ControllerPontoColeta();
            p = (PontoColeta) ctrl.buscar(id);
            if (p == null) throw new Exception("Registro não encontrado.");
        } catch (Exception e) {
            msg = "Erro: " + e.getMessage();
        }
    } else {
        // Se o form já foi enviado (POST), excluir direto
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ControllerPontoColeta ctrl = new ControllerPontoColeta();
            boolean ok = ctrl.excluir(id);
            msg = ok ? "Ponto de Coleta excluído com sucesso." : "Não foi possível excluir.";
        } catch (Exception e) {
            msg = "Erro ao excluir: " + e.getMessage();
        }
    }
%>

<!DOCTYPE html>
<html>
    <head><title>Excluir Ponto de Coleta</title></head>
    <body>
        <div class="container">
            <h4>Excluir Ponto de Coleta</h4>

            <% if (msg != null && confirmado) { %>
                <h5><%= msg %></h5>
                <a href="consultarPontoColeta.jsp" class="btn">Voltar</a>

            <% } else if (msg != null) { %>
                <div class="red-text"><%= msg %></div>
                <a href="consultarPontoColeta.jsp" class="btn">Voltar</a>

            <% } else { %>
                <p>Confirma a exclusão do registro abaixo?</p>
                <ul class="collection">
                    <li class="collection-item">ID: <strong><%= p.getId() %></strong></li>
                    <li class="collection-item">ID Logradouro: <strong><%= p.getIdLog() %></strong></li>
                    <li class="collection-item">Nome: <strong><%= p.getNome() %></strong></li>
                    <li class="collection-item">QR Code: <strong><%= p.getQrCode() %></strong></li>
                </ul>

                <form action="excluirPontoColeta.jsp" method="post">
                    <input type="hidden" name="id" value="<%= p.getId() %>"/>
                    <button type="submit" class="btn red">Confirmar Exclusão</button>
                    <a href="consultarPontoColeta.jsp" class="btn-flat">Cancelar</a>
                </form>
            <% } %>
        </div>
    </body>
</html>
