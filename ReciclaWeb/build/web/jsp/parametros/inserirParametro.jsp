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
        <style>
            .btn {
                display: inline-block;
                padding: 10px 20px;
                margin: 10px 0;
                background-color: #007bff; /* Cor de fundo do botão */
                color: white; /* Cor do texto */
                text-align: center;
                text-decoration: none; /* Remove o sublinhado */
                border-radius: 5px; /* Bordas arredondadas */
                font-size: 16px;
            }
            .btn-cancelar {
                background-color: red; /* Cor de fundo do botão */
            }
        </style>
    </head>
    <body>
        <h1>Inserir Parametro</h1>
        <div class="container"/>
        <form name="inserirParametro" action="validaInserirParametro.jsp" method="post">
            Código: <input type="number" name="CODIGO" value=""> <br> <br>
            Nome: <input type="text" name="DESCRICAO" value=""> <br> <br>
            
            <a href="listarParametros.jsp" class="btn btn-cancelar"> Cancelar </a><!-- Listar Parametro -->
            <input class="btn" type="submit" name="Enviar" value="Enviar">
        </form>
        <div>
    </body>
</html>
