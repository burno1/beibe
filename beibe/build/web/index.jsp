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
        <link href="./css/login1.css" rel="stylesheet" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!-- Include the above in your HEAD tag -->
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>
    </head>
    <body>

        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <div class="main">


            <div class="container">
                <center>
                    <div class="middle">
                        <div id="login">

                            <form action="LoginServlet" method="post">

                                <fieldset class="clearfix">

                                    <p ><span class="fa fa-user"></span><input type="text" id="email" name="email" placeholder="a@a.com" required="true" autofocus></p> <!-- JS because of IE support; better: placeholder="Username" -->
                                    <p><span class="fa fa-lock"></span><input type="password"  id="senha" name="senha" required="true"></p> <!-- JS because of IE support; better: placeholder="Password" -->

                                    <div>
                                        <span style="width:48%; text-align:left;  display: inline-block;"><a class="small-text" href="cadastrarUsuario.jsp">Cadastre-se</a></span>
                                        <span style="width:50%; text-align:right;  display: inline-block;"><input type="submit" value="Sign In"></span>
                                    </div>

                                </fieldset>
                                <div class="clearfix"></div>
                            </form>

                            <div class="clearfix"></div>

                        </div> <!-- end login -->
                        <div class="logo">BEIBE

                            <div class="clearfix"></div>
                        </div>

                    </div>
                </center>
            </div>

        </div>
    </body>
</html>

