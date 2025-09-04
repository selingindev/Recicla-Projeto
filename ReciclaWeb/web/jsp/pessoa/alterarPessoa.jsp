<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="reciclabackend.model.bean.Pessoa"%>
<%@page import="reciclabackend.model.bean.Logradouro"%>
<%@page import="reciclabackend.controller.ControllerPessoa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    ControllerPessoa sisCont = new ControllerPessoa();
    Pessoa pes = (Pessoa) sisCont.buscar(id);
    Logradouro log = (Logradouro) pes.getLog();
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - PESSOA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR PESSOA</h1>
        <form name="alterarPessoa" action="validaAlterarPessoa.jsp" method="post">
            <table>
                <tr>
                    <td>
                        Nome:
                    </td>
                    <td>
                        <input type="text" name="NOME" value="<%=pes.getNome()%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="EMAIL" value="<%=pes.getEmail()%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Fone:
                    </td>
                    <td>
                        <input type="text" name="FONE" value="<%=pes.getTelefone()%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cep:
                    </td>
                    <td>
                        <input type="text" name="CEP" value="<%=log.getCep()%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Numero:
                    </td>
                    <td>
                        <input type="text" name="NUM" value="<%=log.getNumero()%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        Complemento:
                    </td>
                    <td>
                        <input type="text" name="COMPL" value="<%=log.getComplementoOutros()%>">
                    </td>
                </tr>
            </table>
            <input type="HIDDEN" name="ID" value="<%=pes.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>