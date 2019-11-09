<%@page import="Utils.DateConverter"%>
<%@page import="Model.Cliente"%>
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
        <jsp:useBean id="p" class="Model.Cliente" />
        <jsp:setProperty name="p" property="*" />

        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal (Gerente) </span></a></li>
                        <li class="nav-item active"><a class="nav-link" href='ClienteServlet'>Cadastro Clientes <span class="sr-only">(current)</a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <div class="container">
            <br/>
            <h4>Dados do Cliente</h4>
            <hr>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">ID</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.id}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CPF</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.cpf}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.nome}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">E-MAIL</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.email}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">DATA</label>
                <div class="col-sm-6">

                    <input class="form-control" type="text" value="${cliente.data}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">RUA</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.rua}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NÚMERO</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.numero}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CEP</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.cep}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CIDADE</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.cidade}" disabled="true">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">UF</label>
                <div class="col-sm-6">
                    <input class="form-control" type="text" value="${cliente.uf}" disabled="true">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <a href="ClienteServlet"><button type="button" class="btn btn-secondary btn-block">Voltar</button></a>
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