<%-- 
    Document   : produtos
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Bruno Fernandes
--%>

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
        <%@include file="imports.jsp" %>
    </head>
    <body>
        <jsp:useBean id="produtoBean" class="Bean.ProdutoBean" scope="request" />
        <jsp:setProperty name="produtoBean" property="*" />
        <!-- Cabeçalho -->
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>
                <!-- Cabeçalho -->
                <%@include file="headerFuncionario.jsp" %>
            </div> 
        </nav>

        <br/>
        <div class="container-fluid">

            <div class="row">
                <div class="col">
                    <form action="cadastrarProduto.jsp">
                        <button class="btn btn-success" type="submit">
                            Cadastrar Novo Produto
                        </button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <h3> Produtos Cadastrados</h3>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Nº</th>
                                <th scope="col">Nome</th>   
                                <th scope="col">Detalhes</th>
                                <th scope="col">Remover</th> 
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${produtoBean.listaProdutos}" var="p">
                                <tr>

                                    <td><c:out value="${p.idProduto}"/></td>
                                    <td><c:out value="${p.nomeProduto}" /></td>
                                    <td>
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#modalExemplo" >Detalhes</button>
                                    </td>
                                    <td><button class="btn btn-danger">Remover</button></td>

                                </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

            <div class="modal fade" id="target" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Descrição Produto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group row">
                                    <div class="col-sm-4">
                                        Nome
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" value="Produto A" name="data" disabled="true">
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <div class="col-sm-4">
                                        Categoria
                                    </div>
                                    <div class="input-group col-sm-6">
                                        <select class="custom-select" id="inputGroupSelect02" disabled="true">
                                            <option selected>Choose...</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-4">
                                        Descrição Produto
                                    </div>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" value="" name="descProduto" disabled="true"></textarea>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-4">
                                        Peso (g)
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" value="100" name="data" disabled="true">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                            <button type="button" id="buttonModal" class="btn btn-primary">Alterar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>       
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>

<script>
    $("#button").click(function () {
        if ($(this).html() == "-") {
            $(this).html("+");
        } else {
            $(this).html("-");
        }
        $("#box").slideToggle();
    });

    $("#buttonModal").click(function () {
        $("#target :input").prop("disabled", false);

        $("#buttonModal").prop("disabled", false);

    })
</script>