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
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="portal.jsp">Cadastro Funcionário </a></li>
                        <li class="active"><a href='ClienteServlet'>Cadastro Clientes<span class="sr-only">(current)</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <form action="InserirClienteServlet" method="post">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="cpf">CPF</label>
                <div class="col-sm-10">
                    <input type="text" name="cpf" >
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                <div class="col-sm-10">
                    <input type="text" name="nome">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="email">E-MAIL</label>
                <div class="col-sm-10">
                    <input type="text" name="email">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="data">DATA</label>
                <div class="col-sm-10">
                    <input type="date" name="data">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="rua">RUA</label>
                <div class="col-sm-10">
                    <input type="text" name="rua">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="numero">NÚMERO</label>
                <div class="col-sm-10">
                    <input type="text" name="numero">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="cep">CEP</label>
                <div class="col-sm-10">
                    <input type="text" name="cep">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="cidade">CIDADE</label>
                <div class="col-sm-10">
                    <input type="text" name="cidade">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="uf">UF</label>
                <div class="col-sm-10">
                    <input type="text" name="uf">
                </div>
            </div> 
            <div class="form-group row">
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-success btn-block">Salvar</button>
                </div>
                <div class="col-sm-2">
                    <a href="ClienteServlet"><button type="button" class="btn btn-secondary btn-block">Cancelar</button></a>
                </div>
            </div>
        </form>




        <!-- seu conteudo aqui -->
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> contato: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>