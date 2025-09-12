<%-- 
    Document   : inserirColPdc
    Created on : 10 de set. de 2025
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>INSERIR - COL_PDC</title>
    </head>
    <body>
       <div class="container">
            <h1>INSERIR COL_PDC</h1>

            <form name="inserirColPdc" action="validaInserirColPdc.jsp" method="post">

                <label for="idCol">ID do Colaborador:</label>
                <input type="text" id="idCol" name="IDCOL" required>
                <br>

                <label for="idPdc">ID do Ponto de Coleta:</label>
                <input type="text" id="idPdc" name="IDPDC" required>
                <br>

                <label for="data">Data:</label>
                <input type="text" id="data" name="DATA" required>
                <br>

                <button class="btn waves-effect waves-light" type="submit">
                    Inserir
                </button>
            </form>
        </div>
    </body>
</html>
