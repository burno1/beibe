<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<% if (session.getAttribute("login") == null) {%>
<jsp:forward page="index.jsp">
    <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
</jsp:forward>
<% }%> 
<%@page errorPage="erro.jsp"%>


<html>
    <head>
        <%@include file="imports.jsp" %>
    </head>
    <body>
        <jsp:useBean id="clienteBean" class="Bean.ClienteBean" scope="request" />
        <jsp:setProperty name="clienteBean" property="*" />


        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
              <%@ include file = "headerGerente.jsp" %>
            </div><!-- /.container-fluid -->
        </nav>

        <br/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12"><a href="ClienteServlet?action=formNew">  <button class="btn btn-primary"> Novo </button></a>
                </div>
            </div>
            <!--//inserção não aperencedo msg-->
            <span style="color: red">${msg}</span>

            <br/>
            <h4> Clientes</h4>
            <hr>

            <div class="row">
                <div class="col-sm-12">
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">CPF</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Email</th>
                                <th scope="col">Opções</th>
                            </tr>


                        </thead>
                        <tbody>
                            <c:forEach items="${clienteBean.listaClientes}" var="c">
                                <tr>
                                    <td hidden="true"><c:out value="${c.id}"/></td>
                                    <td><c:out value="${c.cpf} " /></td>
                                    <td><c:out value="${c.nome}" /></td>
                                    <td><c:out value="${c.email}" /></td>
                                    <td>
                                        <a href="ClienteServlet?action=show&id=${c.id}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                        <a href="ClienteServlet?action=formUpdate&id=${c.id}"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                        <a href="ClienteServlet?action=remove&id=${c.id}"><button type="button" class="btn btn-danger">Remover</button> </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
        <footer id="sticky-footer" class="py-4 mt-auto bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
