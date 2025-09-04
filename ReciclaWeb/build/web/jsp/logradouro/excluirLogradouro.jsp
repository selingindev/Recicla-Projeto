<%-- 
    Document   : newjsp
    Created on : 3 de set. de 2025, 23:59:00
    Author     : ArthurSelingin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ControllerLogradouro logCont = new ControllerLogradouro();
    logCont.excluir(id);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLogradouro.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>