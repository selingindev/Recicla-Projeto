<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="reciclabackend.model.bean.PdrCol"%>
<%@page import="reciclabackend.controller.ControllerPDRCOL"%>

<%
    request.setCharacterEncoding("UTF-8");

    String filtro = request.getParameter("PFILTRO");
    if (filtro == null) {
        filtro = "";
    }

    List<Object> lista = null;
    try {
        ControllerPDRCOL controller = new ControllerPDRCOL();
        lista = controller.listar(filtro);
    } catch (Exception e) {
        lista = null;
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>LISTAR - PDRCOL</title>
    </head>
    <body>
        <div class="container">
            <h1>LISTAR PDRCOL</h1>

            <!-- campo de filtro -->
            <form method="get">
                <label for="PFILTRO">Filtro:</label>
                <input type="text" name="PFILTRO" id="PFILTRO" value="<%= filtro %>">
                <button class="btn waves-effect waves-light" type="submit">
                    Buscar
                </button>
            </form>
            <br>

            <table class="striped highlight">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>IDPRD</th>
                        <th>IDCOL</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (lista != null && !lista.isEmpty()) {
                            for (Object obj : lista) {
                                PdrCol pdrcol = (PdrCol) obj;
                    %>
                    <tr>
                        <td><%= pdrcol.getId() %></td>
                        <td><%= pdrcol.getIdPRD() %></td>
                        <td><%= pdrcol.getIdCOL() %></td>
                        <td>
                            <a href="alterarPdrCol.jsp?id=<%= pdrcol.getId() %>" class="btn-small blue">Alterar</a>
                            <a href="excluirPdrCol.jsp?id=<%= pdrcol.getId() %>" class="btn-small red">Excluir</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="4">Nenhum registro encontrado.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <br>
            <a href="inserirPdrCol.jsp" class="btn green darken-1">Novo Registro</a>
            <a href="index.jsp" class="btn grey">Início</a>
        </div>
    </body>
</html>
