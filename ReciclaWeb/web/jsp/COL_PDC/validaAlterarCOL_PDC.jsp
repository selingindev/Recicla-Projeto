<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("ID"));
    int idCol = Integer.parseInt(request.getParameter("IDCOL"));
    int idPdc = Integer.parseInt(request.getParameter("IDPDC"));
    String dataParam = request.getParameter("DATA"); // espera dd/mm/aaaa

    // Converte data para yyyy-mm-dd (MySQL)
    String[] partes = dataParam.split("/");
    String dataFormatada = partes[2] + "-" + partes[1] + "-" + partes[0];

    ColPdc colpdc = new ColPdc(id, idCol, idPdc, dataFormatada);
    ControllerColPdc controller = new ControllerColPdc();
    controller.alterar(colpdc);

    // Redireciona para a listagem
    response.sendRedirect("validaConsultarCOL_PDC.jsp");
%>
