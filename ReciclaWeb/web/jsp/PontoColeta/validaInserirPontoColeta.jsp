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

    // Captura de parâmetros
    String idLogStr = request.getParameter("idLog");
    String nome     = request.getParameter("nome");
    String qrCode   = request.getParameter("qrCode");

    String msg;

    try {
        // Validação básica dos campos obrigatórios
        if (idLogStr == null || idLogStr.trim().isEmpty()) {
            throw new Exception("ID Logradouro é obrigatório.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome é obrigatório.");
        }
        if (qrCode == null || qrCode.trim().isEmpty()) {
            throw new Exception("QR Code é obrigatório.");
        }

        int idLog = Integer.parseInt(idLogStr);

        // Inserção
        PontoColeta pc = new PontoColeta(0, idLog, nome.trim(), qrCode.trim());
        ControllerPontoColeta ctrl = new ControllerPontoColeta();
        ctrl.inserir(pc);

        msg = "Ponto de Coleta inserido com sucesso.";
    } catch (NumberFormatException nfe) {
        msg = "ID Logradouro inválido (não numérico).";
    } catch (Exception e) {
        msg = "Erro ao inserir: " + e.getMessage();
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Resultado - Inserir Ponto de Coleta</title>
    </head>
    <body>
        <div class="container">
            <h5><%= msg %></h5>
            <a class="btn" href="inserirPontoColeta.jsp">Novo</a>
            <a class="btn-flat" href="consultarPontoColeta.jsp">Consultar</a>
        </div>
    </body>
</html>