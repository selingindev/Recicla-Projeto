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
<head>
    <title>SISTEMA</title>
</head>
<body>
    <% if (usuSaida != null) { %>
        <!-- Botões Dropdown -->
        <a class='dropdown-button btn' href='#' data-activates='dropdownUsuario'>Gerenciar Usuário</a>        
        <a class='dropdown-button btn' href='#' data-activates='dropdownProduto'>Gerenciar Produto</a>        
        <a class='dropdown-button btn' href='#' data-activates='dropdownRelacoes'>Gerenciar Relações Usuário e Produto</a>       
        <a class='dropdown-button btn' href='#' data-activates='dropdownLogradouro'>Gerenciar Logradouro</a>  
        <a class='dropdown-button btn' href='#' data-activates='dropdownPessoa'>Gerenciar Pessoa</a>  
        <a class='dropdown-button btn' href='#' data-activates='dropdownPJ'>Gerenciar PJ</a>  
        <a class='dropdown-button btn' href='#' data-activates='dropdownPEF_PDC'>Gerenciar PEF_PDC</a>  
        <a class='dropdown-button btn' href='#' data-activates='dropdownPontoReciclagem'>Gerenciar Ponto de Reciclagem</a>
        <a class='dropdown-button btn' href='#' data-activates='dropdownParametros'>Gerenciar Parâmetros</a>
        <a class='dropdown-button btn' href='#' data-activates='dropdownColPDC'>Gerenciar ColPDC</a>
        <a class='dropdown-button btn' href='#' data-activates='dropdownPDC'>Gerenciar PDC</a>

        <!-- Dropdown Usuário -->
        <ul id='dropdownUsuario' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuário </a></li>
            <% } %>
            <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
        </ul>

        <!-- Dropdown Produto -->
        <ul id='dropdownProduto' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../produto/inserirProduto.jsp"> Inserir Produto </a></li>
            <% } %>
            <li><a href="../produto/consultarProduto.jsp"> Consultar Produto </a></li>
        </ul>

        <!-- Dropdown Relações -->
        <ul id='dropdownRelacoes' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../usuarioProduto/inserirRelacaoUsuarioProduto.jsp"> Inserir Relação Usuário e Produto </a></li>
            <% } %>
            <li><a href="../usuarioProduto/consultarRelacaoUsuarioProduto.jsp"> Consultar Relação </a></li>
        </ul>

        <!-- Dropdown Logradouro -->
        <ul id='dropdownLogradouro' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../logradouro/inserirLogradouro.jsp"> Inserir Logradouro </a></li>
            <% } %>
            <li><a href="../logradouro/consultarLogradouro.jsp"> Consultar Logradouro </a></li>
        </ul>

        <!-- Dropdown Pessoa -->
        <ul id='dropdownPessoa' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../pessoa/inserirPessoa.jsp"> Inserir Pessoa </a></li>
            <% } %>
            <li><a href="../pessoa/consultarPessoa.jsp"> Consultar Pessoa </a></li>
        </ul>

        <!-- Dropdown Pessoa Jurídica -->
        <ul id='dropdownPJ' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../PessoaJuridica/inserirPessoaJuridica.jsp"> Inserir PJ </a></li>
            <% } %>
            <li><a href="../PessoaJuridica/consultaPessoaJuridica.jsp"> Consultar PJ</a></li>
        </ul>

        <!-- Dropdown PEF_PDC -->
        <ul id='dropdownPEF_PDC' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../PEF_PDC/inserirRelacaoPEF_PDC.jsp"> Inserir PEF_PDC </a></li>
            <% } %>
            <li><a href="../PEF_PDC/consultarRelacaoPEF_PDC.jsp"> Consultar PEF_PDC</a></li>
        </ul>

        <!-- Dropdown Ponto de Reciclagem -->
        <ul id='dropdownPontoReciclagem' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../PontoReciclagem/inserirPontoReciclagem.jsp"> Inserir Ponto de Reciclagem </a></li>
            <% } %>
            <li><a href="../PontoReciclagem/listarPontoReciclagem.jsp"> Consultar Pontos de Reciclagem </a></li>
        </ul>

        <!-- Dropdown Parâmetros -->
        <ul id='dropdownParametros' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../parametros/listarParametros.jsp"> Listar Parâmetro </a></li>
            <% } %>
        </ul>

        <!-- Dropdown ColPDC -->
        <ul id='dropdownColPDC' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../COL_PDC/inserirCOL_PDC.jsp"> Inserir ColPDC </a></li>
            <% } %>
            <li><a href="../COL_PDC/consultarCOL_PDC.jsp"> Consultar ColPDC </a></li>
        </ul>

        <!-- Dropdown PDC -->
        <ul id='dropdownPDC' class='dropdown-content'>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <li><a href="../PontoColeta/inserirPontoColeta.jsp"> Inserir PDC </a></li>
            <% } %>
            <li><a href="../PontoColeta/consultarPontoColeta.jsp"> Consultar PDC </a></li>
        </ul>

    <% } else { %>
        <h1>USUÁRIO INVÁLIDO</h1>
    <% } %>
</body>
</html>
