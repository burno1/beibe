<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% if (session.getAttribute("login") == null) {%>
<jsp:forward page="index.jsp">
    <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
</jsp:forward>
<% }%>    
<%@page errorPage="erro.jsp"%>

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
                        <li class="nav-item active"><a class="nav-link" href="portal.jsp">Portal (Cliente) <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="portalFuncionario.jsp">Portal (Funcionario) <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal (Gerente) <span class="sr-only">(current)</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>

        <div class="container">
            <h3>Detalhes do Cliente</h3>
            <form action="atualizaClienteServlet"  method="post">
                <div class="form-group row">
                    <div class="col-sm-2">
                        CPF:
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="111111" name="CPF" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Email:
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="a@a.com" nome="email" disabled="true" >
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Nome:
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="Erick" name="nome">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Rua:
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="Maneira, nº666" name="endereco">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-4">
                        <button class="btn btn-success btn-block" type="submit">Atualizar Dados</button>
                    </div>
                </div>
            </form>

            <hr>
            <div class="form-group row">
                <div class="col-sm-8">
                    <h4>Atendimentos Relacionados</h4>
                </div>
                <div class="col-sm-4">
                    <form action='AtendimentoServlet'>
                        <button type="submit" class="btn btn-success btn-block">Novo Atendimento</button>
                    </form>
                </div>
            </div>

            <hr>

            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Nº</th>
                        <th scope="col">Data/Hora</th>
                        <th scope="col">Situação</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Detalhes</th>
                        <th scope="col">Remover</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>30/09/2019 12:11</td>
                        <td>Fechado</td>
                        <td>Não sei os tipos</td>
                        <td><form action="DetalhesAtendimentoServlet">
                                <input name="idCliente" hidden="true" value="1">
                                <button class="btn btn-primary" type="submit">Detalhes</button>
                            </form></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>20/09/2019 12:51</td>
                        <td>Aberto</td>
                        <td>Não sei os tipos</td>
                        <td>
                            <form action="DetalhesAtendimentoServlet">
                                <input name="idCliente" hidden="true" value="1">
                                <button class="btn btn-primary" type="submit">Detalhes</button>
                            </form>
                        </td>
                        <td><button class="btn btn-danger" >Remover</button></td>
                    </tr>
                </tbody>
            </table>

            <!-- Modal -->
            <div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Título do modal</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary">Salvar mudanças</button>
                        </div>
                    </div>
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
