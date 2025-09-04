<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

<%
    
    int id = Integer.parseInt(request.getParameter("id"));
    ControllerLogradouro logCont = new ControllerLogradouro();
    Logradouro log = (Logradouro) logCont.buscar(id);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LOGRADOURO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR LOGRADOURO</h1>
        <form name="alterarLogradouro" action="validaAlterarLogradouro.jsp" method="post">
            Cep: <input type="text" name="CEP" value="<%=log.getCep()%>"> <br>
            Numero: <input type="text" name="NUMERO" value="<%=log.getNumero()%>"> <br>
            Compl_Api: <input type="text" name="COMPL_API" value="<%=log.getComplementoApi()%>"> <br>
            Compl_Outros: <input type="text" name="COMPL_OUTROS" value="<%=log.getComplementoOutros()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=log.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>