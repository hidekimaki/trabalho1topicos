<%-- 
    Document   : register
    Created on : 20/09/2018, 13:29:41
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register!</h1>
        <form id="form_27659" class="appnitro"  method="post" action="/formbuilder/view.php">
            <li id="li_1" >
                <label for="element_1">Nome: </label>
                <div>
                    <input id="element_1" name="p.name" type="text" maxlength="255" value=""/> 
                </div> 
            </li>		
            <li id="li_2" >
                <label  for="element_2">Usuario: </label>
                <div>
                    <input id="element_2" name="p.user" type="text" maxlength="255" value=""/> 
                </div> 
            </li>		
            <li id="li_3" >
                <label for="element_3">Senha: </label>
                <div>
                    <input id="element_3" name="p.pass" type="password" maxlength="255" value=""/> 
                </div> 
            </li>	    
            <input id="saveForm" type="submit" name="submit" value="Registrar" />
        </form>	
    </body>
</html>
