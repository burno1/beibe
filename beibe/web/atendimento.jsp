<%-- 
    Document   : detalhesCliente
    Created on : 25/09/2019, 16:46:34
    Author     : Bruno Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<c:if test="${empty login}">
    <jsp:forward page="index.jsp">
        <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
    </jsp:forward>
</c:if>
<%@page errorPage="erro.jsp"%>


<!DOCTYPE html>



<html>
    <head>
        <%@include file="imports.jsp" %>
    </head>
    <body>
        <jsp:useBean id="atendimentoBean" class="Bean.AtendimentoBean" scope="request" />
        <jsp:setProperty name="atendimentoBean" property="*" />

        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="portal.jsp">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <c:choose>
                    <c:when test="${funcionario.tipo == 1}">

                        <%@ include file = "headerGerente.jsp" %> 
                    </c:when>
                    <c:when test="${funcionario.tipo == 2}">

                        <%@ include file = "headerFuncionario.jsp" %> 
                    </c:when>
                </c:choose>


            </div> 
        </nav>



        <div class="container">


            <h3>Detalhes do Atendimento</h3>
            <form id="form" action="AtendimentoServlet?action=update" method="post">
                <div class="form-group row">
                    <div class="col-sm-2">
                        Id Atendimento
                    </div>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" value="${atendimento.id}" name="idAtend" id="idAtend" readonly="readonly">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Data/Hora
                    </div>
                    <div class="col-sm-3">
                        <input class="form-control" type="date" value="${atendimento.data}" name="data" id="data" required>
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-sm-2">
                        Cliente
                    </div>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="cliente" id="cliente" required>

                            <c:forEach items="${atendimentoBean.clientes}" var="c">     
                                <option value="${c.id}" ${c.id == atendimento.cliente.id ? 'selected="selected"' :'' }>${c.nome}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Situação
                    </div>
                    <div class="col-sm-6">
                        <div class="custom-control custom-radio">
                            <input type="radio" value="resolvido" name="resolvido" id="customRadio1" class="custom-control-input"  ${atendimento.resolvido==1 ?'checked' : '' } >
                            <label class="custom-control-label" for="customRadio1" >Solucionado</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input type="radio"  value="naoResolvido"  name="resolvido" id="customRadio2" class="custom-control-input" ${atendimento.resolvido==0 ?'checked' : '' }>
                            <label class="custom-control-label" for="customRadio2">Não Solucionado</label>
                        </div>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="produto">Produtos</label>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="produto" id="produto">

                            <c:forEach items="${atendimentoBean.produtos}" var="p">
                                <option value="${p.idProduto}" ${p.idProduto == atendimento.produto.idProduto? 'selected="selected"' : ''}>${p.nomeProduto}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="tipoAtendimento">Tipo de Atendimento</label>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="tipoAtendimento" id="tipoAtendimento">
                            <c:forEach items="${atendimentoBean.tiposAtendimento}" var="t">     
                                <option value="${t.idTipo}" ${t.idTipo == atendimento.tipoAtendimento.idTipo ? 'selected="selected"' : ''}>${t.nomeTipo}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Descrição Atendimento
                    </div>
                    <div class="col-sm-6">
                        <textarea class="form-control"  name="descricao" required>${atendimento.descricao}</textarea>
                    </div>
                </div>

                <div id="solucao" class="form-group row" ${atendimento.resolvido == 1  || (funcionario.getTipo() == 1 || funcionario.getTipo() == 2 ) ? '' : 'hidden'}>
                    <div class="col-sm-2">
                        Solução Atendimento

                    </div>
                    <div class="col-sm-6">
                        <textarea class="form-control"  name="solucao" >${atendimento.solucao}</textarea>
                    </div>
                </div>


                <div class="row">

                    <div id="salvar" class="col-sm-4">
                        <button  type="submit" class="btn btn-success btn-block">Salvar</button>
                    </div>

                    <div id="voltar" class="col-sm-4">
                        <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                    </div>

                    <div id="finaliza" ${(funcionario.getTipo() == 1 || funcionario.getTipo() == 2) && atendimento.resolvido != 1 && novo != 1   ? '' : 'hidden'}>
                        <button class="btn btn-danger btn-block" type="button" onclick="callServlet()">Finalizar</button>
                    </div>

                </div>


            </form>
        </div>

        <script>
            var mostra = '${mostra}';
            var finalizar = '${finalizar}';

            $(document).ready(function () {

                if (mostra) {
                    $('#form input').prop("disabled", true);
                    $('#form select').prop("disabled", true);
                    $('#form textarea').prop("disabled", true);
                    $("#salvar").hide();
                    $("#cancelar").hide();
                    $("#finaliza").hide();
                }
                
                
            });

            function callServlet() {
                console.log('ihu');
                var solucao = $('#form').find('textarea[name="solucao"]').val();
                var id = $('#form').find('input[name="idAtend"]').val();

                console.log(id, solucao);
                var myForm = document.createElement("form");
                var formAction = "AtendimentoServlet?action=finalizar&id=" + id + "&solucao=" + solucao;
                myForm.action = formAction;
                myForm.method = "post";
                document.body.appendChild(myForm);
                myForm.submit();
            }
        </script>
    </body>
</html>
