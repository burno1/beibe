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
                <div class="col-sm-12"><a href="ProdutoServlet?action=formNew">  <button class="btn btn-primary"> Novo </button></a>
                </div>
            </div>

            <div class="row">    
                <div class="col-sm-12">
                <span style="color: red">${msg}</span>
                    <h3> Produtos Cadastrados</h3>
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Nº</th>
                                <th scope="col">Nome</th>   
                                <th scope="col">Opções</th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${produtoBean.listaProdutos}" var="p">
                                <tr>

                                    <td><c:out value="${p.idProduto}"/></td>
                                    <td><c:out value="${p.nomeProduto}" /></td>
                                    <td>
                                        <a href="ProdutoServlet?action=show&id=${p.idProduto}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                        <a href="ProdutoServlet?action=formUpdate&id=${p.idProduto}"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                        <a href="ProdutoServlet?action=remove&id=${p.idProduto}"><button type="button" class="btn btn-danger">Remover</button> </a>
                                    </td>
                                </c:forEach>
                        </tbody>
                    </table>

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
