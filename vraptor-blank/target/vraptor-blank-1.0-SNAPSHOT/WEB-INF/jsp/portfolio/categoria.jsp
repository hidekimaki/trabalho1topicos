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
            width: 600px;
            height: 100px;
            top: 50%; 
            left: 50%;
            margin: -100px 0 0 -300px;
            ">
                    <h3>Adicionar Novo Documento</h3>
                            <div class="progress">
          <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
        </div>
         <br>
         <form action="${linkTo[PortfolioController].autenticar}" method="POST">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Adicionar Nova Categoria</span>
                </div>
                <input type="text" class="form-control" name="p.user"  aria-label="Nome" aria-describedby="basic-addon1">
            </div>
            
      
            
            <button style="margin-top: 10px" type="submit" class="btn btn-primary form-control">Salvar</button>
            </form>
    </body>
</html>