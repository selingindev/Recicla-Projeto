<%-- 
    Document   : pj_login
    Created on : 3 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Acesso Pessoa Jurídica</title>
    </head>
    <body>
        <h1>Acesso - Pessoa Jurídica</h1>

        <!-- Formulário para login/busca de usuário PJ -->
        <form action="buscarPessoaJuridica.jsp" method="POST">
            <label for="cnpj">CNPJ:</label>
            <input type="text" id="cnpj" name="cnpj" placeholder="Digite o CNPJ" required><br><br>

            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required><br><br>

            <button type="submit">Entrar</button>
        </form>

        <hr>

        <!-- Formulário para inserir novo usuário PJ -->
        <h2>Cadastro de Nova Pessoa Jurídica</h2>
        <form action="salvarPessoaJuridica.jsp" method="POST">
            <label for="novo_cnpj">CNPJ:</label>
            <input type="text" id="novo_cnpj" name="novo_cnpj" placeholder="Digite o CNPJ" required><br><br>

            <label for="nova_senha">Senha:</label>
            <input type="password" id="nova_senha" name="nova_senha" placeholder="Crie uma senha" required><br><br>

            <button type="submit">Cadastrar</button>
        </form>
    </body>
</html>
