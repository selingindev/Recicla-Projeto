<%-- 
    Document   : alterarPontoReciclagem
    Description: Formulário para alterar um Ponto de Reciclagem existente.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // 1. Busca o Ponto de Reciclagem específico que será alterado
    String idString = request.getParameter("id");
    int id = Integer.parseInt(idString);
    ControllerPontoReciclagem pontoCont = new ControllerPontoReciclagem();
    PontoReciclagem ponto = (PontoReciclagem) pontoCont.buscar(id);

    // 2. Busca a lista COMPLETA de Pessoas Jurídicas para preencher o menu de seleção
    ControllerPessoaJuridica controllerPj = new ControllerPessoaJuridica();
    List<Object> pessoasJuridicas = controllerPj.listar("");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Alterar - Ponto de Reciclagem</title>
    </head>
    <body>
       <div class="container">
            <h1>Alterar Ponto de Reciclagem</h1>
            <form name="alterarPontoReciclagem" action="validaAlterarPontoReciclagem.jsp" method="post">
                
                <%-- O campo "Código" agora é um SELECT --%>
                Empresa (CNPJ):
                <select name="idPEJ" required>
                    <option value="" disabled>Selecione uma empresa</option>
                    <% for (Object obj : pessoasJuridicas) {
                        PessoaJuridica pj = (PessoaJuridica) obj;
                        // Verifica se o ID da Pessoa Jurídica da lista é o mesmo que está salvo no Ponto de Reciclagem
                        String selecionado = (pj.getId() == ponto.getIdPEJ()) ? "selected" : "";
                    %>
                        <option value="<%= pj.getId() %>" <%= selecionado %>>
                            <%= pj.getCnpj() %>
                        </option> 
                    <% } %>
                </select>
                <br><br>

                <%-- O campo "Nome" continua sendo um input de texto --%>
                Nome do Ponto: 
                <input type="text" name="nome" value="<%= ponto.getNome() %>" required>
                <br><br>
                
                <%-- Campo oculto para enviar o ID (chave primária) do PontoReciclagem --%>
                <input type="hidden" name="id" value="<%= ponto.getId() %>">
                
                <input type="submit" name="Enviar" value="Alterar">
            </form>
       </div>
    </body>
</html>

