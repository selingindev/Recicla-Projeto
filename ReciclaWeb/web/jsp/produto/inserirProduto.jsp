<%-- 
    Document   : inserirProduto
    Created on : 11 Sept 2025, 13:16:21
    Author     : liahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Material</title>
    </head>
    <body>
        <h1>Inserir Material</h1>
        <form action="validaInserirProduto.jsp" method="post">
                <div class="input-field">
                    <label for="mat">Nome</label>
                    <input type="text" id="mat" name="MAT" required>
                </div>

                <div class="input-field">
                    <label for="desc">Descrição</label>
                    <input type="text" id="desc" name="DESC" required>
                </div>

                <button class="btn waves-effect waves-light" type="submit">
                    Inserir
                </button>
            </form>
    </body>
</html>
