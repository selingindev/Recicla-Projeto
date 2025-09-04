<%@page import="descartebackend.util.api.CepApi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="descartebackend.model.dado.Logradouro"%>
<%@page import="descartebackend.controller.ControllerLogradouro"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String cep = request.getParameter("CEP");
    String numero = request.getParameter("NUMERO");
    String complemento_api = request.getParameter("COMPL_API");
    String complemento_outros = request.getParameter("COMPL_OUTROS");

    Logradouro sis = new Logradouro(id, cep, numero, complemento_api, complemento_outros);
    ControllerLogradouro logCont = new ControllerLogradouro();
    logCont.Alterar(sis);
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLogradouro.jsp?CEP=" + pbusca;
    response.sendRedirect(url);
%>