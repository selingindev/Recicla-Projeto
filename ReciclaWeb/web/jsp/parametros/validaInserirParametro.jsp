<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Parametro"%>
<%@page import="reciclabackend.controller.ControllerParametro"%>

<%
    int cod = Integer.parseInt(request.getParameter("CODIGO"));
    String descricao = request.getParameter("DESCRICAO");
    
    Parametro parEntrada = new Parametro(cod, descricao);
    ControllerParametro controller = new ControllerParametro();
    Parametro parSaida = (Parametro) controller.inserir(parEntrada);
        
    // REDIRECIONA PARA A PAG LISTAR PARAMETROS.JSP
    String url = "listarParametros.jsp";
    response.sendRedirect(url);
%>

