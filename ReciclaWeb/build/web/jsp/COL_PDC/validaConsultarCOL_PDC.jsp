<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String idColParam = request.getParameter("IDCOL");
    ControllerColPdc controller = new ControllerColPdc();
    List<Object> lista;

    if (idColParam != null && !idColParam.isEmpty()) {
        lista = controller.listar(idColParam);
    } else {
        lista = controller.listar(null);
    }

    DateTimeFormatter brFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
%>

<html>
    <%@ include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>Resultado - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Resultado da Consulta COL_PDC</h1>

            <% if (lista.isEmpty()) { %>
                <p>Nenhum registro encontrado.</p>
            <% } else { %>
                <table class="striped responsive-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ID COLABORADOR</th>
                            <th>ID PONTO DE COLETA</th>
                            <th>DATA</th>
                            <th>Alterar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Object obj : lista) {
                            ColPdc colpdc = (ColPdc) obj;
                            // Converte a data para o formato brasileiro
                            String dataBr = LocalDate.parse(colpdc.getData()).format(brFormatter);
                        %>
                        <tr>
                            <td><%= colpdc.getId() %></td>
                            <td><%= colpdc.getIdCol() %></td>
                            <td><%= colpdc.getIdPdc() %></td>
                            <td><%= dataBr %></td>
                            <td><a href="alterarCOL_PDC.jsp?ID=<%= colpdc.getId() %>">Alterar</a></td>
                            <td><a href="excluirCOL_PDC.jsp?ID=<%= colpdc.getId() %>">Excluir</a></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            <% } %>
        </div>
    </body>
</html>
