<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    // O parâmetro da URL é o ID (chave primária) do registro
    String idString = request.getParameter("id");
    int id = Integer.parseInt(idString);
    
    // Usa o Controller para buscar o objeto completo no banco de dados
    ControllerPontoReciclagem pontoCont = new ControllerPontoReciclagem();
    PontoReciclagem ponto = (PontoReciclagem) pontoCont.buscar(id);
%>

<html>
    <head>
        <title>Alterar - Ponto de Reciclagem</title>
    </head>
    <body>
       <div class="container">
           <h1>Alterar Ponto de Reciclagem</h1>
            <form name="alterarPontoReciclagem" action="validaAlterarPontoReciclagem.jsp" method="post">
                Código: <input type="number" name="idPEJ" value="<%=ponto.getIdPEJ()%>" readonly> <br><br>
                Nome: <input type="text" name="nome" value="<%=ponto.getNome()%>"> <br><br>
                
                <%-- Campo oculto para enviar o ID (chave primária) para a página de validação --%>
                <input type="hidden" name="id" value="<%=ponto.getId()%>">
                
                <input type="submit" name="Enviar" value="Alterar">
            </form>
       </div>
    </body>
</html>
