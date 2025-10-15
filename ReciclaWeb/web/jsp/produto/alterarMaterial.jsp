<%-- 
    Document   : alterarMaterial
    Created on : 11 Sept 2025, 14:41:56
    Author     : liahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Material"%>
<%@page import="reciclabackend.controller.ControllerMaterial"%>

<%
    String id = request.getParameter("id");
    Material log = null;
    String pbusca = request.getParameter("PBUSCA");

    if (id != null && !id.trim().isEmpty()) {
        try {
            Integer idInt = Integer.parseInt(id);
            ControllerMaterial logCont = new ControllerMaterial();
            log = (Material) logCont.buscar(idInt);
        } catch (Exception e) {
            log = null;
        }
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>ALTERAR - MATERIAL</title>
    </head>
    <body>
       <div class="container">
            <h1>ALTERAR MATERIAL</h1>

            <!--primeiro campo: ID do logradouro -->
            <form name="buscarMaterial" method="get">
                <label for="id">ID do Material:</label>
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
              <form name="alterarMaterial" action="validaAlterarProduto.jsp" method="post">
     
      <input type="text" id="id" name="ID" hidden="" value="<%= log.getId() %>"> 
    <br>               
    <label for="cep">Nome:</label>
    <input type="text" id="nome" name="NOME" value="<%= log.getNome() %>"> 
    <br>

    <label for="numero">Descrição:</label>
    <input type="text" id="desc" name="DESCRICAO" value="<%= log.getDescricao() %>"> 
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