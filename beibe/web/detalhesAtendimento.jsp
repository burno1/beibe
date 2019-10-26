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
         
         <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="portal.jsp">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item active"><a class="nav-link" href='DetalhesClienteServlet'>Detalhes Cliente</a></li>
                        <li class="nav-item"><a class="nav-link">Detalhes Atendimento <span class="sr-only">(current)</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>
            
                    

        <div class="container">
            
              <div class="form-group row">
                    <div class="col-sm-2">
                        <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                    </div>
                </div>   
            
            <h3>Detalhes do Atendimento</h3>
            <form>
                <div class="form-group row">
                    <div class="col-sm-2">
                        Data/Hora
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="24/05/2015" name="data" disabled="true">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Cliente
                    </div>
                    <div class="input-group col-sm-10">
                        <select class="custom-select" id="inputGroupSelect01">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Situação
                    </div>
                    <div class="input-group col-sm-10">
                        <select class="custom-select" id="inputGroupSelect02">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Produto:
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="" name="produto">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Tipo do Atendimento
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" value="" name="tipoAtendimento">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Descrição Atendimento
                    </div>
                    <div class="col-sm-4">
                        <textarea class="form-control" value="" name="descAtendimento"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Solução Apresentada:
                    </div>
                    <div class="col-sm-4">
                        <textarea class="form-control" value="" name="solucaoAtendimento"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-4">
                        <button class="btn btn-success btn-block"> Salvar</button>
                    </div>
                    <div class="col-sm-4">
                        <button class="btn btn-danger btn-block" disabled="true"> Finalizar (So p/ Funcionario)</button>
                    </div>
                </div>
            </form>
        </div>

    </body>
</html>