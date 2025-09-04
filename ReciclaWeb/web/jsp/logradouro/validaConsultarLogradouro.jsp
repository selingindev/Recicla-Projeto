<%-- 
    Document   : inserirLogradouro
    Created on : 4 de set. de 2025, 13:10:30
    Author     : ArthurSelingin
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Usuario"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>
<%
    String cep = request.getParameter("CEP");
    ControllerLogradouro logcont = new ControllerLogradouro();
    List<Object> listaLogradouro = logcont.listar(cep);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + cep +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA DE LOGRADOUROS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Cep">Cep</th>
                  <th data-field="Numero">Numero</th>
                  <th data-field="Compl_Api">Compl_Api</th>
                  <th data-field="Compl_Api">Compl_Outros</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaLogradouro.isEmpty())) { %>    
                <tbody>
                    <% for (Object logObj : listaLogradouro) {
                        Logradouro logSaida = (Logradouro) logObj;
                    %>
                    <tr>
                            <td><%=logSaida.getId()%></td>
                            <td><%=logSaida.getCep()%></td>
                            <td><%=logSaida.getNumero()%></td>
                            <td><%=logSaida.getComplementoApi()%></td>
                            <td><%=logSaida.getComplementoOutros()%></td>

                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirLogradouro.jsp?<%=url + logSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarLogradouro.jsp?<%=url + logSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>