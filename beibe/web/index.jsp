<%-- 
    Document   : index
    Created on : Aug 27, 2019, 5:36:47 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
        <link href="./css/login.css" rel="stylesheet" />
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>
    </head>
    <body>
        <div class="dialog">
            <main> <h6> BEIBE - Beauty Embuste Indústria de Beleza e Estética </h6><br>
                <form action="LoginServlet" method="post" modelAttribute="user">
                    <div class="form-group">
                        <label path="email">E-mail</form:label>
                            <input type="email" name="email" class="block" required="true"/>
                    </div>
                    <div class="form-group">
                        <label path="senha">Senha </form:label>
                            <input type="password" name="senha" class="block" required="true"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-block">Login</button>
                    </div>
                </form>
            </main>
        </div>
    </body>
</html>
