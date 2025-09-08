<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="reciclabackend.model.bean.PessoaFisica"%>
<%@page import="reciclabackend.controller.ControllerPessoaFisica"%>
<%@page import="reciclabackend.model.bean.PontoColeta"%>
<%@page import="reciclabackend.controller.ControllerPontoColeta"%>
<%@page import="reciclabackend.model.bean.Material"%>
<%@page import="reciclabackend.controller.ControllerMaterial"%>
<%@page import="reciclabackend.model.bean.Colaborador"%>
<%@page import="reciclabackend.controller.ControllerColaborador"%>

<%
    ControllerPontoColeta pontoCont = new ControllerPontoColeta();
    List<Object> listaPontos = pontoCont.listar("");

    ControllerPessoaFisica pessoaCont = new ControllerPessoaFisica();
    List<Object> listaPessoas = pessoaCont.listar("");

    ControllerMaterial materialCont = new ControllerMaterial();
    List<Object> listaMateriais = materialCont.listar("");

    ControllerColaborador colaboradorCont = new ControllerColaborador();
    List<Object> listaColaboradores = colaboradorCont.listar("");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR RELAÇÃO PESSOA FÍSICA - PONTO DE COLETA</title>
    <body>
        <div class="container">
            <h1>Inserir Relação Pessoa Física - Ponto de Coleta</h1>
            <form name="inseriRelacaoPEF_PDC" action="validaRelacaoPEF_PDC.jsp" method="POST">
                <table>
                    <tr>
                        <td>Pessoa Física:</td>
                        <td>
                            <select NAME="ID_PEF" class="browser-default">
                                <% for (Object obj : listaPessoas) {
                                        PessoaFisica pf = (PessoaFisica) obj;
                                %>
                                <option value="<%= pf.getId()%>"><%= pf.getCpf()%> - <%= pf.getRg()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Ponto de Coleta:</td>
                        <td>
                            <select NAME="ID_PDC" class="browser-default">
                                <% for (Object obj : listaPontos) {
                                        PontoColeta pc = (PontoColeta) obj;
                                %>
                                <option value="<%= pc.getId()%>"><%= pc.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <!--
                    <tr>
                        <td>Material:</td>
                        <td>
                            <select NAME="ID_MATERIAL" class="browser-default">
                                <% for (Object obj : listaMateriais) {
                                        Material mat = (Material) obj;
                                %>
                                <option value="<%= mat.getId()%>"><%= mat.getNome()%></option>
                                <% } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Colaborador:</td>
                        <td>
                            <select NAME="ID_COLABORADOR" class="browser-default">
                                <% for (Object obj : listaColaboradores) {
                                        Colaborador col = (Colaborador) obj;
                                %>
                                <option value="<%= col.getId()%>"><%= col.getFuncional()%></option>
                                <% }%>
                            </select>
                        </td>
                    </tr>
                    -->
                    <tr>
                        <td>Código:</td>
                        <td><input type="text" name="COD" value=""></td>
                    </tr>
                    <tr>
                        <td>Quantidade:</td>
                        <td><input type="text" name="QUANT" value=""></td>
                    </tr>
                    <tr>
                        <td>Data:</td>
                        <td><input type="date" name="DATA" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  
            </form>
        </div>                     
    </body>
</html>