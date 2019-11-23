<%-- 
    Document   : headerFuncionario
    Created on : 22/11/2019, 18:20:37
    Author     : Bruno Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li class="nav-item active"><a class="nav-link" href="PortalServlet">Portal</a></li>
        <li class="nav-item"><a class="nav-link" href='ProdutoServlet'>Produtos</a></li>
        <li class="nav-item"><a class="nav-link" href='CategoriaServlet'>Categorias</a></li>
    </ul>
    <ul class="nav navbar-nav ml-auto">
        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
    </ul>
</div><!-- /.navbar-collapse -->