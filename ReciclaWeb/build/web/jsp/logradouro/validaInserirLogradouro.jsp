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
    String url = "inserirLogradouro.jsp";
    response.sendRedirect(url);
%>

