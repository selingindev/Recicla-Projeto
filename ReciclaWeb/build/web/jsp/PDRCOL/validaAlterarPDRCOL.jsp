<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="reciclabackend.model.bean.PdrCol"%>
<%@page import="reciclabackend.controller.ControllerPDRCOL"%>

<%
    request.setCharacterEncoding("UTF-8");

    // pega os parâmetros do formulário
    int id = Integer.parseInt(request.getParameter("ID"));
    int idPRD = Integer.parseInt(request.getParameter("IDPRD"));
    int idCOL = Integer.parseInt(request.getParameter("IDCOL"));
    String pbusca = request.getParameter("PBUSCA");

    String mensagem = "";
    try {
        // cria objeto e chama controller
        PdrCol pdrcol = new PdrCol(id, idPRD, idCOL);
        ControllerPDRCOL controller = new ControllerPDRCOL();
        controller.alterar(pdrcol);

        mensagem = "PdrCol alterado com sucesso!";
    } catch (Exception e) {
        mensagem = "Erro ao alterar PdrCol: " + e.getMessage();
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>VALIDA ALTERAR - PDRCOL</title>
    </head>
    <body>
        <div class="container">
            <h3><%= mensagem %></h3>

            <br>
            <a href="alterarPdrCol.jsp" class="btn blue darken-1">Voltar</a>
            <a href="index.jsp" class="btn grey">Início</a>
        </div>
    </body>
</html>
