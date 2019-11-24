<%-- 
    Document   : headerCliente
    Created on : 24/11/2019, 02:03:01
    Author     : Bruno Fernandes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li class="nav-item active"><a class="nav-link" href="PortalServlet">Portal</a></li>
    </ul>
    <ul class="nav navbar-nav ml-auto">
        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
    </ul>
</div><!-- /.navbar-collapse -->
