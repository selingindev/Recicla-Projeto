<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="reciclabackend.model.bean.PdrCol"%>
<%@page import="reciclabackend.controller.ControllerPDRCOL"%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>INSERIR - PDRCOL</title>
    </head>
    <body>
        <div class="container">
            <h1>INSERIR PDRCOL</h1>

            <!-- formulário de inserção -->
            <form name="inserirPdrCol" action="validaInserirPdrCol.jsp" method="post">

                <label for="idPRD">ID do Produto (idPRD):</label>
                <input type="text" id="idPRD" name="IDPRD" required>
                <br>

                <label for="idCOL">ID da Coleta (idCOL):</label>
                <input type="text" id="idCOL" name="IDCOL" required>
                <br>

                <button class="btn green darken-1 waves-effect waves-light" type="submit">
                    Inserir
                </button>
            </form>
        </div>
    </body>
</html>
