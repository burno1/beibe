<%-- 
    Document   : index
    Created on : Aug 27, 2019, 5:36:47 PM
    Author     : Bruno Fernandes, Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/login.css" rel="stylesheet" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>
    </head>
    <body>
        
        <div class="dialog">
            <h6> BEIBE - Beauty Embuste Indústria de Beleza e Estética </h6><br>

            <form action="LoginServlet" method="post" modelAttribute="user">

                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" name="email" placeholder="a@a.com" required="true">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="senha" class="col-sm-2 col-form-label">Senha</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="senha" name="senha" required="true">
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block">Login</button>
                </div>
            </form>
            <div class="badnews">${param["msg"]} ${mensagem}</div>
            
            <form action="CadastrarUsuarioServlet" method="post" modelAttribute="user">
            <p>Não é usuário? Cadastre-se</p>
             <div class="form-group">
               <button type="submit" class="btn btn-info btn-block">Cadastrar</button>
             </div>
            </form>
            
        </div>
    </body>
</html>

