<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>
<%@page import="java.io.IOException"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    ControllerPEF_PDC controller = new ControllerPEF_PDC();
    boolean excluido = controller.excluir(id);
    if (excluido) {
        response.sendRedirect("consultarRelacaoPEF_PDC.jsp");
    } else {
        out.println("Erro ao excluir o registro.");
    }
%>