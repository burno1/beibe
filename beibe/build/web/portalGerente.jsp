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
                        <li><a href="portal.jsp">Portal (Cliente) <span class="sr-only">(current)</span></a></li>
                        <li><a href="portalFuncionario.jsp">Portal (Funcionario) <span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href="portalGerente.jsp">Portal (Gerente) <span class="sr-only">(current)</span></a></li>
                        <li><a href='ClienteServlet'>Cadastro Clientes</a></li>
                        <li><a href="admin.jsp">Admin (Portal Antigo)</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="card">
                        <div class="card-header">
                            <h3>Atendimentos Realizados</h3>
                        </div>
                        <div class="card-body">
                            <blockquote class="blockquote mb-0">
                                <p>1234</p>
                            </blockquote>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h3>Atendimentos Abertos:</h3>
                        </div>
                        <div class="card-body">
                            <blockquote class="blockquote mb-0">
                                <p>24%</p>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </div>

            <hr>
            <h4><strong>Atendimentos por Tipo:</strong></h4>

            <div class="row">
                <div class="col-lg-12">
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Tipo</th>
                                <th scope="col">Abertos</th>
                                <th scope="col">Realizados</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>12</td>
                                <td>30</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>591</td>
                                <td>2321</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>423</td>
                                <td>4122</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>       
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> contato: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
