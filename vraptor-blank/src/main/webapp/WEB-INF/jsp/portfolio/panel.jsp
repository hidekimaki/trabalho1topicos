<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/includes/header.jsp" />     

        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img class="d-block w-100" src=".../800x400?auto=yes&bg=777&fg=555&text=First slide" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src=".../800x400?auto=yes&bg=666&fg=444&text=Second slide" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block w-100" src=".../800x400?auto=yes&bg=555&fg=333&text=Third slide" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        <h1>${usuario.getName()}</h1>
        <div>
            <div>
                <a href="./new" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="
    margin-bottom: 10px;
    margin-right: 0px;">+ Adicionar Novo Documento</a>    
            </div>
            <div style="margin-left: 10px; margin-right: 10px; top: 0px;">
            
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Ações</th>
            </tr>
                <c:forEach items="${carroList}" var="car">
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.marca}</td>
                        <td>${car.modelo}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
                </div>
        </div>
    </body>
</html>
