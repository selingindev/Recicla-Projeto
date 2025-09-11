<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="reciclabackend.model.bean.PdrCol"%>
<%@page import="reciclabackend.controller.ControllerPDRCOL"%>

<%
    request.setCharacterEncoding("UTF-8");

    // pega os parâmetros do formulário
    int idPRD = Integer.parseInt(request.getParameter("IDPRD"));
    int idCOL = Integer.parseInt(request.getParameter("IDCOL"));

    String mensagem = "";
    try {
        // cria objeto e chama controller
        PdrCol pdrcol = new PdrCol(idPRD, idCOL);
        ControllerPDRCOL controller = new ControllerPDRCOL();
        controller.inserir(pdrcol);

        mensagem = "PdrCol inserido com sucesso!";
    } catch (Exception e) {
        mensagem = "Erro ao inserir PdrCol: " + e.getMessage();
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>VALIDA INSERIR - PDRCOL</title>
    </head>
    <body>
        <div class="container">
            <h3><%= mensagem %></h3>

            <br>
            <a href="inserirPdrCol.jsp" class="btn green darken-1">Inserir Novo</a>
            <a href="index.jsp" class="btn grey">Início</a>
        </div>
    </body>
</html>
