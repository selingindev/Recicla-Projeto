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
    String erro = null;

    try {
        if (idStr == null || idStr.trim().isEmpty()) {
            throw new Exception("ID não informado.");
        }
        int id = Integer.parseInt(idStr.trim());
        ControllerPontoColeta ctrl = new ControllerPontoColeta();
        p = (PontoColeta) ctrl.buscar(id);
        if (p == null) {
            throw new Exception("Registro não encontrado.");
        }
    } catch (NumberFormatException nfe) {
        erro = "ID inválido (não numérico).";
    } catch (Exception e) {
        erro = e.getMessage();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Alterar Ponto de Coleta</title>
</head>
    <body>
        <div class="container">
            <h4>Alterar Ponto de Coleta</h4>

            <% if (erro != null) { %>
                <div class="red-text"><%= erro %></div>
                <a class="btn" href="consultarPontoColeta.jsp">Voltar</a>
            <% } else { %>
                <form action="validaAlterarPontoColeta.jsp" method="post">
                    <div class="row">
                        <div class="input-field col s2">
                            <input type="number" name="id" id="id" value="<%= p.getId() %>" readonly>
                            <label for="id" class="active">ID</label>
                        </div>
                        <div class="input-field col s3">
                            <input type="number" name="idLog" id="idLog" value="<%= p.getIdLog() %>" required>
                            <label for="idLog" class="active">ID Logradouro*</label>
                        </div>
                        <div class="input-field col s4">
                            <input type="text" name="nome" id="nome" value="<%= p.getNome() %>" maxlength="100" required>
                            <label for="nome" class="active">Nome do Ponto*</label>
                        </div>
                        <div class="input-field col s3">
                            <input type="text" name="qrCode" id="qrCode" value="<%= p.getQrCode() %>" maxlength="100" required>
                            <label for="qrCode" class="active">QR Code*</label>
                        </div>
                    </div>
                    <button type="submit" class="btn">Salvar</button>
                    <a href="consultarPontoColeta.jsp" class="btn-flat">Voltar</a>
                </form>
            <% } %>
        </div>
    </body>
</html>
