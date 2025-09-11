<%--
    Document   : validaAlteracaoPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // Pegando os parâmetros.
    String idParam = request.getParameter("ID");
    String idPesParam = request.getParameter("IDPES");
    String cnpj = request.getParameter("CNPJ"); // Pegamos o CNPJ
    String inscEstParam = request.getParameter("INSCEST");

    int id;
    int idPes;
    String inscEst = "";



    try {
        // Convertendo os valores numéricos.
        id = Integer.parseInt(idParam);
        idPes = Integer.parseInt(idPesParam);

        if (inscEstParam != null && !inscEstParam.trim().isEmpty()) {
            inscEst = inscEstParam;  // Aqui inscEst é String, igual na classe!
        }

    } catch (NumberFormatException e) {
        System.err.println("Erro de conversão de número: " + e.getMessage());
        // response.sendRedirect("paginaDeErro.jsp?erro=DadosInvalidos");
        return; // Para a execução
    }

    // Se o código chegou até aqui, os dados são válidos.
    System.out.println("Todos os dados validados. Criando objeto...");

    // Criando o objeto PessoaJuridica com os tipos corretos.
    PessoaJuridica pj = new PessoaJuridica(id, idPes, cnpj, inscEst);
    
    // Instanciando o controller e executando a alteração.
    ControllerPessoaJuridica pjCont = new ControllerPessoaJuridica();
    pjCont.alterar(pj);

    // Redirecionando para a página de consulta.
    String url = "consultaPessoaJuridica.jsp?FILTRO=" + cnpj;
    response.sendRedirect(url);
%>


