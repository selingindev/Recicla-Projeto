<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PessoaJuridica"%>
<%@page import="reciclabackend.controller.ControllerPessoaJuridica"%>

<%
    // Pegando os parâmetros do formulário
    String cnpj = request.getParameter("cnpj");
    String senha = request.getParameter("senha");

    // Instanciando o controller
    ControllerPessoaJuridica controller = new ControllerPessoaJuridica();

 
    PessoaJuridica pj = controller.buscarPorCnpjESenha(cnpj, senha);

    // Encaminha para a página de inserção ou de resultado
    String url = "inserirPessoaJuridica.jsp";
    request.getRequestDispatcher(url).forward(request, response);
%>

