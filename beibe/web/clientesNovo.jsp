<%@page import="Utils.DateConverter"%>
<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% if (session.getAttribute("login") == null) {%>
        <jsp:forward page="/index.jsp">
            <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
        </jsp:forward>
    <% }%>    



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
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container">
            <br/>
            <h4>Cadastrar Novo Cliente</h4>
            <hr>
                <form action="ClienteServlet?action=new" method="post">

                    
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="cpf">CPF</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="cpf" >
                        </div>
                    </div>
            
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="nome">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="email">E-MAIL</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="data">DATA</label>
                        <div class="col-sm-6">
                            <input type="date" name="data">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="rua">RUA</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="rua">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="numero">NÚMERO</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="numero">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="cep">CEP</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="cep">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="cidade">CIDADE</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="cidade">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="uf">UF</label>
                        <div class="col-sm-6">
                            <input class="form-control" type="text" name="uf">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-success">Salvar</button>
                        </div>
                        <div class="col-sm-2">
                            <a href="ClienteServlet"><button type="button" class="btn btn-secondary">Cancelar</button></a>
                        </div>
                    </div>
                </form>
            </div>


        <!-- seu conteudo aqui -->
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>