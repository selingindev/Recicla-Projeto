<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="descartebackend.model.dado.Pessoa"%>
<%@page import="descartebackend.controller.ControllerPessoa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ControllerPessoa usuCont = new ControllerPessoa();
    usuCont.Excluir(id);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>