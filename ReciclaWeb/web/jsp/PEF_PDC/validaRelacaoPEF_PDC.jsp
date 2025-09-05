<%-- 
    Document   : validaRelacaoPEF_PDC.jsp
    Created on : 4 de set. de 2025, 17:11:47
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PefPdc"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>

<%
    int idPef = Integer.parseInt(request.getParameter("ID_PEF"));
    int idPdc = Integer.parseInt(request.getParameter("ID_PDC"));
    String cod = request.getParameter("COD");
    double quant = Double.parseDouble(request.getParameter("QUANT"));
    String data = request.getParameter("DATA");

    PefPdc relacao = new PefPdc(idPef, 0, 0, idPdc, cod, quant, data);
    ControllerPEF_PDC relacaoCont = new ControllerPEF_PDC();
    relacaoCont.inserir(relacao);

    String url = "inserirRelacaoPEF_PDC.jsp";
    response.sendRedirect(url);
%>