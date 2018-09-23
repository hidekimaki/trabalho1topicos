<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/includes/header.jsp" />     

        <div style="margin-top: 10px;">
            <div style="margin-bottom: 10px; margin-left: 10px;">
                <a href="./new" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="">+ Adicionar Novo Documento</a>    
            </div>
            <div style="margin-left: 10px; margin-right: 10px; top: 0px;">

                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Criação</th>
                        <th>Update</th>
                        <th>Etiquetas</th>
                        <th>Opções</th>
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
