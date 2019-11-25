<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% if (session.getAttribute("login") == null) {
        RequestDispatcher rd = request.
                getRequestDispatcher("/ErroServlet");
        request.setAttribute("msg", "Não vem de hack!");
        request.setAttribute("page", "index.jsp");
        rd.forward(request, response);
    }%>


<html>
    <head>
        <%@include file="imports.jsp" %>
    </head>
    <body>
         <jsp:useBean id="funcionarioBean" class="Bean.FuncionarioBean" scope="request" />
        <jsp:setProperty name="funcionarioBean" property="*" />
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <%@ include file = "headerGerente.jsp" %>
            </div> 
        </nav>


        <div class="container-fluid">

            <div class="row">
                <div class="col-sm-12">
                    <br/>
                    
                    <div class="row">
                        <div class="col-sm-12"><a href="FuncionarioServlet?action=formNew">  <button class="btn btn-primary"> Novo </button></a>
                        </div>
                    </div>
                    <!--//inserção não aperencedo msg-->
                    <span style="color: red">${msg}</span>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">E-mail</th>
                                <th scope="col">Opções</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${funcionarioBean.listaFuncionarios}" var="u">
                                <tr>
                                    <td><c:out value="${u.nome}" /></td>
                                    <td><c:out value="${u.email}" /></td>
                                    <td>
                                        <a href="FuncionarioServlet?action=show&id=${u.id}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                        <a href="FuncionarioServlet?action=formUpdate&id=${u.id}&mostra=0"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                         <button type="button" class="btn btn-danger" onclick="confirmRemove(${u.id})">Remover</button>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <footer class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>

<script>
    function confirmRemove(id) {
        var txt;
        var r = confirm("Deseja Remover? :(");
        if (r == true) {
            window.location.replace("./FuncionarioServlet?action=remove&id=" + id);
        }
        console.log(txt);
    }
</script>
