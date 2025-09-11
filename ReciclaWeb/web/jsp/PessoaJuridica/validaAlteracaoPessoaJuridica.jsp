<%-- 
    Document   : validaAltercaoPessoaJuridica
    Created on : 6 de set. de 2025
    Author     : Vitoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    try {
        // Pega os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String cnpj = request.getParameter("cnpj");
        String inscEst = request.getParameter("inscEst");

        // Controller
        ControllerPessoaJuridica controller = new ControllerPessoaJuridica();

        // Busca o objeto existente no banco
        PessoaJuridica pj = (PessoaJuridica) controller.buscar(id);

        if (pj != null) {
            // Atualiza com os novos valores
            pj.setCnpj(cnpj);
            pj.setInscEst(inscEst);

            // Salva no banco
            controller.alterar(pj);

            // Redireciona para consulta
            String url = "validaConsultaPessoaJuridica.jsp?FILTRO=" + cnpj;
            response.sendRedirect(url);
        } else {
            out.print("Pessoa Jurídica com ID " + id + " não encontrada.");
        }

    } catch (Exception e) {
    String msg = "Erro ao alterar Pessoa Jurídica: " + e.getMessage();
    request.setAttribute("erro", msg);
    request.getRequestDispatcher("paginaErro.jsp").forward(request, response);
 }

%>
