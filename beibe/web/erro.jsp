<%-- 
    Document   : erro.jsp
    Created on : Sep 13, 2019, 6:07:57 PM
    Author     : Erick Alessi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!DOCTYPE html>
    <html>
        <head>
            <title>Servlet ErroServlet</title>
        </head>
        <body>
            <h1>${Mensagem}</h1>
            <h2> ${mensagem} </h2>
            <a href="${pagina}"> Voltar</a>
            <footer id="sticky-footer" class="py-4 bg-info text-white-50">
                <div class="container text-center">
                    <small> Em caso de cagada, contate: ${configuracao.email}</small>
                </div>
            </footer>
        </body>
    </html>
</body>
</html>
