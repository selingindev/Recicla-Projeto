<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    String cod = request.getParameter("CODIGO");
    int id = Integer.parseInt(cod);
    PontoReciclagem sis = new PontoReciclagem(id);
    ControllerParametro sisCont = new ControllerParametro();
    sis = (PontoReciclagem) sisCont.buscar(id);
%>

<html>
    <title>Alterar - Parametro</title>
    <body>
       <div class="container"/>
       <h1>Alterar Parametro</h1>
        <form name="alterarParametro" action="validaAlterarParametro.jsp" method="post">
            Nome: <input type="text" name="DESCRICAO" value="<%=sis.getDescricao()%>"> <br>
             <input type="HIDDEN" name="CODIGO" value="<%=sis.getId()%>"> <br>
             
            <input type="submit" name="Enviar" value="Enviar">
        </form>
        <div>
    </body>
</html>
