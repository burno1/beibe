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
                        <li class="active"><a href='ClienteServlet'>Alterar Clientes<span class="sr-only">(current)</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <form action="AlterarClienteServlet" method="post">            
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="id">ID</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.id}" name="id" id="id" readonly="readonly">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CPF</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.cpf}" name="cpf" id="cpf">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.nome}" name="nome" id="nome">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">E-MAIL</label>
                <div class="col-sm-10">
                    <input type="email" value="${cliente.email}" name="email" id="email">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">DATA</label>
                <div class="col-sm-10">
                    <% String data = (DateConverter.converter(((Cliente) request.getAttribute("cliente")).getData()));%>
                    <input type="text" value="<%=data%>" name="data" id="data">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">RUA</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.rua}" name="rua" id="rua">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">NÚMERO</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.numero}" name="numero" id="numero">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CEP</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.cep}" name="cep" id="cep">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">CIDADE</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.cidade}" name="cidade" id="cidade">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="nome">UF</label>
                <div class="col-sm-10">
                    <input type="text" value="${cliente.uf}" name="uf" id="uf">
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