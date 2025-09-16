<%@ page import="java.util.List" %>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <%@ include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>RESULTADO - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Resultado da Consulta COL_PDC</h1>
            <%
                String idColParam = request.getParameter("IDCOL");
                ControllerColPdc controller = new ControllerColPdc();
                List<Object> lista;

                if (idColParam != null && !idColParam.isEmpty()) {
                    lista = controller.listar(idColParam); // Mantém erro HTTP 500 se filtro inválido
                } else {
                    lista = controller.listar(null);
                }

                if (lista.isEmpty()) {
            %>
                <p>Nenhum registro encontrado.</p>
            <%
                } else {
            %>
                <table class="striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ID COLABORADOR</th>
                            <th>ID PONTO DE COLETA</th>
                            <th>DATA</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Object obj : lista) {
                            ColPdc colpdc = (ColPdc) obj;
                    %>
                        <tr>
                            <td><%= colpdc.getId() %></td>
                            <td><%= colpdc.getIdCol() %></td>
                            <td><%= colpdc.getIdPdc() %></td>
                            <td><%= colpdc.getData() %></td>
                        </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            <%
                }
            %>
        </div>
    </body>
</html>
