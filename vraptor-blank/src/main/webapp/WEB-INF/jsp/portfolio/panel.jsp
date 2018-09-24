<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/includes/header.jsp" />     

        <div style="margin-top: 10px;">
            <div style="margin-bottom: 10px; margin-left: 10px;">
                <a href="./documents/new" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="">+ Adicionar Novo Documento</a>    
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
                    <c:forEach items="${documentoList}" var="document">
                        <tr>

                            <td>Etiquetas</td>
                            <td>
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                <button type="button" class="btn btn-secondary">Editar</button>
                                <button type="button" class="btn btn-secondary">Deletar</button>
                                </div>
                            </td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
                <c:if test="${fn:length(documentoList) == 0}">
                    <div class="alert alert-warning" role="alert" style="margin-top: 10px">
                        Nenhum Documento Encontrado!
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>
