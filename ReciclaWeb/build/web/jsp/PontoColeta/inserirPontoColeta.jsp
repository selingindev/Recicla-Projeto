<%-- 
    Document   : inserirPontoColeta
    Created on : 3 de set. de 2025
    Author     : Ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Acesso Ponto de Coleta</title>
    </head>
    <body>
        <h1>Acesso - Ponto de Coleta</h1>

        <!-- Formulário para busca de ponto de coleta -->
        <form action="buscarPontoColeta.jsp" method="POST">
            <label for="idLog">ID do Logradouro:</label>
            <input type="number" id="idLog" name="idLog" placeholder="Digite o ID do logradouro" required><br><br>

            <label for="qrCode">Código QR:</label>
            <input type="text" id="qrCode" name="qrCode" placeholder="Digite o código QR" required><br><br>

            <button type="submit">Entrar</button>
        </form>

        <hr>

        <!-- Formulário para inserir novo ponto de coleta -->
        <h2>Cadastro de Novo Ponto de Coleta</h2>
        <form action="salvarPontoColeta.jsp" method="POST">
            <label for="novo_nome">Nome do Ponto:</label>
            <input type="text" id="novo_nome" name="novo_nome" placeholder="Digite o nome do ponto" required><br><br>

            <label for="novo_idLog">ID do Logradouro:</label>
            <input type="number" id="novo_idLog" name="novo_idLog" placeholder="Digite o ID do logradouro" required><br><br>

            <label for="novo_qrCode">Código QR:</label>
            <input type="text" id="novo_qrCode" name="novo_qrCode" placeholder="Digite o código QR" required><br><br>

            <button type="submit">Cadastrar</button>
        </form>
    </body>
</html>