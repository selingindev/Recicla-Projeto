<%-- 
    Document   : pef_pdc
    Created on : 2 de set. de 2025, 16:59:46
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de PEF_PDC</title>
    </head>
    <body>
        <h1>Cadastro de Pessoa Física - Ponto de Coleta</h1>
        <form action="salvarPEF_PDC.jsp" method="POST">
            <label for="id_pef">Pessoa Física:</label>
            <select name="id_pef" id="id_pef">
                <c:forEach var="pessoaFisica" items="${pessoaFisicas}">
                    <option value="${pessoaFisica.id}">${pessoaFisica.nome}</option>
                </c:forEach>
            </select><br><br>

            <label for="id_pdc">Ponto de Coleta:</label>
            <select name="id_pdc" id="id_pdc">
                <c:forEach var="pontoColeta" items="${pontosDeColeta}">
                    <option value="${pontoColeta.id}">${pontoColeta.nome}</option>
                </c:forEach>
            </select><br><br>

            <button type="submit">Cadastrar</button>
        </form>
    </body>
</html>
