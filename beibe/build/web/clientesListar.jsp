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
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal (Gerente) <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="atendimentos.jsp">Atendimentos</a></li>
                        <li class="nav-item active"><a class="nav-link" href='ClienteServlet'>Cadastro Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="funcionarioListar.jsp">Cadastro Funcionarios</a></li>
                        <li class="nav-item"><a class="nav-link" href="relatorios.jsp">Relatórios</a></li>
                        
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
                    
                    <br/>
        <div class="row">
            <div class="col-sm-12"> <a href="./clientesNovo.jsp"><button type="button" class="btn btn-primary">Novo Cliente</button> </a>
            </div>
        </div>
        <!--//inserção não aperencedo msg-->
        ${msg}

        <br/>
        <div class="container-fluid">
            <h4> Clientes</h4>
            <hr>
            
            <div class="row">
               
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
                                    <a href="./VisualizarClienteServlet?id=${c.id}"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                    <a href="./FormAlterarClienteServlet?id=${c.id}"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                    <a href="./RemoverClienteServlet?id=${c.id}"><button type="button" class="btn btn-danger">Remover</button> </a>
                                </td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> contato: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
