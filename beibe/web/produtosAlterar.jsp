
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <%@include file="imports.jsp" %> 
    </head>
    <body>
        <jsp:useBean id="produtoBean" class="Bean.ProdutoBean" scope="request" />
        <jsp:setProperty name="produtoBean" property="*" />

        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>
                <!-- Cabeçalho -->
                <%@include file="headerFuncionario.jsp" %>
            </div> 
        </nav>
        <div class="container-fluid">
            <br/>
            <form action="ProdutoServlet?action=update" method="post" id="form">
                <div class="form-group row">
                    <div class="col-sm-4">
                        ID
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" value="${produto.idProduto}" name="id" readonly="readonly">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-4">
                        Nome
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" value="${produto.nomeProduto}" name="nome" required>
                    </div>
                </div>


                <div class="form-group row">
                    <div class="col-sm-4">
                        Categoria
                    </div>
                    <div class="input-group col-sm-6">
                        <select class="custom-select" id="inputGroupSelect02" name="categoria" >
                            <c:forEach items="${produtoBean.categorias}" var="c">                        
                                <option value="${c.id}" ${c.id == produto.categoria.id ? 'selected="selected"' : ''}>${c.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-4">
                        Descrição Produto
                    </div>
                    <div class="col-sm-6">
                        <textarea class="form-control" name="descricao" required>${produto.descricao}</textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-4">
                        Peso (g)
                    </div>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" value="${produto.peso}" name="peso" step=0.01 required >
                    </div>
                </div>

                <div class="row">
                    <div id="salvar" class="col-sm-4" ${mostra == 1 ? 'hidden' : ''}>
                        <button  type="submit" class="btn btn-success btn-block">Salvar</button>
                    </div>
                    
                        <div class="col-sm-4">
                            <button class="btn btn-success btn-block " type="button" name="back" onclick="history.back()">Voltar</button>
                    
                    </div>   
                </div>

            </form>


        </div>
        <!--//inserção não aperencedo msg-->

        <script>
            var mostra = '${mostra}';


            $(document).ready(function () {

                if (mostra) {
                    $('#form input').prop("disabled", true);
                    $('#form select').prop("disabled", true);
                    $('#form textarea').prop("disabled", true);
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


