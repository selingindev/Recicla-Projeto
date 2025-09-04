<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>Inserir Logradouro</title>
    </head>
    <body>
        <div class="container">
            <h1>Inserir Logradouro</h1>
            
            <form action="validaInserirLogradouro.jsp" method="post">
                <div class="input-field">
                    <label for="cep">CEP</label>
                    <input type="text" id="cep" name="CEP" required>
                </div>

                <div class="input-field">
                    <label for="numero">Número</label>
                    <input type="text" id="numero" name="NUMERO" required>
                </div>

                <div class="input-field">
                    <label for="complemento">Complemento</label>
                    <input type="text" id="complemento" name="COMPL_OUTROS">
                </div>

                <button class="btn waves-effect waves-light" type="submit">
                    Inserir
                </button>
            </form>
        </div>
    </body>
</html>

</html>