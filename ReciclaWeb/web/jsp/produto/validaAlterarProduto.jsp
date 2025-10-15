<%-- 
    Document   : validaAlterarProduto
    Created on : 11 Sept 2025, 15:12:32
    Author     : liahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Material"%>
<%@page import="reciclabackend.controller.ControllerMaterial"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String descricao = request.getParameter("DESCRICAO");

    Material sis = new Material(id, nome, descricao);
    ControllerMaterial logCont = new ControllerMaterial();
    logCont.alterar(sis);
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "consultarProduto.jsp";
    response.sendRedirect(url);
%>
