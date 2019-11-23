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
        <jsp:useBean id="categoriaBean" class="Bean.CategoriaBean" scope="request" />
        <jsp:setProperty name="categoriaBean" property="*" />

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
            <form id="form" action="CategoriaServlet?action=update" method="post">
                <div class="form-group row">
                    <div class="col-sm-2">
                        ID:
                    </div>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${categoria.id}" name="id" id="id" readonly="readonly">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">
                        Nome
                    </div>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" value="${categoria.nome}" name="nome" id="nome" required>
                    </div>
                </div>

                <div class="row">

                    <div id="salvar" class="col-sm-4" ${mostra == 1 ? 'hidden' : ''}>
                        <button  type="submit" class="btn btn-success btn-block">${atualiza == 1 ? 'Atualizar' : 'Salvar'}</button>
                    </div>

                </div>
            </form>


            <div class="row">
                <div class="col-sm-12">
                    <h3> Categorias Cadastradas</h3>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Nº</th>
                                <th scope="col">Nome</th>   
                                <th scope="col">Opções</th>   
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${categoriaBean.categorias}" var="c">
                                <tr>
                                    <td><c:out value="${c.id}" /></td>
                                    <td><c:out value="${c.nome}" /></td>
                                    <td>
                                        <a href="CategoriaServlet?action=show&id=${c.id}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                        <a href="CategoriaServlet?action=formUpdate&id=${c.id}"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                        <a href="CategoriaServlet?action=remove&id=${c.id}"><button type="button" class="btn btn-danger">Remover</button> </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>    
        <script>
            var cidades;
            var mostra = '${mostra}';
            
            console.log(mostra);
            $(document).ready(function () {
                if (mostra) {
                    $('#form input').prop("disabled", true);

                }

            });
        </script>
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
