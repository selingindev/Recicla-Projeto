<%-- 
    Document   : newjsp
    Created on : 3 de set. de 2025, 23:23:22
    Author     : ArthurSelingin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

<%
    String id = request.getParameter("id");
    Logradouro log = null;
    String pbusca = request.getParameter("PBUSCA");

    if (id != null && !id.trim().isEmpty()) {
        try {
            Integer idInt = Integer.parseInt(id);
            ControllerLogradouro logCont = new ControllerLogradouro();
            log = (Logradouro) logCont.buscar(idInt);
        } catch (Exception e) {
            log = null;
        }
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>ALTERAR - LOGRADOURO</title>
    </head>
    <body>
       <div class="container">
            <h1>ALTERAR LOGRADOURO</h1>

            <!--primeiro campo: ID do logradouro -->
            <form name="buscarLogradouro" method="get">
                <label for="id">ID do Logradouro:</label>
                <input type="text" name="id" id="id" value="<%= (id != null ? id : "") %>">
                  <button class="btn waves-effect waves-light" type="submit">
                 Alterar
                </button>
            </form>
            <br>
 <br> <br>
         <br>
            <%
                if (log != null) {
            %>
              <form name="alterarLogradouro" action="validaAlterarLogradouro.jsp" method="post">
    <label for="cep">CEP:</label>
    <input type="text" id="cep" name="CEP" value="<%= log.getCep() %>"> 
    <br>

    <label for="numero">Número:</label>
    <input type="text" id="numero" name="NUMERO" value="<%= log.getNumero() %>"> 
    <br>

    <label for="complApi">Complemento API:</label>
    <input type="text" id="complApi" name="COMPL_API" value="<%= log.getComplementoApi() %>"> 
    <br>

    <label for="complOutros">Complemento Outros:</label>
    <input type="text" id="complOutros" name="COMPL_OUTROS" value="<%= log.getComplementoOutros() %>"> 
    <br>

    <input type="hidden" name="ID" value="<%= log.getId() %>"> 
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
