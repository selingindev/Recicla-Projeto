<%-- 
    Document   : pontoColeta
    Created on : 09 de set. de 2025
    Author     : ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
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
%>


<!DOCTYPE html>
<html>
    <head>
        <title>Inserir Ponto de Coleta</title>
    </head>
    <body>
        <div class="container">
            <h4>Inserir Ponto de Coleta</h4>
            <form action="validaInserirPontoColeta.jsp" method="post" class="col s12">
                <div class="row">
                    <div class="input-field col s3">
                        <input type="number" name="idLog" id="idLog" required>
                        <label for="idLog">ID Logradouro:</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="nome" id="nome" required maxlength="100">
                        <label for="nome">Nome do Ponto:</label>
                    </div>
                    <div class="input-field col s3">
                        <input type="text" name="qrCode" id="qrCode" required maxlength="100">
                        <label for="qrCode">QR Code:</label>
                    </div>
                </div>
                <button type="submit" class="btn waves-effect waves-light">Salvar</button>
                <a href="consultarPontoColeta.jsp" class="btn-flat">Consultar</a>
            </form>
        </div>
    </body>
</html>
