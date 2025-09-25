<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("ID"));
    ControllerColPdc controller = new ControllerColPdc();
    controller.excluir(id);

    // Redireciona para a listagem
    response.sendRedirect("validaConsultarCOL_PDC.jsp");
%>
