<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.controller.ControllerPEF_PDC"%>
<%@page import="reciclabackend.model.bean.PefPdc"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    ControllerPEF_PDC controller = new ControllerPEF_PDC();
    PefPdc relacao = (PefPdc) controller.buscar(id);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dataFormatada = sdf.format(relacao.getData());
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>Editar Relação Pessoa FÃ­sica - Ponto de Coleta</title>
    <body>
        <div class="container">
            <h1>Editar Relação Pessoa Física - Ponto de Coleta</h1>
            <form action="atualizarRelacaoPEF_PDC.jsp" method="POST">
                <input type="hidden" name="id" value="<%= relacao.getId()%>">
                <label for="idPef">Pessoa Física</label>
                <input type="text" id="idPef" name="idPef" value="<%= relacao.getIdPef()%>">
                <label for="idPdc">Ponto de Coleta:</label>
                <input type="text" id="idPdc" name="idPdc" value="<%= relacao.getIdPdc()%>">
                <label for="cod">Código:</label>
                <input type="text" id="cod" name="cod" value="<%= relacao.getCod()%>">
                <label for="quant">Quantidade:</label>
                <input type="text" id="quant" name="quant" value="<%= relacao.getQuant()%>">
                <label for="data">Data:</label>
                <input type="date" id="data" name="data" value="<%= dataFormatada%>">
                <input type="submit" value="Atualizar">
            </form>
        </div>
    </body>
</html>