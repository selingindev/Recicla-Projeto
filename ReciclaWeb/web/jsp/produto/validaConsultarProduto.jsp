<%-- 
    Document   : validaConsultarProduto
    Created on : 11 Sept 2025, 14:31:00
    Author     : liahd
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%@page import="reciclabackend.model.bean.Usuario"%>
<%@page import="reciclabackend.model.bean.Material"%>
<%@page import="reciclabackend.controller.ControllerMaterial"%>
<%
    String mat = request.getParameter("MAT");
    ControllerMaterial matCont = new ControllerMaterial();
    List<Object> listaMaterial = matCont.listar(mat);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + mat +"&ID=";
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA DE MATERIAIS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Cep">Nome</th>
                  <th data-field="Numero">Descrição</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaMaterial.isEmpty())) { %>    
                <tbody>
                    <% for (Object logObj : listaMaterial) {
                        Material logSaida = (Material) logObj;
                    %>
                    <tr>
                            <td><%=logSaida.getId()%></td>
                            <td><%=logSaida.getNome()%></td>
                            <td><%=logSaida.getDescricao()%></td>

                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirMaterial.jsp?<%=url + logSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarMaterial.jsp?<%=url + logSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>
