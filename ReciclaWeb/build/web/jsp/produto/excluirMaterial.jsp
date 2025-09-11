<%-- 
    Document   : excluirMaterial
    Created on : 11 Sept 2025, 14:41:41
    Author     : liahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Material"%>
<%@page import="reciclabackend.controller.ControllerMaterial"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ControllerMaterial matCont = new ControllerMaterial();
    matCont.excluir(id);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarProduto.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
