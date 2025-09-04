<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="descartebackend.model.dado.Logradouro"%>
<%@page import="descartebackend.controller.ControllerLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ControllerLogradouro logCont = new ControllerLogradouro();
    logCont.Excluir(id);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLogradouro.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>