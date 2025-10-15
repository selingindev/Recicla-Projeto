<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Usuario"%>
<%@page import="reciclabackend.controller.ControllerUsuario"%>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usuEntrada = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validarWeb(usuEntrada);
    session.setAttribute("UsuarioLogado",usuSaida);
%>

<!DOCTYPE html>
<html>
    <title>SISTEMA</title>
    <body>
        <% if (usuSaida != null) { %>
            <!-- Dropdown Triggers -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Gerenciar Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Gerenciar Produto</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Gerenciar Relações Usuário e Produto</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Gerenciar Pessoa Jurídica</a>        

            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuário </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
            <% } %>

            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../produto/inserirProduto.jsp"> Inserir Produto </a></li>
                    <li><a href="../produto/consultarProduto.jsp"> Consultar Produto </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../produto/consultarProduto.jsp"> Consultar Produto </a></li>
                </ul>
            <% } %>

            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown4 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../pessoaJuridica/inserirPessoaJuridica.jsp"> Inserir Pessoa Jurídica </a></li>
                    <li><a href="../pessoaJuridica/consultaPessoaJuridica.jsp"> Consultar Pessoa Jurídica </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../pessoaJuridica/consultaPessoaJuridica.jsp"> Consultar Pessoa Jurídica </a></li>
                </ul>
            <% } %>

        <% } else { %>
            <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>
