<%-- 
    Document   : detalhesCliente
    Created on : 25/09/2019, 16:46:34
    Author     : Bruno Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                    <a class="navbar-brand" href="portal.jsp">BEIBE</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href='ClienteServlet'>Detalhes Cliente <span class="sr-only">(current)</span></a></li>
                        <li><a>Detalhes Atendimento</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
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
                                <button type="submit">Detalhes</button>
                        </form></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>20/09/2019 12:51</td>
                        <td>Aberto</td>
                        <td>Não sei os tipos</td>
                        <td><form action="DetalhesAtendimentoServlet">
                                <input name="idCliente" hidden="true" value="1">
                                <button type="submit">Detalhes</button>
                        </form></td>
                        <td><button>Remover</button></td>
                    </tr>
                </tbody>
            </table>
        </div>

    </body>
</html>
