<%@page import="reciclabackend.util.api.CepApi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String cep = request.getParameter("CEP");
    String numero = request.getParameter("NUMERO");
    String complemento_api = request.getParameter("COMPL_API");
    String complemento_outros = request.getParameter("COMPL_OUTROS");

    Logradouro sis = new Logradouro(id, cep, numero, complemento_api, complemento_outros);
    ControllerLogradouro logCont = new ControllerLogradouro();
    logCont.alterar(sis);
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLogradouro.jsp?CEP=" + pbusca;
    response.sendRedirect(url);
%>