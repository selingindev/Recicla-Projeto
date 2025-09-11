<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    String idString = request.getParameter("id");
    int id = Integer.parseInt(idString);
    
    ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
    controller.excluir(id);
    
    // REDIRECIONA PARA A PAGINA DE LISTAGEM CORRETA
    String url = "listarPontoReciclagem.jsp";
    response.sendRedirect(url);
%>
