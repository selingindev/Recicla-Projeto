<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PefPdc"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>

<%
    int idPef = Integer.parseInt(request.getParameter("id_pef"));
    int idPdc = Integer.parseInt(request.getParameter("id_pdc"));

    ControllerPEF_PDC controller = new ControllerPEF_PDC();

    String url = "inserirPEF_PDC.jsp";
    request.getRequestDispatcher(url).forward(request, response);
%>