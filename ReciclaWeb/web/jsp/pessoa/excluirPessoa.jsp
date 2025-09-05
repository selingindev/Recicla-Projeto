<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Pessoa"%>
<%@page import="reciclabackend.controller.ControllerPessoa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ControllerPessoa usuCont = new ControllerPessoa();
    usuCont.excluir(id);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>