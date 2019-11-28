 <%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <%@include file="imports.jsp" %>
    </head>
    <body>
        <jsp:useBean id="p" class="Bean.ClienteBean" />
        <jsp:setProperty name="p" property="*" />

        <jsp:useBean id="estadosBean" class="Bean.EstadosBean" scope="request" />
        <jsp:setProperty name="estadosBean" property="*" />
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
            <form action="ClienteServlet?action=new" method="post">


                <div class="form-group row">
                    <div class="col-sm-2">
                        <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                    </div>
                </div>    
                <span style="color: red">${msg}</span>
                <h4> Dados do Sistema </h4>
                <hr>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="email">E-mail</label>
                    <div class="col-sm-6">
                        <input type="email" name="email" class="form-control" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">Senha</label>
                    <div class="col-sm-6">
                        <input type="password" name="senha" class="form-control" required>                                        
                    </div>
                </div>

                <h4> Dados pessoais </h4>
                <hr>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="nome">Nome</label>
                    <div class="col-sm-6">
                        <input type="text" name="nome" class="form-control" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">CPF</label>
                    <div class="col-sm-6">
                        <input type="text" pattern=".{14,}" maxlength="14" id="cpf" name="cpf" class="form-control" required>                                        
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="data">Data</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="date" name="data" id="data" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">RUA</label>
                    <div class="col-sm-6">
                        <input type="text" name="rua" class="form-control" required>                                       
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">NÚMERO</label>
                    <div class="col-sm-6">
                        <input type="number" name="numero" class="form-control" required>                                        
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">CEP</label>
                    <div class="col-sm-6">
                        <input type="number" name="cep" class="form-control" required>                                      
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="uf">UF</label>
                    <div class="col-sm-6">
                        <select id="uf" class="custom-select custom-select-md" name="uf" required>
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
                        <select class="custom-select custom-select-md" name="cidade" id="cidade" required>
                            <option selected value="${cliente.cidade.id}">${cliente.cidade.nome}</option>
                            <c:forEach items="${cidadesBean.cidades}" var="c">                        
                                <option value="${c.id}">${c.nome}</option>
                            </c:forEach>
                        </select>   
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
        <script>
            var cidades;

            $(document).ready(function () {
                var $campoCpf = $("#cpf");
                $campoCpf.mask('000.000.000-00', {reverse: true});



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
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
