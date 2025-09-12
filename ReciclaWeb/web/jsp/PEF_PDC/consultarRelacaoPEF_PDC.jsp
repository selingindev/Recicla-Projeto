<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>
<%@page import="reciclabackend.model.bean.PefPdc"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>

<%
    ControllerPEF_PDC controller = new ControllerPEF_PDC();
    List<Object> listaRelacoes = controller.listar("");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Consultar Relação Pessoa Física - Ponto de Coleta</title>
    <body>
        <div class="container">
            <div class="row center-align">
                <h3>Relações Pessoa Física - Ponto de Coleta</h3>
            </div>

            <div class="row">
                <div class="col s12 center-align">
                    <a href="inserirRelacaoPEF_PDC.jsp" class="btn-large">Nova Relação</a>
                </div>
            </div>

            <div class="row"><div class="col s12"><br></div></div>

            <div class="row">
                <div class="col s12">
                    <table class="striped centered responsive-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Pessoa Física</th>
                                <th>Ponto de Coleta</th>
                                <th>Código</th>
                                <th>Quantidade</th>
                                <th>Data</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Object obj : listaRelacoes) {
                                    PefPdc relacao = (PefPdc) obj;
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    String dataFormatada = sdf.format(relacao.getData());
                            %>
                            <tr>
                                <td><%= relacao.getId()%></td>
                                <td><%= relacao.getIdPef()%></td>
                                <td><%= relacao.getIdPdc()%></td>
                                <td><%= relacao.getCod()%></td>
                                <td><%= relacao.getQuant()%></td>
                                <td><%= dataFormatada%></td>
                                <td>
                                    <a href="editarRelacaoPEF_PDC.jsp?id=<%= relacao.getId()%>" class="btn-small">Editar</a>
                                    <a href="excluirRelacaoPEF_PDC.jsp?id=<%= relacao.getId()%>" class="btn-small" onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>