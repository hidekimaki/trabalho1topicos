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
                    <span class="input-group-text" id="basic-addon1">Nome do Documento</span>
                </div>
                <input type="text" class="form-control" name="p.user"  aria-label="Username" aria-describedby="basic-addon1">
            </div>
            
            <div class="input-group" style="margin-top: 10px">
                <select class="form-control">
                <option>--</option>
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
            
            <button style="margin-top: 10px" type="submit" class="btn btn-primary form-control">Login</button>
            </form>
    </body>
</html>
