<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String idParam = request.getParameter("ID");
    ColPdc colpdc = null;

    if (idParam != null && !idParam.isEmpty()) {
        int id = Integer.parseInt(idParam);
        ControllerColPdc controller = new ControllerColPdc();
        colpdc = (ColPdc) controller.buscar(id);
    }
%>

<html>
<%@ include file="../../inc/materalizeWeb.inc" %>
<head>
    <title>ALTERAR - COL_PDC</title>
</head>
<body>
<div class="container">
    <h1>Alterar Registro COL_PDC</h1>

    <form action="validaAlterarCOL_PDC.jsp" method="post">
        <% if (colpdc != null) { %>
            <input type="hidden" name="ID" value="<%= colpdc.getId() %>">

            <label for="idCol">ID Colaborador:</label>
            <input type="text" name="IDCOL" id="idCol" value="<%= colpdc.getIdCol() %>">
            <br>

            <label for="idPdc">ID Ponto de Coleta:</label>
            <input type="text" name="IDPDC" id="idPdc" value="<%= colpdc.getIdPdc() %>">
            <br>

            <label for="data">Data (dd/mm/aaaa):</label>
            <input type="text" name="DATA" id="data" value="<%= colpdc.getData().substring(8,10) + "/" + colpdc.getData().substring(5,7) + "/" + colpdc.getData().substring(0,4) %>">
            <br><br>

            <button class="btn waves-effect waves-light" type="submit">Alterar</button>
        <% } else { %>
            <p>Registro não encontrado.</p>
        <% } %>
    </form>
</div>
</body>
</html>
