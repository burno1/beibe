<%@page import="Utils.DateConverter"%>
<%@page import="Model.Cliente"%>
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
                        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal (Gerente) </span></a></li>
                        <li class="nav-item active"><a class="nav-link" href='funcionarioListar'>Cadastro Funcionário <span class="sr-only">(current)</a></li>

                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <div class="container">
            <br/>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">ID</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="Cliente" readonly="true">
                </div>
            </div>
            
            <div class="form-group row">
                <div class="col-sm-2">
                    Categoria
                </div>
                <div class="input-group col-sm-6">
                    <select class="custom-select" id="inputGroupSelect02">
                        <option selected>Selecione...</option>
                        <option value="1">Funcionário</option>
                        <option value="2">Gerente</option>
                        
                    </select>
                </div>
            </div>
            
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CPF</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="CPF" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="Nome" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">E-MAIL</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="email" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">DATA</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="24/05/2019" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">RUA</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="rua" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NÚMERO</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="numero" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CEP</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="cep" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CIDADE</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="cidade" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">UF</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="uf" >
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-success btn-block">Salvar</button>
                </div>

                <div class="col-sm-2">
                    <a href="funcionarioListar.jsp"><button type="button" class="btn btn-secondary btn-block">Cancelar</button></a>
                </div>
            </div>

        </div>


        <!-- seu conteudo aqui -->
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>