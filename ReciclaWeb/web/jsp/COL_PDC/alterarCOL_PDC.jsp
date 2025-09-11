<%-- 
    Document   : alterarColPdc
    Created on : 10 de set. de 2025
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.ColPdc"%>
<%@page import="reciclabackend.controller.ControllerColPdc"%>

<%
    String id = request.getParameter("id");
    ColPdc colPdc = null;
    String pbusca = request.getParameter("PBUSCA");

    if (id != null && !id.trim().isEmpty()) {
        try {
            Integer idInt = Integer.parseInt(id);
            ControllerColPdc colPdcCont = new ControllerColPdc();
            colPdc = (ColPdc) colPdcCont.buscar(idInt);
        } catch (Exception e) {
            colPdc = null;
        }
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>ALTERAR - COL_PDC</title>
    </head>
    <body>
       <div class="container">
            <h1>ALTERAR COL_PDC</h1>

            <!-- Campo para buscar pelo ID -->
            <form name="buscarColPdc" method="get">
                <label for="id">ID do Col_Pdc:</label>
                <input type="text" name="id" id="id" value="<%= (id != null ? id : "") %>">
                <button class="btn waves-effect waves-light" type="submit">
                    Alterar
                </button>
            </form>
            <br><br><br><br>

            <%
                if (colPdc != null) {
            %>
              <form name="alterarColPdc" action="validaAlterarColPdc.jsp" method="post">

                <!-- ID oculto -->
                <input type="hidden" id="id" name="ID" value="<%= colPdc.getId() %>">

                <label for="idCol">ID do Colaborador:</label>
                <input type="text" id="idCol" name="IDCOL" value="<%= colPdc.getIdCol() %>">
                <br>

                <label for="idPdc">ID do Ponto de Coleta:</label>
                <input type="text" id="idPdc" name="IDPDC" value="<%= colPdc.getIdPdc() %>">
                <br>

                <label for="data">Data:</label>
                <input type="text" id="data" name="DATA" value="<%= colPdc.getData() %>">
                <br>

                <input type="hidden" name="PBUSCA" value="<%= (pbusca != null ? pbusca : "") %>"> 

                <button class="btn waves-effect waves-light" type="submit">
                    Alterar
                </button>
              </form>
            <%
                }
            %>
        </div>
    </body>
</html>
