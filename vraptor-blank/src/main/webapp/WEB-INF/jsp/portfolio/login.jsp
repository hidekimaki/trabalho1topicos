<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/includes/header.jsp" />     
        <div style="
            position: absolute;
            width: 300px;
            height: 100px;
            top: 50%; 
            left: 50%;
            margin: -100px 0 0 -150px;
            ">
            <form action="${linkTo[PortfolioController].autenticar}" method="POST">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Usuario</span>
                </div>
                <input type="text" class="form-control" name="p.user"  aria-label="Username" aria-describedby="basic-addon1">
            </div>
            
            <div class="input-group" style="margin-top: 10px">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Senha</span>
                </div>
                <input type="text" class="form-control" name="p.pass"  aria-label="Username" aria-describedby="basic-addon1">
            </div>
            
            <button style="margin-top: 10px" type="submit" class="btn btn-primary form-control">Login</button>
        </form>
            <br>
            <center>Novo por aqui ? <a href="${linkTo[PortfolioController].register}">Registre-se!</a></center>
</div>
