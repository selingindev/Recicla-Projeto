<%-- 
    Document   : inserirPontoReciclagem
    Description: Formulário para cadastrar um novo Ponto de Reciclagem.
    Baseado em: inserirParametro.jsp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ponto de Reciclagem</title>
    </head>
    <body>
        <h1>Ponto de Reciclagem</h1>
        <div class="container">
            <form name="inserirPontoReciclagem" action="validaInserirPontoReciclagem.jsp" method="post">
                <%-- O 'name' deste campo é "idPEJ" para corresponder ao bean PontoReciclagem --%>
                Código: <input type="number" name="idPEJ" value="" required> <br> <br>
                
                <%-- O 'name' deste campo é "nome" para corresponder ao bean PontoReciclagem --%>
                Nome: <input type="text" name="nome" value="" required> <br> <br>
                
                <input type="submit" name="Enviar" value="Enviar">
            </form>
        </div>
    </body>
</html>

