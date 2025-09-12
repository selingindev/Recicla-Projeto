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
    // Proteção de sessão 
    request.setCharacterEncoding("UTF-8");
    Object _usu = session.getAttribute("UsuarioLogado");
    if (_usu == null) {
        response.sendRedirect("../../jsp/contacess/login.jsp");
        return;
    }

    // Parâmetros
    String idStr    = request.getParameter("id");
    String idLogStr = request.getParameter("idLog");
    String nome     = request.getParameter("nome");
    String qrCode   = request.getParameter("qrCode");

    String msg;

    try {
        // Validação básica
        if (idStr == null || idStr.trim().isEmpty())   throw new Exception("ID é obrigatório.");
        if (idLogStr == null || idLogStr.trim().isEmpty()) throw new Exception("ID Logradouro é obrigatório.");
        if (nome == null || nome.trim().isEmpty())     throw new Exception("Nome é obrigatório.");
        if (qrCode == null || qrCode.trim().isEmpty()) throw new Exception("QR Code é obrigatório.");

        int id    = Integer.parseInt(idStr.trim());
        int idLog = Integer.parseInt(idLogStr.trim());

        // Alteração
        PontoColeta pc = new PontoColeta(id, idLog, nome.trim(), qrCode.trim());
        ControllerPontoColeta ctrl = new ControllerPontoColeta();
        ctrl.alterar(pc);

        msg = "Ponto de Coleta alterado com sucesso.";
    } catch (NumberFormatException nfe) {
        msg = "ID ou ID Logradouro inválido (não numérico).";
    } catch (Exception e) {
        msg = "Erro ao alterar: " + e.getMessage();
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Resultado - Alterar Ponto de Coleta</title>
    </head>
    <body>
        <div class="container">
            <h5><%= msg %></h5>
            <a class="btn" href="consultarPontoColeta.jsp">Voltar para Consulta</a>
        </div>
    </body>
</html>