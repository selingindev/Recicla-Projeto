<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Pessoa"%>
<%@page import="reciclabackend.controller.ControllerPessoa"%>

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
    Logradouro logSaida = (Logradouro) contLog.inserir(logEnt);

    ControllerPessoa pescont = new ControllerPessoa();
    Pessoa pEnt = new Pessoa(id,  nome, logSaida.getId(), email, fone);
    pescont.alterar(pEnt);
      
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarPessoa.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>