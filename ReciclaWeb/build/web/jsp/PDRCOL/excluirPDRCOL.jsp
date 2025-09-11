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
        <title>EXCLUIR - PDRCOL</title>
    </head>
    <body>
        <div class="container">
            <h1>EXCLUIR PDRCOL</h1>

            <!-- buscar pelo ID -->
            <form name="buscarPdrCol" method="get">
                <label for="id">ID do PDRCOL:</label>
                <input type="text" name="id" id="id" value="<%= (id != null ? id : "") %>">
                <button class="btn waves-effect waves-light" type="submit">
                    Buscar
                </button>
            </form>
            <br><br>

            <%
                if (pdrcol != null) {
            %>
            <!-- mostrar informações antes de excluir -->
            <form name="excluirPdrCol" action="validaExcluirPdrCol.jsp" method="post">

                <p><strong>ID:</strong> <%= pdrcol.getId() %></p>
                <p><strong>IDPRD:</strong> <%= pdrcol.getIdPRD() %></p>
                <p><strong>IDCOL:</strong> <%= pdrcol.getIdCOL() %></p>

                <input type="hidden" name="ID" value="<%= pdrcol.getId() %>">
                <input type="hidden" name="PBUSCA" value="<%= (pbusca != null ? pbusca : "") %>">

                <button class="btn red darken-1 waves-effect waves-light" type="submit">
                    Excluir
                </button>
            </form>
            <%
                }
            %>
        </div>
    </body>
</html>
