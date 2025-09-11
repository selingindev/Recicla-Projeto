<%-- 
    Document   : excluirPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    try {
        int id = Integer.parseInt(request.getParameter("ID"));
        ControllerPessoaJuridica controller = new ControllerPessoaJuridica();
        controller.excluir(id);

        String cnpj = request.getParameter("CNPJ");
        String url = "consultaPessoaJuridica.jsp?NOME=" + cnpj;
        response.sendRedirect(url);

    } catch (Exception e) {
        out.print("Erro ao excluir Pessoa Jurídica: " + e.getMessage());
    }
%>
