<%--
    Document   : validaConsultaPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // Pegando os parâmetros do formulário
    int id = Integer.parseInt(request.getParameter("ID"));
    int idPes = Integer.parseInt(request.getParameter("IDPES"));
    String cnpj = request.getParameter("CNPJ");
    int inscEst = Integer.parseInt(request.getParameter("INSCEST"));


    PessoaJuridica pj = new PessoaJuridica(id, idPes, cnpj, inscEst);
    ControllerPessoaJuridica pjCont = new ControllerPessoaJuridica();
    pjCont.alterar(pj);

    String cnpj = request.getParameter("CNPJ");
    String url = "validaConsultaPessoaJuridica.jsp?FILTRO=" + cnpj;
    response.sendRedirect(url);

%>