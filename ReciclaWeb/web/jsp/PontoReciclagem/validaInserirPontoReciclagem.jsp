<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    // 1. Pega os parâmetros do formulário com os nomes corretos
    // Estes nomes ("idPEJ", "nome") devem ser os mesmos usados no <input name="..."> do formulário.
    int idPEJ = Integer.parseInt(request.getParameter("idPEJ"));
    String nome = request.getParameter("nome");
    
    // 2. Cria o objeto PontoReciclagem usando o construtor apropriado do seu bean:
    // new PontoReciclagem(int idPEJ, String nome)
    PontoReciclagem pontoEntrada = new PontoReciclagem(idPEJ, nome);
    
    // 3. Usa o Controller de PontoReciclagem para realizar a operação
    ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
    controller.inserir(pontoEntrada);
    
    // 4. REDIRECIONA PARA A PÁGINA DE LISTAGEM CORRETA
    // Você precisará criar a página "listarPontoReciclagem.jsp"
    String url = "listarPontoReciclagem.jsp";
    response.sendRedirect(url);
%>

