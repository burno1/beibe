<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% if (session.getAttribute("login") == null) {%>
<jsp:forward page="/index.jsp">
    <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
</jsp:forward>
<% }%>  
<%@page errorPage="erro.jsp"%>


<html>
    <head>
        <%@include file="imports.jsp" %>
    </head>
    <body>
        <jsp:useBean id="portalBean" class="Bean.PortalBean" scope="request"/>
        <jsp:setProperty name="portalBean" property="*"/>
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <%@ include file = "headerGerente.jsp" %>
            </div> 
        </nav>
        <br/>

        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="card">
                        <div class="card-header">
                            <h3>Atendimentos Realizados</h3>
                        </div>
                        <div class="card-body">
                            <blockquote class="blockquote mb-0">
                                <p>${portalBean.quantidadeAtendimentos}</p>
                            </blockquote>
                        </div>
                    </div>
                </div>

                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>Atendimentos Abertos:</h3>
                        </div>
                        <div class="card-body">
                            <blockquote class="blockquote mb-0">
                                <p>${portalBean.porcentagemAbertos}% (${portalBean.quantidadeAbertos})</p>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </div>





            <div class="row">
                <div class="col-sm-10">
                    <hr>
                    <h4><strong>Atendimentos por Tipo:</strong></h4>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Tipo</th>
                                <th scope="col">Abertos</th>
                                <th scope="col">Realizados</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${portalBean.tiposAtendimento}" var="t">
                                <tr>
                                    <td><c:out value="${t.nomeTipo}" /></td>
                                    <td><c:out value="${t.quantidadeAtendimentosAbertos}"/></td>
                                    <td><c:out value="${t.quantidadeAtendimentos}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>    


        <footer id="sticky-footer" class="mt-auto py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
