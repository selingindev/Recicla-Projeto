<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - PESSOA</title>
    <body>
        <div class="container"/>
        <h1>INSERIR PESSOA</h1>
        <form name="inserirPessoa" action="validaInserirPessoa.jsp" method="post">
            <table>
                <tr>
                    <td>
                        Nome:
                    </td>
                    <td>
                        <input type="text" name="NOME" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="EMAIL" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Fone:
                    </td>
                    <td>
                        <input type="text" name="FONE" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cep:
                    </td>
                    <td>
                        <input type="text" name="CEP" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Numero:
                    </td>
                    <td>
                        <input type="text" name="NUM" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Complemento:
                    </td>
                    <td>
                        <input type="text" name="COMPL" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cpf:
                    </td>
                    <td>
                        <input type="text" name="CPF" value="">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cnpj:
                    </td>
                    <td>
                        <input type="text" name="CNPJ" value="">
                    </td>
                </tr>
            </table>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>