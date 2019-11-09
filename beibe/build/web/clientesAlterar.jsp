<%@page import="Utils.DateConverter"%>
<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<c:if test="${empty login}">
    <jsp:forward page="index.jsp">
        <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
    </jsp:forward>
</c:if>
<%@page errorPage="erro.jsp"%>


<html>
    <head>

        <link href="./css/login.css" rel="stylesheet" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
            <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        </title>
    </head>
    <body>
        <jsp:useBean id="p" class="Bean.ClienteBean" />
        <jsp:setProperty name="p" property="*" />
        <jsp:useBean id="estadosBean" class="Bean.EstadosBean" scope="request" />
        <jsp:setProperty name="estadosBean" property="*" />


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
            <h4>Alterar Dados</h4>
            <hr>
            <form id="form" action="ClienteServlet?action=update" method="post">            
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="id">ID</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.id}" name="id" id="id" readonly="readonly">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cpf">CPF</label>
                    <div class="col-sm-6">
                        <input class="form-control" maxlength="14" type="text" value="${cliente.cpf}" name="cpf" id="cpf" >

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.nome}" name="nome" id="nome">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="email">E-MAIL</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="email" value="${cliente.email}" name="email" id="email">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="data">DATA</label>
                    <div class="col-sm-6">

                        <input class="form-control" type="date" value="${cliente.data}" name="data" id="data">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="rua">RUA</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.rua}" name="rua" id="rua">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="numero">NÚMERO</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="number" value="${cliente.numero}" name="numero" id="numero">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cep">CEP</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.cep}" name="cep" id="cep">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="uf">UF</label>
                    <div class="col-sm-6">
                        <select id="uf" class="custom-select custom-select-md" name="uf">
                            <option selected><c:out value="${cliente.cidade.estado.uf}"/></option>
                            <c:forEach items="${estadosBean.estados}" var="e">                        
                                <option value="${e.uf}">${e.uf}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cidade">CIDADE</label>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="cidade" id="cidade">
                            <option selected value="${cliente.cidade.id}">${cliente.cidade.nome}</option>
                            <c:forEach items="${cidadesBean.cidades}" var="c">                        
                                <option value="${c.id}">${c.nome}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>
                <div id="test">

                </div>

                <div id="salvar" class="form-group row">
                    <div class="col-sm-2">
                        <button  type="submit" class="btn btn-success btn-block">Salvar</button>
                    </div>

                    <div id="cancelar" class="col-sm-2">
                        <a href="ClienteServlet"><button type="button" class="btn btn-secondary btn-block">Cancelar</button></a>
                    </div>
                </div>

                <div id="voltar" class="row">
                    <div class="col-sm-2">
                        <a href="ClienteServlet"><button type="button" class="btn btn-secondary btn-block">Voltar</button></a>
                    </div>
                </div>
            </form>
        </div>

        <script>
            var cidades;
            var mostra = '${mostra}';
            var cpf = '${cliente.cpf}'
            

            $(document).ready(function () {

                $("#voltar").hide();
                var $campoCpf = $("#cpf");
                $campoCpf.mask('000.000.000-00', {reverse: true});
                if (mostra) {
                    $('#form input').prop("disabled", true);
                    $('#form select').prop("disabled", true);
                    $("#salvar").hide();
                    $("#cancelar").hide();
                    $("#voltar").show();
                    
                }

                $("#uf").change(function () {
                    getCidades();
                });
            });

            function carregarCombo(data)
            {
                // Se sucesso, limpa e preenche a combo de cidade
                $("#cidade").empty();
                $.each(data, function (i, obj) {
                    $("#cidade").append('<option value=' + obj.id + '>' + obj.nome + '</option>');
                });
            }


            function getCidades() {
                cidades = $.ajax({
                    url: "./ajaxCidadesServlet",
                    data: {uf: $("#uf").val()},
                    async: false,
                    dataType: 'json'
                }).responseJSON;
                carregarCombo(cidades)
            }

            function getCidades() {
                cidades = $.ajax({
                    url: "./ajaxCidadesServlet",
                    data: {uf: $("#uf").val()},
                    async: false,
                    dataType: 'json'
                }).responseJSON;
                carregarCombo(cidades)
            }

        </script>


        <!-- seu conteudo aqui -->
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>