<%-- 
    Document   : cabeçalho
    Created on : 22/11/2019, 13:57:35
    Author     : Bruno Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal<span class="sr-only">(current)</span></a></li>
        <li class="nav-item"><a class="nav-link" href="AtendimentoServlet">Atendimentos</a></li>
        <li class="nav-item"><a class="nav-link" href='ClienteServlet'>Clientes</a></li>
        <li class="nav-item"><a class="nav-link" href="FuncionarioServlet">Funcionarios</a></li>
        <li class="nav-item"><a class="nav-link" href="relatorios.jsp">Relatórios</a></li>

    </ul>
    <ul class="nav navbar-nav ml-auto">
        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
    </ul>
</div><!-- /.navbar-collapse -->