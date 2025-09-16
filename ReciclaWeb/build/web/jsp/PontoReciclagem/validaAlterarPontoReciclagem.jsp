<%-- 
    Document   : validaAlterarPontoReciclagem
    Description: Recebe os dados do formulário, valida, monta o objeto e chama o controller para alterar.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.PontoReciclagem"%>
<%@page import="reciclabackend.controller.ControllerPontoReciclagem"%>

<%
    try {
        // 1. Obter TODOS os parâmetros do formulário.
        // É crucial que os nomes ("id", "idPEJ", "nome") correspondam aos 'name' dos campos no formulário.
        String idParam = request.getParameter("id");
        String idPEJParam = request.getParameter("idPEJ");
        String nomeParam = request.getParameter("nome");

        // 2. Validar que os parâmetros não são nulos ou vazios para evitar erros.
        if (idParam == null || idPEJParam == null || nomeParam == null || 
            idParam.isEmpty() || idPEJParam.isEmpty() || nomeParam.isEmpty()) {
            
            // Redireciona de volta com uma mensagem de erro clara.
            String idErro = (idParam != null && !idParam.isEmpty()) ? idParam : "0";
            String url = "alterarPontoReciclagem.jsp?id=" + idErro + "&erro=" + java.net.URLEncoder.encode("Todos os campos são obrigatórios.", "UTF-8");
            response.sendRedirect(url);
            return; // Interrompe a execução da página.
        }
        
        // 3. Converter os parâmetros para os tipos corretos (int).
        int id = Integer.parseInt(idParam);
        int idPEJ = Integer.parseInt(idPEJParam);
        String nome = nomeParam;
        
        // 4. Criar o objeto PontoReciclagem com TODOS os dados necessários para o UPDATE.
        PontoReciclagem pontoParaAlterar = new PontoReciclagem();
        pontoParaAlterar.setId(id);       // O ID é essencial para a cláusula WHERE da query.
        pontoParaAlterar.setIdPEJ(idPEJ); // Novo valor
        pontoParaAlterar.setNome(nome);   // Novo valor

        // 5. Instanciar o controller e chamar o método de alteração.
        ControllerPontoReciclagem controller = new ControllerPontoReciclagem();
        controller.alterar(pontoParaAlterar);
        
        // 6. Se tudo correu bem, redireciona para a página de listagem.
        response.sendRedirect("listarPontoReciclagem.jsp");

    } catch (NumberFormatException nfe) {
        // Erro específico se 'id' ou 'idPEJ' não forem números válidos.
        String idErro = request.getParameter("id") != null ? request.getParameter("id") : "0";
        String mensagemErro = "Erro: ID ou Código da Empresa inválido. Devem ser números.";
        String url = "alterarPontoReciclagem.jsp?id=" + idErro + "&erro=" + java.net.URLEncoder.encode(mensagemErro, "UTF-8");
        response.sendRedirect(url);
    } catch (Exception e) {
        // Captura qualquer outro erro (ex: erro de SQL vindo do DAO).
        String idErro = request.getParameter("id") != null ? request.getParameter("id") : "0";
        String mensagemErro = "Ocorreu um erro inesperado ao alterar: " + e.getMessage();
        String url = "alterarPontoReciclagem.jsp?id=" + idErro + "&erro=" + java.net.URLEncoder.encode(mensagemErro, "UTF-8");
        response.sendRedirect(url);
    }
%>

