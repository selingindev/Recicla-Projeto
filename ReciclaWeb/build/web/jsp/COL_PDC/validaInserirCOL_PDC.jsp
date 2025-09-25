<%@ page import="reciclabackend.controller.ControllerColPdc" %>
<%@ page import="reciclabackend.model.bean.ColPdc" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <%@ include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>VALIDA INSERIR - COL_PDC</title>
    </head>
    <body>
        <div class="container">
            <h1>Resultado da Inserção</h1>
            <%
                String idColParam = request.getParameter("IDCOL");
                String idPdcParam = request.getParameter("IDPDC");
                String dataParam = request.getParameter("DATA"); // espera dd/MM/yyyy

                // Converte data de dd/MM/yyyy para yyyy-MM-dd
                SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                String dataFormatada = formatoBanco.format(formatoBrasileiro.parse(dataParam));

                ControllerColPdc controller = new ControllerColPdc();

                ColPdc novo = new ColPdc(
                    Integer.parseInt(idColParam),
                    Integer.parseInt(idPdcParam),
                    dataFormatada
                );

                ColPdc inserido = (ColPdc) controller.inserir(novo);
            %>
            <p>Registro inserido com sucesso:</p>
            <ul>
                <li>ID: <%= inserido.getId() %></li>
                <li>ID COLABORADOR: <%= inserido.getIdCol() %></li>
                <li>ID PONTO DE COLETA: <%= inserido.getIdPdc() %></li>
                <li>DATA: <%= inserido.getData() %></li>
            </ul>
            <a href="consultarCOL_PDC.jsp">Consultar registros</a>
        </div>
    </body>
</html>
