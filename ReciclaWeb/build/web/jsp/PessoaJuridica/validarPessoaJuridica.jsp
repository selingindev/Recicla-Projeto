<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // Pegando o parâmetro do formulário
    String idParam = request.getParameter("id");
    PessoaJuridica pj = null;
    String url = "inserirPessoaJuridica.jsp";

    try {
        int id = Integer.parseInt(idParam);

        // Instanciando o controller
        ControllerPessoaJuridica controller = new ControllerPessoaJuridica();

        // Busca pelo id, conforme o controller atual
        pj = (PessoaJuridica) controller.buscar(id);

        // Se encontrou, passa para a próxima página
        request.setAttribute("pessoaJuridica", pj);

    } catch (Exception e) {
        // Em caso de erro, pode encaminhar para uma página de erro, se quiser
        request.setAttribute("erro", "Erro ao buscar Pessoa Jurídica: " + e.getMessage());
        url = "erro.jsp";
    }

    // Encaminha para a página de inserção ou de resultado
    request.getRequestDispatcher(url).forward(request, response);
%>