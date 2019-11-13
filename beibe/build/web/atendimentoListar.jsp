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
        <link href="./css/atendimento.css" rel="stylesheet" />

        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="jquery-3.4.1.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>


        <style>

            #title_bar{
                background: #FEFEFE;
            }
            #button{
                border:solid 1px;
                width: 25px;
                height: 23px;
                float:right;
                cursor:pointer;
            }
            #box{
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="atendimentoBean" class="Bean.AtendimentoBean" scope="request" />
        <jsp:setProperty name="atendimentoBean" property="*" />
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal (Gerente) <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item active"><a class="nav-link" href="atendimentos.jsp">Atendimentos</a></li>
                        <li class="nav-item"><a class="nav-link" href='ClienteServlet'>Cadastro Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="funcionarioListar.jsp">Cadastro Funcionarios</a></li>
                        <li class="nav-item"><a class="nav-link" href="relatorios.jsp">Relatórios</a></li>

                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>

                    <br/>
        <div class="container">
        <div class="row">
            <div class="col-sm-12"><a href="AtendimentoServlet?action=formNew">  <button class="btn btn-primary"> Novo </button></a>
            </div>
        </div>
        <br/>
            <div class="row">

                <h3> Atendimentos </h3>
                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Nº</th>
                            <th scope="col">Data/Hora</th>
                            <th scope="col">Produto</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${atendimentoBean.atendimentosLista}" var="a">
                            <tr>
                                <td><c:out value="${a.id}"/></td>
                                <td><c:out value="${a.data} " /></td>
                                <td><c:out value="${a.produto.nomeProduto}" /></td>
                                <td><c:out value="${a.cliente.nome}" /></td>
                                <td>
                                    <a href="AtendimentoServlet?action=show&id=${a.id}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                    <a href="AtendimentoServlet?action=formUpdate&id=${a.id}"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                    <a href="AtendimentoServlet?action=remove&id=${a.id}"><button type="button" class="btn btn-danger">Remover</button> </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>



            </div>

            

        </div>       
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>

<script>
    $("#button").click(function () {
        if ($(this).html() == "-") {
            $(this).html("+");
        } else {
            $(this).html("-");
        }
        $("#box").slideToggle();
    });
</script>