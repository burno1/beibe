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
         <jsp:useBean id="funcionarioBean" class="Bean.FuncionarioBean" scope="request" />
        <jsp:setProperty name="funcionarioBean" property="*" />
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                      <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal<span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="AtendimentoServlet">Atendimentos</a></li>
                        <li class="nav-item"><a class="nav-link" href='ProdutoServlet'>Produtos</a></li>
                        <li class="nav-item "><a class="nav-link" href='ClienteServlet'>Clientes</a></li>
                        <li class="nav-item active"><a class="nav-link" href="FuncionarioServlet">Funcionarios</a></li>
                        <li class="nav-item"><a class="nav-link" href="relatorios.jsp">Relatórios</a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
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
                    ${msg}
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
                                        <a href="FuncionarioServlet?action=remove&id=${u.id}"><button type="button" class="btn btn-danger">Remover</button> </a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
