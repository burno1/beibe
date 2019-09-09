<%-- 
    Document   : index
    Created on : Aug 27, 2019, 5:36:47 PM
    Author     : Bruno Fernandes, Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="./bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>

        <link href="./css/login.css" rel="stylesheet" />
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>
    </head>
    <body>
        <div class="dialog">

            <h6> BEIBE - Beauty Embuste Indústria de Beleza e Estética </h6><br>

            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalLogin">
                Login
            </button>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"  id="exampleModalLongTitle">Digite seu e-mail e senha </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
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
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>

