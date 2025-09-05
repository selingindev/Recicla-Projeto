<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PefPdc"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>
<%@page import="java.sql.Date"%>  
<%@page import="java.text.SimpleDateFormat"%>

<%
    int idPef = Integer.parseInt(request.getParameter("ID_PEF"));
    int idPdc = Integer.parseInt(request.getParameter("ID_PDC"));
    String cod = request.getParameter("COD");
    double quant = Double.parseDouble(request.getParameter("QUANT"));
    String data = request.getParameter("DATA");
    int idMat = 1;
    int idCol = 1;

    // Atualizando o formato para o formato correto da data
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Formato correto
    java.sql.Date dataFormatada = new java.sql.Date(sdf.parse(data).getTime());

    PefPdc relacao = new PefPdc(idPef, idCol, idMat, idPdc, cod, quant, dataFormatada);
    ControllerPEF_PDC relacaoCont = new ControllerPEF_PDC();
    relacaoCont.inserir(relacao);

    String url = "inserirRelacaoPEF_PDC.jsp";
    response.sendRedirect(url);
%>