<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
                        <li class="active"><a href="portal.jsp">Cadastro Funcionario <span class="sr-only">(current)</span></a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>





        <div class="container">
            <form action="CadastrarFuncionarioServlet" method="post">


                <div class="form-group row">
                    <div class="col-sm-2">
                        <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                    </div>
                </div>    

                <h4> Dados do Sistema </h4>
                <hr>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="email">E-mail</label>
                    <div class="col-sm-10">
                        <input type="email" name="email" class="form-control" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">Senha</label>
                    <div class="col-sm-10">
                        <input type="password" name="senha" class="form-control" required>                                        </div>
                </div>

                <h4> Dados pessoais </h4>
                <hr>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="nome">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" name="nome" class="form-control" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">CPF</label>
                    <div class="col-sm-10">
                        <input type="text" name="CPF" class="form-control" required>                                        </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">RUA</label>
                    <div class="col-sm-10">
                        <input type="text" name="RUA" class="form-control" required>                                        </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">NÚMERO</label>
                    <div class="col-sm-10">
                        <input type="text" name="numero" class="form-control" required>                                        </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">CEP</label>
                    <div class="col-sm-10">
                        <input type="text" name="CEP" class="form-control" required>                                        </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">CIDADE</label>
                    <div class="col-sm-10">
                        <input type="text" name="cidade" class="form-control" required>                                        </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">UF</label>
                    <div class="col-sm-10">
                        <input type="text" name="cidade" class="form-control" required>                                        </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-success btn-block">Cadastrar</button>
                    </div>
                </div>




            </form>
        </div>
        <!--//inserção não aperencedo msg-->

        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
