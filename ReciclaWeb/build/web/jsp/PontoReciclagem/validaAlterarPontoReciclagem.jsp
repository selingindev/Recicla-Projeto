<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    // 1. Pega os dados do formulário de alteração
    int id = Integer.parseInt(request.getParameter("id"));
    int idPEJ = Integer.parseInt(request.getParameter("idPEJ"));
    String nome = request.getParameter("nome");
    
    // 2. Cria o objeto PontoReciclagem com todos os dados
    PontoReciclagem pontoEntrada = new PontoReciclagem(id, idPEJ, nome);
    
    // 3. Usa o Controller de PontoReciclagem para alterar
    ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
    controller.alterar(pontoEntrada);
    
    // 4. REDIRECIONA PARA A PAGINA DE LISTAGEM CORRETA
    String url = "listarPontoReciclagem.jsp";
    response.sendRedirect(url);
%>
