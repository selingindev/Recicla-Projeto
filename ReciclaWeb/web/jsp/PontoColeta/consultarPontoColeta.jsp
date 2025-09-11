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
    <head><title>Consultar Pontos de Coleta</title></head>
    <body>
        <div class="container">
            <h4>Consultar Pontos de Coleta</h4>

            <%
                String filtro = request.getParameter("filtro");
                if (filtro == null) filtro = "";
            %>

            <form action="validaConsultarPontoColeta.jsp" method="get">
                <div class="row">
                    <div class="input-field col s8">
                        <input type="text" name="filtro" id="filtro" placeholder="Nome, QR Code, etc." maxlength="100">
                        <label for="filtro">Filtro</label>
                    </div>
                    <div class="input-field col s4">
                        <button type="submit" class="btn waves-effect">Buscar</button>
                        <a href="inserirPontoColeta.jsp" class="btn-flat">Novo</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
