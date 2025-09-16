<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>CONSULTAR - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>CONSULTAR COL_PDC</h1>
            <form name="consultarColPdc" action="validaConsultarCOL_PDC.jsp" method="post">
                <div class="input-field">
                    <label for="idCol">ID COLABORADOR</label>
                    <input type="text" id="idCol" name="IDCOL">
                </div>
                <button class="btn waves-effect waves-light" type="submit">
                    Buscar
                </button>
            </form>
        </div>
    </body>
</html>
