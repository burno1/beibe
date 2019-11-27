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
        <%@include file="imports.jsp" %>
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
                <c:choose>
                    <c:when test="${funcionario.tipo == 1}">

                        <%@ include file = "headerGerente.jsp" %> 
                    </c:when>
                    <c:when test="${funcionario.tipo == 2}">

                        <%@ include file = "headerFuncionario.jsp" %> 
                    </c:when>
                    <c:when test="${clienteLogado.id != null}">

                        <%@ include file = "headerCliente.jsp" %> 
                    </c:when>
                </c:choose>
            </div> 
        </nav>

        <br/>
        <div class="container-fluid">

            <br/>
            <div class="row">
                <div class="col">
                    <span style="color: red">${msg}</span>
                </div>
            </div>


            <div class="row">
                <div class="col-sm-12">
                    <h3> Todos os Atendimentos </h3>
                    <hr/>
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
                                        <button type="button" class="btn btn-danger" onclick="confirmRemove(${a.id})">Remover</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <h3> Todos os Atendimentos Abertos</h3>
                    <hr/>
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
                            <c:forEach items="${atendimentoBean.atendimentosAbertos}" var="a">
                                <tr ${a.atrasado == 1 ?  'class="urgente"' : 'class="atencao"'}>
                                    <td><c:out value="${a.id}"/></td>
                                    <td><c:out value="${a.dataString} " /></td>
                                    <td><c:out value="${a.produto.nomeProduto}" /></td>
                                    <td><c:out value="${a.cliente.nome}" /></td>
                                    <td>
                                        <a href="AtendimentoServlet?action=show&id=${a.id}&mostra=0"><button type="button" class="btn btn-info">Visualizar</button> </a>
                                        <a href="AtendimentoServlet?action=formUpdate&id=${a.id}"><button type="button" class="btn btn-secondary">Alterar</button> </a>
                                        <button type="button" class="btn btn-danger" onclick="confirmRemove(${a.id})">Remover</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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