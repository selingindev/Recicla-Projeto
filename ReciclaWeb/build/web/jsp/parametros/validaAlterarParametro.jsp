<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Parametro"%>
<%@page import="reciclabackend.controller.ControllerParametro"%>

<%
    
    int id = Integer.parseInt(request.getParameter("ID"));
    String descricao = request.getParameter("DESCRICAO");
    
    Parametro parEntrada = new Parametro(id, descricao);
    ControllerParametro controller = new ControllerParametro();
    Parametro parSaida = (Parametro) controller.alterar(parEntrada);
    
    // REDIRECIONA PARA A PAG LISTAR PARAMETROS.JSP
    String url = "listarParametros.jsp";
    response.sendRedirect(url);
%>

