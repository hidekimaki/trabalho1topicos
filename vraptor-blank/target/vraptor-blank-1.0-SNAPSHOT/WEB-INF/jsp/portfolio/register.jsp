<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/includes/header.jsp" /> 
        <div style="z-index: -1; position: absolute; width: 500px; height: 100px; top: 40%; left: 50%; margin: -100px 0 0 -250px;">
            <h3>Registro</h3>
            <div class="progress" style=" height: 5px;">
                <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>
            <form action="${linkTo[PortfolioController].save}" method="POST">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Seu Nome</span>
                    </div>
                    <input type="text" class="form-control" name="p.name"  aria-label="Nome" aria-describedby="basic-addon1">
                </div>

                <div class="input-group"style="margin-top: 10px">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Usuario</span>
                    </div>
                    <input type="text" class="form-control" name="p.user"  aria-label="Nome" aria-describedby="basic-addon1">
                </div>

                <div class="input-group" style="margin-top: 10px">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Senha</span>
                    </div>
                    <input type="pass" class="form-control" name="p.pass"  aria-label="Nome" aria-describedby="basic-addon1">
                </div>


                <button style="margin-top: 10px" type="submit" class="btn btn-primary form-control">Salvar</button>
            </form>
        </div>
    </body>
</html>

