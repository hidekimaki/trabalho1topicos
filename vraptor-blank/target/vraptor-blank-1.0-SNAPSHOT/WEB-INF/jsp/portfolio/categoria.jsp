<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <c:import url="/WEB-INF/jsp/includes/header.jsp" /> 
        
        
        <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
        <div class="alert alert-danger" role="alert" style="
        width: 80%;
        left: 10%;
        margin-top: 1%;
        margin-left: 0px">
            ${err.message}
        </div>
        </c:forEach>
        </c:if>
        
        <div style="z-index: -1; position: absolute; width: 500px; height: 100px; top: 40%; left: 50%; margin: -100px 0 0 -250px;">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${linkTo[PortfolioController].panel}">Inicio</a></li>
                    <li class="breadcrumb-item"><a href="${linkTo[PortfolioController].listcategories}">Categorias</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Adicionar Categoria</li>
                </ol>
            </nav>
            <h3>Adicionar Nova Categoria</h3>
            <div class="progress" style=" height: 5px;">
                <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>
            <form action="${linkTo[PortfolioController].savecat}" method="POST">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Nome</span>
                    </div>
                    <input type="text" class="form-control" name="c.name"  aria-label="Nome" aria-describedby="basic-addon1">
                </div>
                <button style="margin-top: 10px" type="submit" class="btn btn-primary form-control">Salvar</button>
            </form>
        </div>
    </body>
</html>
