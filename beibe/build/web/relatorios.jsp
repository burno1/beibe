
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
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
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
                        <li class="nav-item"><a class="nav-link" href='ClienteServlet'>Cadastro Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="funcionarioListar.jsp">Cadastro Funcionarios</a></li>
                        <li class="nav-item active"><a class="nav-link" href="relatorios.jsp">Relatórios</a></li>

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
                <div class="col-xl-12">
                    <h4>Relatório de Funcionários</h4>
                    <hr/>
                    <button class="btn btn-outline-primary"> Imprimir Relatório</button>
                    <br/>                    

                    <br/>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Produtos mais reclamados</h4>
                    <hr/>
                    <button class="btn btn-outline-primary"> Imprimir Relatório</button> 
                    <br/>
                    <br/>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Atendimentos Abertos</h4>
                    <hr/>
                    <form action="atendimentosAbertosServlet">
                        <div class="row">

                            <div class="col-xl-2">
                                Data Inicio:
                            </div>

                            <div class="col-md-4">
                                <input class="form-input" id="dataInicio" type="date" name="dataInicio">
                            </div>
                        </div>
                        <br/>

                        <div class="row">
                            <div class="col-xl-2">Data Fim:</div>
                            <div class="col-md-4">
                                <input class="form-input" id="dataFim" type="date" name="dataFim">
                            </div>

                        </div>

                        <button class="btn btn-outline-primary" type="submit"> Imprimir Relatório</button>
                        <br/>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Reclamações</h4>
                    <hr/>

                    <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio1">Todas</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio2">Em Aberto</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio3" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio3">Finalizados</label>
                    </div>
                    <br/>
                    <br/>

                    <button class="btn btn-outline-primary"> Imprimir Relatório</button> 
                    <br/>

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
