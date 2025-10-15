<%-- 
    Document   : validaConsultarPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Usuario"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // Pega o CNPJ passado como parâmetro
    String cnpj = request.getParameter("CNPJ");

    // Busca usando o controller
    ControllerPessoaJuridica pjCont = new ControllerPessoaJuridica();
    List<Object> listaPJ = pjCont.listar(cnpj);

    // Usuário logado da sessão
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");

    String url = "PBUSCA=" + cnpj + "&ID=";
%>

<html>
  <head>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA DE PESSOAS JURÍDICAS</title>
  </head>
  <body>
    <table class="striped responsive-table">
      <thead>
        <tr>
          <th data-field="Id">ID</th>
          <th data-field="IdPes">ID Pessoa</th>
          <th data-field="CNPJ">CNPJ</th>
          <th data-field="InscEst">Inscrição Estadual</th>
          <th data-field="Excluir">Excluir</th>
          <th data-field="Alterar">Alterar</th>
        </tr>
      </thead>
      <% if (listaPJ != null && !listaPJ.isEmpty()) { %>
        <tbody>
          <% for (Object pjObj : listaPJ) {
     PessoaJuridica pjSaida = (PessoaJuridica) pjObj;
%>
            <tr>
              <td><%= pjSaida.getId() %></td>
              <td><%= pjSaida.getIdPes() %></td>
              <td><%= pjSaida.getCnpj() %></td>
              <td><%= pjSaida.getInscEst() %></td>

              <% if (usuLogado != null && "ADM".equals(usuLogado.getTipo())) { %>
                <td><a href="excluirPessoaJuridica.jsp?<%= url + pjSaida.getId() %>">Excluir</a></td>
                <td><a href="alterarPessoaJuridica.jsp?<%= url + pjSaida.getId() %>">Alterar</a></td>
              <% } %>
            </tr>
          <% } %>
        </tbody>
      <% } else { %>
        <tbody>
          <tr>
            <td colspan="6">Nenhuma Pessoa Jurídica encontrada para o CNPJ <%= cnpj %>.</td>
          </tr>
        </tbody>
      <% } %>
    </table>
  </body>
</html>
