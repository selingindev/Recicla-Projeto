<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    int cod = Integer.parseInt(request.getParameter("CODIGO"));
    String descricao = request.getParameter("DESCRICAO");
    
    Parametro parEntrada = new Parametro(cod, descricao);
    ControllerParametro controller = new ControllerParametro();
    Parametro parSaida = (Parametro) controller.alterar(parEntrada);
    
    // REDIRECIONA PARA A PAG LISTAR PARAMETROS.JSP
    String url = "listarParametros.jsp";
    response.sendRedirect(url);
%>

