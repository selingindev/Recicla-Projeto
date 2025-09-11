<%-- 
    Document   : parametros
    Created on : 30 de ago. de 2025, 15:53:28
    Author     : raife
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Parametro"%>
<%@page import="reciclabackend.controller.ControllerParametro"%>

<%
    String cod = request.getParameter("CODIGO");
    int id = Integer.parseInt(cod);
    Parametro sis = new Parametro(id);
    ControllerParametro sisCont = new ControllerParametro();
    sis = (Parametro) sisCont.buscar(id);
%>

<html>
    <title>Alterar - Parametro</title>
    <head><!-- comment -->
        <style>
            .btn {
                display: inline-block;
                padding: 10px 20px;
                margin: 10px 0;
                background-color: #007bff; /* Cor de fundo do botão */
                color: white; /* Cor do texto */
                text-align: center;
                text-decoration: none; /* Remove o sublinhado */
                border-radius: 5px; /* Bordas arredondadas */
                font-size: 16px;
            }
            .btn-cancelar {
                background-color: red; /* Cor de fundo do botão */
            }
        </style>
    </head>
    <body>
       <div class="container"/>
       <h1>Alterar Parametro</h1>
        <form name="alterarParametro" action="validaAlterarParametro.jsp" method="post">
            Nome: <input type="text" name="DESCRICAO" value="<%=sis.getDescricao()%>"> <br>
             <input type="HIDDEN" name="ID" value="<%=sis.getId()%>"> <br>
             
             <a href="listarParametros.jsp" class="btn btn-cancelar"> Cancelar </a><!-- Listar Parametro -->
            <input type="submit" class="btn" name="Enviar" value="Enviar">
        </form>
        <div>
    </body>
</html>
