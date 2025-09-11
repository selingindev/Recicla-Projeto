<%-- 
    Document   : parametros
    Created on : 30 de ago. de 2025, 15:53:28
    Author     : raife
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="reciclabackend.model.bean.PdrCol"%>
<%@page import="reciclabackend.controller.ControllerPDRCOL"%>

<%
    String id = request.getParameter("id");
    PdrCol pdrcol = null;
    String pbusca = request.getParameter("PBUSCA");

    if (id != null && !id.trim().isEmpty()) {
        try {
            Integer idInt = Integer.parseInt(id);
            ControllerPDRCOL pdrcolCont = new ControllerPDRCOL();
            pdrcol = (PdrCol) pdrcolCont.buscar(idInt);
        } catch (Exception e) {
            pdrcol = null;
        }
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>ALTERAR - PDRCOL</title>
    </head>
    <body>
        <div class="container">
            <h1>ALTERAR PDRCOL</h1>

            <!-- primeiro campo: ID para buscar -->
            <form name="buscarPdrCol" method="get">
                <label for="id">ID do PDRCOL:</label>
                <input type="text" name="id" id="id" value="<%= (id != null ? id : "") %>">
                <button class="btn waves-effect waves-light" type="submit">
                    Alterar
                </button>
            </form>
            <br><br>

            <%
                if (pdrcol != null) {
            %>
            <!-- formulário de alteração -->
            <form name="alterarPdrCol" action="validaAlterarPdrCol.jsp" method="post">

                <input type="hidden" id="id" name="ID" value="<%= pdrcol.getId() %>">

                <label for="idPRD">ID do Produto (idPRD):</label>
                <input type="text" id="idPRD" name="IDPRD" value="<%= pdrcol.getIdPRD() %>">
                <br>

                <label for="idCOL">ID da Coleta (idCOL):</label>
                <input type="text" id="idCOL" name="IDCOL" value="<%= pdrcol.getIdCOL() %>">
                <br>

                <input type="hidden" name="PBUSCA" value="<%= (pbusca != null ? pbusca : "") %>">

                <button class="btn waves-effect waves-light" type="submit">
                    Alterar
                </button>
            </form>
            <%
                }
            %>
        </div>
    </body>
</html>

