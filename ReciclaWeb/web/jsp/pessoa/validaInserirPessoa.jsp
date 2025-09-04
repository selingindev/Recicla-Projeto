<%@page import="descartebackend.model.dado.PessoaJuridica"%>
<%@page import="descartebackend.controller.ControllerPessoaJuridica"%>
<%@page import="descartebackend.model.dado.PessoaFisica"%>
<%@page import="descartebackend.controller.ControllerPessoaFisica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="descartebackend.model.dado.Pessoa"%>
<%@page import="descartebackend.model.dado.Logradouro"%>
<%@page import="descartebackend.controller.ControllerPessoa"%>
<%@page import="descartebackend.controller.ControllerLogradouro"%>

<%

    String nome = request.getParameter("NOME");
    String email = request.getParameter("EMAIL");
    String fone = request.getParameter("FONE");
    String cep = request.getParameter("CEP");
    String numero = request.getParameter("NUM");
    String complemento_outros = request.getParameter("COMPL");
    String cpf = request.getParameter("CPF");
    String cnpj = request.getParameter("CNPJ");

    ControllerLogradouro contLog = new ControllerLogradouro();
    Logradouro logEnt = new Logradouro(cep, numero, "", complemento_outros);
    Logradouro logSaida = (Logradouro) contLog.Inserir(logEnt);

    ControllerPessoa pescont = new ControllerPessoa();
    Pessoa pEnt = new Pessoa(logSaida.getId(), nome, email, fone);
    Pessoa pSaida = (Pessoa) pescont.Inserir(pEnt);
    
    if(cpf.trim().length() > 0) {
        ControllerPessoaFisica pesfcont = new ControllerPessoaFisica();
        PessoaFisica pFEnt = new PessoaFisica(pSaida.getId(), cpf, "");
        pesfcont.Inserir(pFEnt);
    } else {
        ControllerPessoaJuridica pesjcont = new ControllerPessoaJuridica();
        PessoaJuridica pJEnt = new PessoaJuridica(pSaida.getId(), cnpj, "");
        pesjcont.Inserir(pJEnt);
    }

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "../pessoa/inserirPessoa.jsp";
    response.sendRedirect(url);
%>
