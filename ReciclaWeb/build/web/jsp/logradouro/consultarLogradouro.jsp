<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - LOGRADOURO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR LOGRADOURO</h1>
       <form name="consultarLogradouro" action="validaConsultarLogradouro.jsp" method="post">
           CEP <input type="text" name ="CEP" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
