<%-- 
    Document   : erro.jsp
    Created on : Sep 13, 2019, 6:07:57 PM
    Author     : Erick Alessi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <div>${Mensagem}</div>
        
        IHUUUUUUUUUUU
        <form>
            <% out.append(request.getParameter("exception"));%>
            <p>${pageContext.exception.message}</p>
            <br/>
            <p>${pageContext.out.flush()} </p>
            <br/>
            <p>${pageContext.exception.printStackTrace(pageContext.response.writer)}</p>
        </form>

        <a class="nav-link" href="portalGerente.jsp">Portal (Gerente)</a>
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>
