<%-- 
    Document   : portal
    Created on : Sep 10, 2019, 8:47:22 PM
    Author     : Erick Alessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<% if (session.getAttribute("login") == null) {%>
<jsp:forward page="index.jsp">
    <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
</jsp:forward>
<% }%>    
<%@page errorPage="erro.jsp"%>

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
        <jsp:useBean id="atendimentoBean" class="Bean.AtendimentoBean" scope="request" />
        <jsp:setProperty name="atendimentoBean" property="*" />
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item active"><a class="nav-link" href="portal.jsp">Portal (Cliente) <span class="sr-only">(current)</span></a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>

        <div class="container">
            <h3>Detalhes do Cliente</h3>
            <form action="ClienteServlet?action=formUpdate&id=${clienteLogado.id}"  method="post">

                <div class="form-group row">
                    <div class="col-sm-4">
                        <button class="btn btn-success btn-block" type="submit">Atualizar Dados Cadastrais</button>
                    </div>
                </div>
            </form>

            <hr>
            <div class="form-group row">
                <div class="col-sm-8">
                    <h4>Atendimentos Relacionados</h4>
                </div>
                <div class="row">
                    <div class="col-sm-12"><a href="AtendimentoServlet?action=formNew">  <button class="btn btn-primary"> Novo </button></a>
                    </div>
                </div>
            </div>

            <hr>

            <table class="table">
                <thead class="thead-light">
                    <tr >
                        <th scope="col">Nº</th>
                        <th scope="col">Data/Hora</th>
                        <th scope="col">Produto</th>
                        <th scope="col">Cliente</th>
                        <th scope="col">Opções</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${atendimentoBean.atendimentosLista}" var="a">
                        <tr ${a.atrasado == 1 ?  'class="urgente"' : 'class="atencao"'}>
                            <td><c:out value="${a.id}"/></td>
                            <td><c:out value="${a.dataString} " /></td>
                            <td><c:out value="${a.produto.nomeProduto}" /></td>
                            <td><c:out value="${a.cliente.nome}" /></td>
                            <td>
                                <a href="AtendimentoServlet?action=show&id=${a.id}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                <button type="button" class="btn btn-danger" onclick="confirmRemove(${a.id})" ${a.resolvido == 0 ? '' : 'hidden'}>Remover</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Modal -->
            <div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Título do modal</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            ...
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary">Salvar mudanças</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>      
        <footer id="sticky-footer" class="py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>

<script>
    function confirmRemove(id) {
        var txt;
        var r = confirm("Deseja Remover? :(");
        if (r == true) {
            window.location.replace("./AtendimentoServlet?action=remove&id=" + id);
        }
        console.log(txt);
    }
</script>
