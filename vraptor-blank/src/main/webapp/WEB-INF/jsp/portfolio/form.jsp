<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <c:import url="/WEB-INF/jsp/includes/header.jsp" /> 
        <div style="z-index: -1; position: absolute; width: 500px; height: 100px; top: 40%; left: 50%; margin: -100px 0 0 -250px;">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${linkTo[PortfolioController].panel}">Inicio</a></li>
                    <li class="breadcrumb-item"><a href="${linkTo[PortfolioController].panel}">Documentos</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Novo</li>
                </ol>
            </nav>
            <h3>Adicionar Novo Documento</h3>
            <div class="progress" style=" height: 5px;">
                <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            <br>
            <form action="${linkTo[PortfolioController].autenticar}" method="POST">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Nome do Documento</span>
                    </div>
                    <input type="text" class="form-control" name="p.user"  aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group" style="margin-top: 10px">
                    <select class="form-control">
                        <option>Selecione uma Categoria</option>
                        <c:forEach items="${cat}" var="cat">
                            <option>${cat.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="custom-file" style="margin-top: 10px">
                    <input type="file" class="custom-file-input" id="validatedCustomFile" required>
                    <label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
                    <div class="invalid-feedback">Example invalid custom file feedback</div>
                </div>
                <button style="margin-top: 10px" type="submit" class="btn btn-primary form-control">Salvar</button>
            </form>
        </div>
    </body>
</html>
