<%-- 
    Document   : validaInserirColPdc
    Created on : 10 de set. de 2025
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.ColPdc"%>
<%@page import="reciclabackend.controller.ControllerColPdc"%>

<%
    String idColStr = request.getParameter("IDCOL");
    String idPdcStr = request.getParameter("IDPDC");
    String data = request.getParameter("DATA");

    String mensagem = "";

    try {
        int idCol = Integer.parseInt(idColStr);
        int idPdc = Integer.parseInt(idPdcStr);

        ColPdc colPdc = new ColPdc(idCol, idPdc, data);
        ControllerColPdc controller = new ControllerColPdc();
        ColPdc colPdcInserido = (ColPdc) controller.inserir(colPdc);

        mensagem = "ColPdc inserido com sucesso: " + colPdcInserido.toString();
    } catch (Exception e) {
        mensagem = "Erro ao inserir ColPdc: " + e.getMessage();
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>VALIDAR INSERÇÃO - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Resultado da Inserção</h1>
            <p><%= mensagem %></p>

            <a class="btn waves-effect waves-light" href="inserirColPdc.jsp">Voltar</a>
        </div>
    </body>
</html>
