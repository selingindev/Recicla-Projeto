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
    // Guard de sessão (não mexe em login/menu)
    request.setCharacterEncoding("UTF-8");
    Object _usu = session.getAttribute("UsuarioLogado");
    if (_usu == null) {
        response.sendRedirect("../../jsp/contacess/login.jsp");
        return;
    }

    // --- Consulta (DECLARE APENAS UMA VEZ) ---
    String filtro = request.getParameter("filtro");
    if (filtro == null) filtro = "";
    ControllerPontoColeta ctrl = new ControllerPontoColeta();
    List lista = new ArrayList();
    String erro = null;
    try {
        lista = ctrl.listar(filtro);
    } catch (Exception e) {
        erro = e.getMessage();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Resultado - Consulta</title>
</head>
<body>
<div class="container">
    <h5>Resultado da Consulta</h5>

    <% if (erro != null) { %>
      <div class="container red-text">Erro: <%= erro %></div>
    <% } %>

    <table class="striped responsive-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>ID Logradouro</th>
                <th>Nome</th>
                <th>QR Code</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Object o : lista) {
                PontoColeta p = (PontoColeta) o;
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getIdLog() %></td>
                <td><%= p.getNome() %></td>
                <td><%= p.getQrCode() %></td>
                <td>
                    <a class="btn-small" href="alterarPontoColeta.jsp?id=<%= p.getId() %>">Alterar</a>
                    <a class="btn-small red" href="excluirPontoColeta.jsp?id=<%= p.getId() %>">Excluir</a>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
