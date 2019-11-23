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
                    <form action="CadastrarCategoriaServlet">
                        <button class="btn btn-success" type="submit">
                            Cadastrar Nova Categoria
                        </button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <h3> Categorias Cadastradas</h3>
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
                            <tr>
                                <td>1</td>
                                <td>Produtos de Cabelo</td>
                                <td>                                 <button class="btn btn-primary" data-toggle="modal" data-target="#modalExemplo" typ>Detalhes</button>
                                </td>
                                <td><button class="btn btn-danger">Remover</button> </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Maquiagem</td>
                                <td>                                 <button class="btn btn-primary" data-toggle="modal" data-target="#modalExemplo" typ>Detalhes</button>
                                </td>
                                <td><button class="btn btn-danger">Remover</button> </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>    
        <div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Categoria</h5>
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
                                <div class="col-sm-4">
                                    <input class="form-control" value="Categoria A" name="data" disabled="true">
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary">Alterar</button>
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
</script>