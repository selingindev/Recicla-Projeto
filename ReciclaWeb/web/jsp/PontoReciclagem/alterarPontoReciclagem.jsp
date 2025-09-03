<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    String cod = request.getParameter("CODIGO");
    int id = Integer.parseInt(cod);
    PontoReciclagem sis = new PontoReciclagem(id);
    ControllerPontoReciclagem sisCont = new ControllerPontoReciclagem();
    sis = (PontoReciclagem) sisCont.buscar(id);
%>

<html>
    <title>Alterar - Ponto de Reciclagem</title>
    <body>
       <div class="container"/>
       <h1>Alterar Ponto de Reciclagem</h1>
        <form name="alterarPontoReciclagem" action="validaAlterarPontoReciclagem.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=sis.getNome()%>"> <br>
             <input type="HIDDEN" name="CODIGO" value="<%=sis.getId()%>"> <br>
             
            <input type="submit" name="Enviar" value="Enviar">
        </form>
        <div>
    </body>
</html>
