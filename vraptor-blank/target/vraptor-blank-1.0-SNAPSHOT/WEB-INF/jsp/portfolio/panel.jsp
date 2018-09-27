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
                    <c:forEach items="${documentList}" var="document">
                        <tr>
                            <td>${document.id}</td>
                            <td>${document.filename}</td>
                            <td>${document.date}</td>
                            <td></td>
                            <td> <span class="badge badge-secondary">Sem Etiquetas</span></td>
                            <td>
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                <button type="button" class="btn btn-secondary">Editar</button>
                                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#delete${document.id}">Deletar</button></div>
                            </td>
                            <td></td>
                        </tr>
                        <div class="modal fade" id="delete${document.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Deseja Deletar esta Categoria ?</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Tem certeza que deseja continuar ? , Esta Operação não poderá ser desfeita! 
                                    </div>
                                    <div class="modal-footer">
                                        
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                        <form action="${linkTo[PortfolioController].deletedoc}" method="POST">
                                            <input type="hidden" value="${document.id}" name="doc.id">
                                           <button style="margin-top: 10px" name="action" value="Save" type="submit" class="btn btn-primary">- Remover</button>
                                        </form>        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </table>
                <c:if test="${fn:length(documentList) == 0}">
                    <div class="alert alert-warning" role="alert" style="margin-top: 10px">
                        Nenhum Documento Encontrado!
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>
