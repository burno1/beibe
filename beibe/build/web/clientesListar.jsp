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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/login.css" rel="stylesheet" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>

    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>
                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="portal.jsp">Portal <span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href='ClienteServlet'>Cadastro Clientes</a></li>
                        <li><a href="admin.jsp">Admin (Portal Antigo)</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!--//inserção não aperencedo msg-->
        ${msg}
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th scope="col">CPF</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">Detalhes</th>

                </tr>


            </thead>
            <tbody>
                <c:forEach items="${clienteBean.clienteBanco}" var="c">
                    <tr>
                        <td hidden="true"><c:out value="${c.id}"/></td>
                        <td><c:out value="${c.cpf} " /></td>
                        <td><c:out value="${c.nome}" /></td>
                        <td><c:out value="${c.email}" /></td>

                        <td><form action="DetalhesClienteServlet">
                                <input name="idCliente" hidden="true" value="${c.id}">
                                <button>Detalhes</button>
                            </form></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> contato: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
