<%-- 
    Document   : validaInserirProduto
    Created on : 11 Sept 2025, 14:26:42
    Author     : liahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Material"%>
<%@page import="reciclabackend.controller.ControllerMaterial"%>

<%
    String nome = request.getParameter("MAT");
    String desc = request.getParameter("DESC");
    Material obj = new Material(nome,desc);
    ControllerMaterial matCont = new ControllerMaterial();
    matCont.inserir(obj);
    String url = "consultarProduto.jsp";
    response.sendRedirect(url);
%>
