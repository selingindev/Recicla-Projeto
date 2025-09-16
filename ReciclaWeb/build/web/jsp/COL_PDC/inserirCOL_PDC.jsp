<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <%@ include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>INSERIR - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Inserir COL_PDC</h1>
            <form name="inserirColPdc" action="validaInserirCOL_PDC.jsp" method="post">
                <div class="input-field">
                    <label for="idCol">ID COLABORADOR</label>
                    <input type="text" id="idCol" name="IDCOL" required>
                </div>
                <div class="input-field">
                    <label for="idPdc">ID PONTO DE COLETA</label>
                    <input type="text" id="idPdc" name="IDPDC" required>
                </div>
                <div class="input-field">
                    <label for="data">DATA (AAAA-MM-DD)</label>
                    <input type="text" id="data" name="DATA" required>
                </div>
                <button class="btn waves-effect waves-light" type="submit">
                    Inserir
                </button>
            </form>
        </div>
    </body>
</html>
