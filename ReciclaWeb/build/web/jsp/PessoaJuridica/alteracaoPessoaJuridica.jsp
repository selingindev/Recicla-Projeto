<%--
    Document   : alterarPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%

    String id = request.getParameter("ID");
    pessoaJuridica pj = null;
    String CNPJ = request.getParameter("CNPJ");


    if (id != null && !id.isEmpty()) {
        int idInt = Integer.parseInt(id);
        ControllerPessoaJuridica controller = new ControllerPessoaJuridica();
        pj = controller.buscarPorId(idInt);
    }
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <head>
        <title>ALTERAR - PESSOA JURÍDICA</title>
    </head>
    <body>
        <div class="container">
            <h1>ALTERAR PESSOA JURÍDICA</h1>

            <!-- formulário para buscar pelo ID -->
            <form name="buscarPessoaJuridica" method="get">
                <label for="id">ID da Pessoa Jurídica:</label>
                <input type="text" name="ID" id="id" value="<%= (id != null ? id : "") %>">
                <button class="btn waves-effect waves-light" type="submit">
                    Buscar
                </button>
            </form>
            <br>
            <% if (pj != null) { %>
                <form name="alterarPessoaJuridica" action="validaAltercaoPessoaJuridica.jsp" method="POST">

                    <input type="hidden" name="id" value="<%= pj.getId() %>">

                    <label for="cnpj">CNPJ:</label>
                    <input type="text" name="cnpj" id="cnpj" value="<%= pj.getCnpj() %>" required><br><br>

                    <label for="inscEst">Senha:</label>
                    <input type="text" name="inscEst" id="INSCEST" value="<%= pj.getInscEst() %>" required><br><br>

                    <button class="btn waves-effect waves-light" type="submit">
                        Alterar
                   </button>
            </button>
         </form>
         <% } %>
      </div>
     </body>
    </html>
