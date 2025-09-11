<%--
    Document   : consultaPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>


<%-- Consulta Pessoa Jurídica --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc"%>
    <title>Consulta Pessoa Jurídica</title>
    <body>
     <div class="container">
      <h1>Consulta Pessoa Jurídica</h1>
        <form name="consultaPessoaJuridica" action="validaConsultarPessoaJuridica.jsp" method="post">
  <div class="input-field">
    <label for="CNPJ">CNPJ ou Razão Social</label>
    <input type="text" id="CNPJ" name="CNPJ" required>
  </div>
  <button class="btn waves-effect waves-light" type="submit">Consultar</button>
</form>

           </div>
    </body>
</html>