<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>
<%@page import="reciclabackend.model.bean.PefPdc"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    int idPef = Integer.parseInt(request.getParameter("idPef"));
    int idPdc = Integer.parseInt(request.getParameter("idPdc"));
    String cod = request.getParameter("cod");
    double quant = Double.parseDouble(request.getParameter("quant"));
    String data = request.getParameter("data");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date dataFormatada = new Date(sdf.parse(data).getTime());

    PefPdc relacao = new PefPdc(id, idPef, 5, idPdc, cod, quant, dataFormatada);
    ControllerPEF_PDC controller = new ControllerPEF_PDC();
    controller.alterar(relacao);

    response.sendRedirect("consultarRelacaoPEF_PDC.jsp");
%>