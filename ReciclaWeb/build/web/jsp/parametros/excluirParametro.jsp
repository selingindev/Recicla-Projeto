<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Parametro"%>
<%@page import="reciclabackend.controller.ControllerParametro"%>

<%
    String cod = request.getParameter("CODIGO");
    int id = Integer.parseInt(cod);
    ControllerParametro controller = new ControllerParametro();
    boolean sucesso = controller.excluir(id);
    
    // REDIRECIONA PARA A PAG LISTAR PARAMETROS.JSP
    String url = "listarParametros.jsp";
    response.sendRedirect(url);
%>