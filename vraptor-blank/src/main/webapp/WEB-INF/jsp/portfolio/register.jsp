<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/includes/header.jsp" />     


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
