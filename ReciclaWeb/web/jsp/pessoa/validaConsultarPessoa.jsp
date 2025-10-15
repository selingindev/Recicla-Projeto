
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Usuario"%>
<%@page import="reciclabackend.model.bean.Pessoa"%>
<%@page import="reciclabackend.controller.ControllerPessoa"%>

<%
    String nome = request.getParameter("NOME");
    ControllerPessoa pescont = new ControllerPessoa();
    List<Object> listaPessoa = pescont.listar(nome);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA DE PESSOAS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Email">Email</th>
                  <th data-field="Fone">Fone</th>
                  <th data-field="Cep">Cep</th>
              </tr>
            </thead>
            <% if (!(listaPessoa.isEmpty())) { %>    
                <tbody>
                    <% for (Object pesObj : listaPessoa) {
                        Pessoa pesSaida = (Pessoa) pesObj;
                        Logradouro log = (Logradouro) pesSaida.getLog();
                    %>
                    <tr>
                            <td><%=pesSaida.getId()%></td>
                            <td><%=pesSaida.getNome()%></td>
                            <td><%=pesSaida.getTelefone()%></td>
                            <td><%=pesSaida.getEmail()%></td>
                            <td><%=log.getCep()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirPessoa.jsp?<%=url + pesSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarPessoa.jsp?<%=url + pesSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>