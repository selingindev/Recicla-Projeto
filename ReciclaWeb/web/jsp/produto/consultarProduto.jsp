<%-- 
    Document   : consultarProduto
    Created on : 11 Sept 2025, 13:17:04
    Author     : liahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - MATERIAL</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR MATERIAL</h1>
       <form name="consultarMaterial" action="validaConsultarProduto.jsp" method="post">
            <div class="input-field">
                    <label for="mat">NOME</label>
                    <input type="text" id="mat" name="MAT" required>
                </div>
                <button class="btn waves-effect waves-light" type="submit">
                    Buscar
                </button>
       </form>
       </div>
    </body>
</html>