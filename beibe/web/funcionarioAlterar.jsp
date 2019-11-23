<%@page import="Utils.DateConverter"%>
<%@page import="Model.Funcionario"%>
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

        <%@include file="imports.jsp" %>
    </head>
    <body>
        <jsp:useBean id="p" class="Bean.FuncionarioBean" />
        <jsp:setProperty name="p" property="*" />

        <jsp:useBean id="estadosBean" class="Bean.EstadosBean" scope="request" />
        <jsp:setProperty name="estadosBean" property="*" />


        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <%@ include file = "headerGerente.jsp" %>
            </div><!-- /.container-fluid -->
        </nav>


        <div class="container">

            <br/>
            <h4>Alterar Dados</h4>
            <hr>

            <h4> Dados do Sistema </h4>
            <hr>
            <form id="form" action="FuncionarioServlet?action=update" method="post">            
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="id">ID</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${funcionario.id}" name="id" id="id" readonly="readonly">
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="uf">Cargo</label>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="tipo" id="tipo">

                            <c:forEach items="${cargos}" var="c">                        
                                <option value="${c.id}" ${c.id == funcionario.cargo.id ? 'selected="selected"' : ''}>${c.nome}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="email">Email (Login)</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="email" value="${funcionario.email}" name="email" id="email">
                    </div>
                </div>
                <div id="divSenha" class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">Senha</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${funcionario.senha}" name="senha" id="senha">
                    </div>
                </div>

                <h4> Dados Pessoais</h4>
                <hr>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cpf">CPF</label>
                    <div class="col-sm-6">
                        <input class="form-control" maxlength="14" type="text" value="${funcionario.cpf}" name="cpf" id="cpf" >

                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="nome">Nome</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${funcionario.nome}" name="nome" id="nome">
                    </div> 
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="data">Data</label>
                    <div class="col-sm-6">

                        <input class="form-control" type="date" value="${funcionario.data}" name="data" id="data">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="rua">Rua</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${funcionario.rua}" name="rua" id="rua">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="numero">Número</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="number" value="${funcionario.numero}" name="numero" id="numero">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cep">Cep</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${funcionario.cep}" name="cep" id="cep">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="uf">Uf</label>
                    <div class="col-sm-6">
                        <select id="uf" class="custom-select custom-select-md" name="uf">
                            <option selected><c:out value="${funcionario.cidade.estado.uf}"/></option>
                            <c:forEach items="${estadosBean.estados}" var="e">                        
                                <option value="${e.uf}">${e.uf}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cidade">Cidade</label>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="cidade" id="cidade">
                            <option selected value="${funcionario.cidade.id}">${funcionario.cidade.nome}</option>
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
                        <a href="FuncionarioServlet"><button type="button" class="btn btn-secondary btn-block">Cancelar</button></a>
                    </div>
                </div>

                <div id="voltar" class="row">
                    <div class="col-sm-2">
                        <a href="FuncionarioServlet"><button type="button" class="btn btn-secondary btn-block">Voltar</button></a>
                    </div>
                </div>
            </form>
        </div>

        <script>
            var cidades;
            var mostra = '${mostra}';
            var cpf = '${funcionario.cpf}'
            console.log(${funcionario.cargo.id});

            $(document).ready(function () {

                $("#voltar").hide();
                var $campoCpf = $("#cpf");
                $campoCpf.mask('000.000.000-00', {reverse: true});

                console.log('mostra', mostra);

                if (mostra == 0) {
                    console.log('dentro');
                    $("#divSenha").hide();
                }
                if (mostra == 1) {
                    console.log('dentro1');
                    $('#form input').prop("disabled", true);
                    $('#form select').prop("disabled", true);
                    $("#salvar").hide();
                    $("#cancelar").hide();
                    $("#divSenha").hide();
                    $("#voltar").show();
                    console.log('ihu');
                }
                if (mostra == 2) {
                    $("#divSenha").show();
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