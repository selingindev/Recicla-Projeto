<%--
    Document   : validarPontoColeta
    Created on : 3 de set. de 2025
    Author     : Ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoColeta"%>
<%@page import="reciclabackend.controller.ControllerPontoColeta"%>

<%
    // Pegando os parâmetros do formulário
    String nome = request.getParameter("novo_nome");
    String idLogStr = request.getParameter("novo_idLog");
    String qrCode = request.getParameter("novo_qrCode");

    // Instanciando o controller
    ControllerPontoColeta controller = new ControllerPontoColeta();

    // Criando o objeto PontoColeta
    PontoColeta ponto = new PontoColeta(0, Integer.parseInt(idLogStr), nome, qrCode);

    // Inserindo no banco
    Object resultado = controller.inserir(ponto);

    // Encaminha para a página de inserção (mesma pasta)
    String url = "inserirPontoColeta.jsp";
    request.getRequestDispatcher(url).forward(request, response);
%>