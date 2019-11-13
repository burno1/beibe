<%-- 
    Document   : detalhesCliente
    Created on : 25/09/2019, 16:46:34
    Author     : Bruno Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <jsp:useBean id="atendimentoBean" class="Bean.AtendimentoBean" scope="request" />
        <jsp:setProperty name="atendimentoBean" property="*" />

        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="portal.jsp">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item active"><a class="nav-link" href='DetalhesClienteServlet'>Detalhes Cliente</a></li>
                        <li class="nav-item"><a class="nav-link">Detalhes Atendimento <span class="sr-only">(current)</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>



        <div class="container">

            <div class="form-group row">
                <div class="col-sm-2">
                    <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                </div>
            </div>   

            <h3>Detalhes do Atendimento</h3>
            <form id="form" action="AtendimentoServlet?action=update" method="post">
                <div class="form-group row">
                    <div class="col-sm-2">
                        Id Atendimento
                    </div>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" value="${atendimento.id}" name="idAtend" id="idAtend" disabled>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Data/Hora
                    </div>
                    <div class="col-sm-3">
                        <input class="form-control" type="date" value="${atendimento.data}" name="data" id="data">
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-sm-2">
                        Cliente
                    </div>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="cliente" id="cliente">
                            <option selected value="${atendimento.cliente.id}">${atendimento.cliente.nome}</option>
                            <c:forEach items="${atendimentoBean.clientes}" var="c">     

                                <option value="${c.id}">${c.nome}</option>
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
                            <input type="radio" value="resolvido" name="resolvido" class="custom-control-input"  <c:if test="${resolvido}">checked</c:if> >
                                <label class="custom-control-label" for="customRadio1" >Solucionado</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input type="radio"  value="naoResolvido"  name="resolvido" class="custom-control-input" <c:if test="${!resolvido}">checked</c:if>>
                                <label class="custom-control-label" for="customRadio2">Não Solucionado</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label" for="produto">Produtos</label>
                        <div class="col-sm-6">
                            <select class="custom-select custom-select-md" name="produto" id="produto">
                                <option selected value="${atendimento.produto.idProduto}">${atendimento.produto.nomeProduto}</option>
                            <c:forEach items="${atendimentoBean.produtos}" var="p">     

                                <option value="${p.idProduto}">${p.nomeProduto}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="tipoAtendimento">Tipo de Atendimento</label>
                    <div class="col-sm-6">
                        <select class="custom-select custom-select-md" name="tipoAtendimento" id="tipoAtendimento">
                            <option selected value="${atendimento.tipoAtendimento.idTipo}">${atendimento.tipoAtendimento.nomeTipo}</option>
                            <c:forEach items="${atendimentoBean.tiposAtendimento}" var="t">     
                                <option value="${t.idTipo}">${t.nomeTipo}</option>
                            </c:forEach>
                        </select>   
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-2">
                        Descrição Atendimento
                    </div>
                    <div class="col-sm-6">
                        <textarea class="form-control" value="${atendimento.descricao}" name="descricao"></textarea>
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-sm-4">
                        <button  type="submit" class="btn btn-success btn-block">Salvar</button>
                    </div>
                    <div class="col-sm-4">
                        <button class="btn btn-danger btn-block" disabled="true"> Finalizar (So p/ Funcionario)</button>
                    </div>
                </div>
            </form>
        </div>

    </body>
</html>
