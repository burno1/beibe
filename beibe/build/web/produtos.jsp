<%-- 
    Document   : produtos
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Bruno Fernandes
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
        <!-- Cabeçalho -->
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>
                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item active"><a class="nav-link" href="portalGerente.jsp">Portal (Gerente) <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="atendimentos.jsp">Atendimentos</a></li>
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
        <div class="container-fluid">

            <div class="row">
                <div class="col">
                    <form action="cadastrarProduto.jsp">
                        <button class="btn btn-success" type="submit">
                            Cadastrar Novo Produto
                        </button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <h3> Produtos Cadastrados</h3>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Nº</th>
                                <th scope="col">Nome</th>   
                                <th scope="col">Detalhes</th>
                                <th scope="col">Remover</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Shampoo</td>
                                <td>

                                    <button class="btn btn-primary" data-toggle="modal" data-target="#target" >Detalhes</button>
                                </td>
                                 <td><button class="btn btn-danger">Remover</button> </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Batom</td>
                                <td>

                                    <button class="btn btn-primary" data-toggle="modal" data-target="#modalExemplo" >Detalhes</button>
                                </td>
                                <td><button class="btn btn-danger">Remover</button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="modal fade" id="target" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Descrição Produto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group row">
                                    <div class="col-sm-4">
                                      Nome
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" value="Produto A" name="data" disabled="true">
                                    </div>
                                </div>

                               
                                <div class="form-group row">
                                    <div class="col-sm-4">
                                        Categoria
                                    </div>
                                    <div class="input-group col-sm-6">
                                        <select class="custom-select" id="inputGroupSelect02" disabled="true">
                                            <option selected>Choose...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-4">
                                        Descrição Produto
                                    </div>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" value="" name="descProduto" disabled="true"></textarea>
                                    </div>
                                </div>

                                 <div class="form-group row">
                                    <div class="col-sm-4">
                                      Peso (g)
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" value="100" name="data" disabled="true">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                            <button type="button" id="buttonModal" class="btn btn-primary">Alterar</button>
                        </div>
                    </div>
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

<script>
    $("#button").click(function () {
        if ($(this).html() == "-") {
            $(this).html("+");
        } else {
            $(this).html("-");
        }
        $("#box").slideToggle();
    });
    
    $("#buttonModal").click (function(){
        $("#target :input").prop("disabled", false);
        
        $("#buttonModal").prop("disabled",false);

    })
</script>