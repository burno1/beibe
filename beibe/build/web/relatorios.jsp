
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
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
        <script src="./bootstrap/js/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética
        </title>
    </head>
    <body>
        <jsp:useBean id="tipoBean" class="Bean.TipoAtendimentoBean" scope="request" />
        <jsp:setProperty name="tipoBean" property="*" />
        <nav  class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">BEIBE</a>
                </div>

                <!-- Cabeçalho -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="portalGerente.jsp">Portal<span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="AtendimentoServlet">Atendimentos</a></li>
                        <li class="nav-item"><a class="nav-link" href='ProdutoServlet'>Produtos</a></li>
                        <li class="nav-item"><a class="nav-link" href='ClienteServlet'>Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="FuncionarioServlet">Funcionarios</a></li>
                        <li class="nav-item active"><a class="nav-link" href="relatorios.jsp">Relatórios</a></li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li nav-item><a href='Invalidar'>User ${login.user} Logout</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div> 
        </nav>
        <br/>


        <div class="container">

            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Funcionarios</h4>
                    <hr/>
                    <form action="RelatorioDownload?action=r1" target="_blank" method="post">
                        <input hidden name="tipoAtendimento" value="1">
                        <input hidden name="dataInicio" value="1">
                        <input hidden name="dataFim" value="2">
                        <button class="btn btn-outline-primary" typ="submit"> Imprimir Relatório</button>
                    </form>
                    <br/>                    

                    <br/>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <h4>Produtos Mais reclamados</h4>
                    <hr/>
                    <form action="RelatorioDownload?action=produtosReclamados" target="_blank" method="post">
                        <input hidden name="tipoAtendimento" value="1">
                        <input hidden name="dataInicio" value="1">
                        <input hidden name="dataFim" value="2">
                        <button class="btn btn-outline-primary" typ="submit"> Imprimir Relatório</button>
                    </form>
                    <br/>                    

                    <br/>
                </div>
            </div>

            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Atendimentos Abertos</h4>
                    <hr/>
                    <form action="RelatorioDownload?action=r2" target="_blank" method="post">
                        <input hidden name="tipoAtendimento" value="1">

                        <div class="row">

                            <div class="col-xl-2">
                                Data Inicio:
                            </div>

                            <div class="col-md-4">
                                <input class="form-input" id="dataInicio" type="date" name="dataInicio" required>
                            </div>
                        </div>
                        <br/>

                        <div class="row">
                            <div class="col-xl-2">Data Fim:</div>
                            <div class="col-md-4">
                                <input class="form-input" id="dataFim" type="date" name="dataFim" required>
                            </div>

                        </div>

                        <button class="btn btn-outline-primary" type="submit"> Imprimir Relatório</button>
                        <br/>
                    </form>
                </div>

            </div>
            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Atendimentos Concluidos</h4>
                    <hr/>
                    <a href="./RelatorioDownload?action=r3" target="_blank"><button class="btn btn-outline-primary"> Imprimir Relatório</button></a>
                    <br/>                    

                    <br/>
                </div>
            </div>


            <div class="row">
                <div class="col-xl-12">
                    <h4>Relatório de Atendimentos Abertos</h4>
                    <hr/>
                    <form action="RelatorioDownload?action=r4" target="_blank" method="post">
                        <div class="row">


                            <label class="col-sm-2 col-form-label" for="tipoAtendimento">Tipo de Atendimento</label>
                            <div class="col-sm-6">
                                <select class="custom-select custom-select-md" name="tipoAtendimento" id="tipoAtendimento">

                                    <c:forEach items="${tipoBean.listaTipos}" var="t">     
                                        <option value="${t.idTipo}">${t.nomeTipo}</option>
                                    </c:forEach>
                                </select>   
                            </div>



                        </div>
                        <br/>

                        <button class="btn btn-outline-primary" type="submit"> Imprimir Relatório</button>
                        <br/>


                    </form>
                    <div class="row">
                        <div class="col-xl-12">
                            <h4>Relatório de Reclamações</h4>
                            <hr/>
                            <form action="RelatorioDownload?action=r5" target="_blank" method="post">
                                <input hidden name="tipoAtendimento" value="1">
                                <input hidden name="dataInicio" value="1">
                                <input hidden name="dataFim" value="2">
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="todas" value="todas" name="situacao" class="custom-control-input">
                                    <label class="custom-control-label" for="todas">Todas</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="aberto" value="0" name="situacao" class="custom-control-input">
                                    <label class="custom-control-label" for="aberto">Em Aberto</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="finalizado" value="1" name="situacao" class="custom-control-input">
                                    <label class="custom-control-label" for="finalizado">Finalizados</label>
                                </div>
                                <br/>
                                <button class="btn btn-outline-primary" type="submit"> Imprimir Relatório</button> 
                                <br/>
                            </form>
                        </div>
                    </div>
                </div>


            </div>




        </div>
        <footer id="sticky-footer" class="mt-auto py-4 bg-info text-white-50">
            <div class="container text-center">
                <small> Em caso de problemas, favor contatar o administrador pelo email: ${configuracao.email}</small>
            </div>
        </footer>
    </body>
</html>