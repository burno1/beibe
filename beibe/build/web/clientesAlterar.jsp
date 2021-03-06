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

        <%@include file="imports.jsp" %>
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
                <c:choose>
                    <c:when test="${funcionario.tipo == 1}">

                        <%@ include file = "headerGerente.jsp" %> 
                    </c:when>
                    <c:when test="${funcionario.tipo == 2}">

                        <%@ include file = "headerFuncionario.jsp" %> 
                    </c:when>
                    <c:when test="${clienteLogado.id != null}">

                        <%@ include file = "headerCliente.jsp" %> 
                    </c:when>
                </c:choose>
            </div><!-- /.container-fluid -->
        </nav>


        <div class="container">

            <br/>
            <h4>Alterar Dados</h4>
            <hr>
            <form id="form" action="ClienteServlet?action=update" method="post">       
                <h4> Dados do Sistema </h4>
                <hr>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="id">ID</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.id}" name="id" id="id" readonly="readonly">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cpf">CPF</label>
                    <div class="col-sm-6">
                        <input class="form-control" pattern=".{14,}" maxlength="14" type="text" value="${cliente.cpf}" name="cpf" id="cpf" required ${altera==1? 'readonly' : ''}>
                    </div>
                </div>   
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="nome">NOME</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.nome}" name="nome" id="nome" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="email">E-MAIL</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="email" value="${cliente.email}" name="email" id="email" required ${altera==1? 'readonly' : ''}>
                    </div>
                </div>
                <div id="senha" class="form-group row">
                    <label class="col-sm-2 col-form-label" for="senha">Senha</label>
                    <div class="col-sm-6">
                        <input type="password" value="${cliente.senha}" name="senha" class="form-control" required ${altera==1? 'readonly' : ''}>   
                    </div>
                </div>
                <h4> Dados Pessoais</h4>
                <hr>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="data">DATA</label>
                    <div class="col-sm-6">

                        <input class="form-control" type="date" value="${cliente.data}" name="data" id="data" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="telefone">TELEFONE</label>
                    <div class="col-sm-6">
                        <input class="form-control" pattern=".{11,}" maxlength="14" type="text" value="${cliente.telefone}" name="telefone" id="telefone" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="rua">RUA</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${cliente.rua}" name="rua" id="rua" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="numero">NÚMERO</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="number" value="${cliente.numero}" name="numero" id="numero" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="cep">CEP</label>
                    <div class="col-sm-6">
                        <input class="form-control" pattern=".{8,}" type="text" value="${cliente.cep}" name="cep" id="cep" required>
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
                        <a onclick="history.back()"><button type="button" class="btn btn-secondary btn-block">Cancelar</button></a>
                    </div>
                </div>

                <div id="voltar" class="row">
                    <div class="col-sm-2">
                        <a onclick="history.back()"><button type="button" class="btn btn-secondary btn-block">Voltar</button></a>
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
                $("#cep").mask("99.999-999");
                $('#telefone').mask('(00) 0000-00009');
                if (mostra) {
                    $('#form input').prop("disabled", true);
                    $('#form select').prop("disabled", true);
                    $("#salvar").hide();
                    $("#senha").hide();
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