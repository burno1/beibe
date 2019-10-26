
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
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item active"><a class="nav-link" href="portalFuncionario.jsp">Portal (Funcionario) <span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href='produtos.jsp'>Produtos</a></li>
                        <li class="nav-item"><a class="nav-link" href='#'>Categorias</a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>






        <div class="container-fluid">
            <br/>
            <div class="form-group row">
                <div class="col-sm-2">
                    <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                </div>
            </div>   
            <form action="CadastrarProdutoServlet" method="post">
                <h4> Dados do produto</h4>
                <hr>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="nome">Nome</label>
                    <div class="col-sm-6">
                        <input type="text" name="nome" class="form-control" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="marca">Marca</label>
                    <div class="col-sm-6">
                        <input type="text" name="marca" class="form-control" required>                                        
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="tipo">Tipo</label>
                    <div class="col-sm-6">
                        <input type="text" name="tipo" class="form-control" required>                                        
                    </div>
                </div>


                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="categoria">Categoria</label>
                    <div class="input-group col-sm-6">
                        <select class="custom-select" id="categoria" name="categoria">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <div class="input-group col-sm-4">
                        <button class="btn btn-success" onclick="callServlet()" >Cadastrar Nova Categoria</button>
                    </div>

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

<script>
    function callServlet() {
        var myForm = document.createElement("form");

        myForm.action = "CadastrarCategoriaServlet";
        document.body.appendChild(myForm);
        myForm.submit();

    }
</script>
