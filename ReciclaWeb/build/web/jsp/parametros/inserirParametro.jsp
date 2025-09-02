<%-- 
    Document   : parametros
    Created on : 30 de ago. de 2025, 15:53:28
    Author     : raife
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Parametro</title>
    </head>
    <body>
        <h1>Inserir Parametro</h1>
        <div class="container"/>
        <form name="inserirParametro" action="validaInserirParametro.jsp" method="post">
            Código: <input type="number" name="CODIGO" value=""> <br> <br>
            Nome: <input type="text" name="DESCRICAO" value=""> <br> <br>
            <input type="submit" name="Enviar" value="Enviar">
        </form>
        <div>
    </body>
</html>
