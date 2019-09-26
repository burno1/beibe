<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% if (session.getAttribute("login") == null) {
        RequestDispatcher rd = request.
                getRequestDispatcher("/ErroServlet");
        request.setAttribute("msg", "Não vem de hack!");
        request.setAttribute("page", "index.jsp");
        rd.forward(request, response);
    }%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/login.css" rel="stylesheet" />
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
        <link href="./css/atendimento.css" rel="stylesheet" />

        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="jquery-3.4.1.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>


        <style>

            #title_bar{
                background: #FEFEFE;
            }
            #button{
                border:solid 1px;
                width: 25px;
                height: 23px;
                float:right;
                cursor:pointer;
            }
            #box{
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="portal.jsp">Portal (Cliente) <span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href="portalFuncionario.jsp">Portal (Funcionario) <span class="sr-only">(current)</span></a></li>
                        <li><a href="portalGerente.jsp">Portal (Gerente) <span class="sr-only">(current)</span></a></li>
                        <li><a href='ClienteServlet'>Cadastro Clientes</a></li>
                        <li><a href="admin.jsp">Admin (Portal Antigo)</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <div class="container">
            <div class="row">
                
                
                <div id="widnow">
                    <div id="title_bar">
                           <h3>Atendimentos em Aberto:</h3>
                        <div id="button">-</div>
                    </div>     

                    <div id="box">
                        <table class="table">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">Nº</th>
                                    <th scope="col">Data/Hora</th>
                                    <th scope="col">Tipo</th>
                                    <th scope="col">Situação</th>
                                    <th scope="col">Detalhes</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="urgente">
                                    <td>1</td>
                                    <td>10/09/2019 12:11</td>
                                    <td>Aberto</td>
                                    <td>Não sei os tipos</td>
                                    <td><form action="DetalhesAtendimentoServlet">
                                            <input name="idCliente" hidden="true" value="1">
                                            <button type="submit">Detalhes</button>
                                        </form></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>25/09/2019 12:51</td>
                                    <td>Aberto</td>
                                    <td>Não sei os tipos</td>
                                    <td><form action="DetalhesAtendimentoServlet">
                                            <input name="idCliente" hidden="true" value="1">
                                            <button type="submit">Detalhes</button>
                                        </form></td>

                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>31/09/2019 12:51</td>
                                    <td>Aberto</td>
                                    <td>Não sei os tipos</td>
                                    <td><form action="DetalhesAtendimentoServlet">
                                            <input name="idCliente" hidden="true" value="1">
                                            <button type="submit">Detalhes</button>
                                        </form></td>

                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>01/12/2019 13:34</td>
                                    <td>Aberto</td>
                                    <td>Não sei os tipos</td>
                                    <td><form action="DetalhesAtendimentoServlet">
                                            <input name="idCliente" hidden="true" value="1">
                                            <button type="submit">Detalhes</button>
                                        </form></td>

                                </tr>
                            </tbody>
                        </table>
                    </div>

                </div>              
            </div>

            <div class="row">
                <div class="col">
                    <h3>Todos os Atendimentos:</h3>
                </div>


                <table class="table">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Nº</th>
                            <th scope="col">Data/Hora</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Situação</th>
                            <th scope="col">Detalhes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="urgente">
                            <td>1</td>
                            <td>14/09/2019 12:11</td>
                            <td>Aberto</td>
                            <td>Não sei os tipos</td>
                            <td><form action="DetalhesAtendimentoServlet">
                                    <input name="idCliente" hidden="true" value="1">
                                    <button type="submit">Detalhes</button>
                                </form></td>
                        </tr>
                        <tr class="atencao">
                            <td>2</td>
                            <td>20/09/2019 12:51</td>
                            <td>Aberto</td>
                            <td>Não sei os tipos</td>
                            <td><form action="DetalhesAtendimentoServlet">
                                    <input name="idCliente" hidden="true" value="1">
                                    <button type="submit">Detalhes</button>
                                </form></td>

                        </tr>
                        <tr>
                            <td>3</td>
                            <td>31/09/2019 12:51</td>
                            <td>Aberto</td>
                            <td>Não sei os tipos</td>
                            <td><form action="DetalhesAtendimentoServlet">
                                    <input name="idCliente" hidden="true" value="1">
                                    <button type="submit">Detalhes</button>
                                </form></td>

                        </tr>
                        <tr>
                            <td>3</td>
                            <td>01/12/2019 13:34</td>
                            <td>Aberto</td>
                            <td>Não sei os tipos</td>
                            <td><form action="DetalhesAtendimentoServlet">
                                    <input name="idCliente" hidden="true" value="1">
                                    <button type="submit">Detalhes</button>
                                </form></td>

                        </tr>
                    </tbody>
                </table>
            </div>

        </div>       
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> contato: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>

<script>
    $("#button").click(function () {
        if ($(this).html() == "-") {
            $(this).html("+");
        } else {
            $(this).html("-");
        }
        $("#box").slideToggle();
    });
</script>