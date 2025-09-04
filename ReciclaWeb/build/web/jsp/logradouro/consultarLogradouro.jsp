<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - LOGRADOURO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR LOGRADOURO</h1>
       <form name="consultarLogradouro" action="validaConsultarLogradouro.jsp" method="post">
            <div class="input-field">
                    <label for="cep">CEP</label>
                    <input type="text" id="cep" name="CEP" required>
                </div>
                <button class="btn waves-effect waves-light" type="submit">
                    Buscar
                </button>
       </form>
       </div>
    </body>
</html>
