<%-- 
    Document   : validaAlterarColPdc
    Created on : 10 de set. de 2025
    Author     : Felipe
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page import="reciclabackend.controller.ControllerColPdc" %>

<%
    String idStr = request.getParameter("ID");
    String idColStr = request.getParameter("IDCOL");
    String idPdcStr = request.getParameter("IDPDC");
    String data = request.getParameter("DATA");
    String pbusca = request.getParameter("PBUSCA");

    String mensagem = "";

    try {
        int id = idStr != null && !idStr.trim().isEmpty() ? Integer.parseInt(idStr) : 0;
        int idCol = idColStr != null && !idColStr.trim().isEmpty() ? Integer.parseInt(idColStr) : 0;
        int idPdc = idPdcStr != null && !idPdcStr.trim().isEmpty() ? Integer.parseInt(idPdcStr) : 0;

        ColPdc colPdc = new ColPdc(id, idCol, idPdc, data);
        ControllerColPdc controller = new ControllerColPdc();
        ColPdc colPdcAlterado = (ColPdc) controller.alterar(colPdc);

        mensagem = "ColPdc alterado com sucesso: " + colPdcAlterado.toString();
    } catch (Exception e) {
        mensagem = "Erro ao alterar ColPdc: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html>
    <%@ include file="../../inc/materalizeWeb.inc" %>
    <head>
        <meta charset="UTF-8">
        <title>VALIDAR ALTERAÇÃO - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Resultado da Alteração</h1>
            <p><%= mensagem %></p>
            <a class="btn waves-effect waves-light" href="alterarColPdc.jsp?PBUSCA=<%= (pbusca != null ? pbusca : "") %>">Voltar</a>
        </div>
    </body>
</html>
