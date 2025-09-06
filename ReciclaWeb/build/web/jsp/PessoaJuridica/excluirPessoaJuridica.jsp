<%--
    Document   : excluirPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>

<%
     int id = Integer.parseInt(request.getParameter("ID"));
     ControllerPessoaJuridica controller = new ControllerPessoaJuridica();
     pjCont.excluir(id);

     String cnpj = request.getParameter("CNPJ");
        String url = "validaConsultaPessoaJuridica.jsp?FILTRO=" + cnpj;
        response.sendRedirect(url);
%>
