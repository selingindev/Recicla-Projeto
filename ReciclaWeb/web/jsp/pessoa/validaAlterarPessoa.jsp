<%@page import="descartebackend.model.dado.Logradouro"%>
<%@page import="descartebackend.controller.ControllerLogradouro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="descartebackend.model.dado.Pessoa"%>
<%@page import="descartebackend.controller.ControllerPessoa"%>

<%

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String email = request.getParameter("EMAIL");
    String fone = request.getParameter("FONE");
    String cep = request.getParameter("CEP");
    String numero = request.getParameter("NUM");
    String complemento_outros = request.getParameter("COMPL");

    ControllerLogradouro contLog = new ControllerLogradouro();
    Logradouro logEnt = new Logradouro(cep, numero, "", complemento_outros);
    Logradouro logSaida = (Logradouro) contLog.Inserir(logEnt);

    ControllerPessoa pescont = new ControllerPessoa();
    Pessoa pEnt = new Pessoa(id, logSaida.getId(), nome, email, fone);
    pescont.Alterar(pEnt);
      
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>