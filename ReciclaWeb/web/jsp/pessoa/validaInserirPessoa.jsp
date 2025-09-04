<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>
<%@page import="reciclabackend.model.bean.PessoaFisica"%>
<%@page import="reciclabackend.controller.ControllerPessoaFisica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Pessoa"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerPessoa"%>
<%@page import="reciclabackend.controller.ControllerLogradouro"%>

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
    Logradouro logSaida = (Logradouro) contLog.inserir(logEnt);

    ControllerPessoa pescont = new ControllerPessoa();
    Pessoa pEnt = new Pessoa(nome, logSaida.getId(), email, fone);
    Pessoa pSaida = (Pessoa) pescont.inserir(pEnt);
    
    if(cpf.trim().length() > 0) {
        ControllerPessoaFisica pesfcont = new ControllerPessoaFisica();
        PessoaFisica pFEnt = new PessoaFisica(pSaida.getId(), cpf, "");
        pesfcont.inserir(pFEnt);
    } else {
        ControllerPessoaJuridica pesjcont = new ControllerPessoaJuridica();
        PessoaJuridica pJEnt = new PessoaJuridica(pSaida.getId(), cnpj, "");
        pesjcont.inserir(pJEnt);
    }

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "../pessoa/inserirPessoa.jsp";
    response.sendRedirect(url);
%>
