<%-- 
    Document   : validaInserirLogradouro
    Created on : 4 de set. de 2025, 12:10:26
    Author     : ArthurSelingin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

<%
    String cep = request.getParameter("CEP");
    String numero = request.getParameter("NUMERO");
    String complemento_outros = request.getParameter("COMPL_OUTROS");
    Logradouro Log = new Logradouro(cep,numero,"",complemento_outros);
    ControllerLogradouro logCont = new ControllerLogradouro();
    logCont.inserir(Log);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "consultarLogradouro.jsp";
    response.sendRedirect(url);
%>

