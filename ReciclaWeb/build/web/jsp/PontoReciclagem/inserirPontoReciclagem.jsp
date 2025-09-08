<%-- 
    Document   : inserirPontoReciclagem
    Description: Formulário para cadastrar um novo Ponto de Reciclagem.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Imports necessários para buscar os dados do select --%>
<%@page import="java.util.List"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // Busca a lista de Pessoas Jurídicas para preencher o select
    ControllerPessoaJuridica controllerPj = new ControllerPessoaJuridica();
    List<Object> pessoasJuridicas = controllerPj.listar("");
%>

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
                
                <%-- Campo "Código" é um SELECT preenchido com a chave estrangeira PessoaJuridica --%>
                Empresa (CNPJ): 
                <select name="idPEJ" required>
                    <option value="" disabled selected>Selecione uma empresa</option>
                    <% for (Object obj : pessoasJuridicas) {
                        PessoaJuridica pj = (PessoaJuridica) obj;
                    %>
                        <%-- O 'value' envia o ID, mas o texto mostra o CNPJ para o usuário --%>
                        <option value="<%= pj.getId() %>"><%= pj.getCnpj() %></option> 
                    <% } %>
                </select>
                <br><br>
                
                <%-- Campo "Nome" é um campo de texto normal --%>
                Nome do Ponto: 
                <input type="text" name="nome" value="" required>
                <br><br>
                
                <input type="submit" name="Enviar" value="Enviar">
            </form>
        </div>
    </body>
</html>

