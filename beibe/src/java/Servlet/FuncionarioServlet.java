/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.CidadesBean;
import Bean.FuncionarioBean;
import Bean.EstadosBean;
import Bean.PortalBean;
import DAO.CidadeDAO;
import Exceptions.AppException;
import Exceptions.ErroFuncionario;
import Facade.AtendimentoService;
import Facade.CidadeService;

import Facade.FuncionarioService;
import Model.Cidade;
import Model.Funcionario;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno F
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession s = request.getSession();

        if (s.getAttribute("login") == null) {
            System.out.println("true");
            RequestDispatcher rd = request.
                    getRequestDispatcher("ErroServlet");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            request.setAttribute("page", "index.jsp");
            rd.forward(request, response);
        }

        FuncionarioBean cbean = new FuncionarioBean();
        FuncionarioService funcionarioService = new FuncionarioService();
        AtendimentoService atendimentoService = new AtendimentoService();

        String acao = request.getParameter("action");

        if (null == acao || "listar".equals(acao)) {

            try {

                cbean.setListaFuncionarios(funcionarioService.listar());

                if (cbean.getListaFuncionarios() == null) {
                    throw new ErroFuncionario("Não foi possivel carregar lista de funcionarios");
                }
                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);

                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                request.setAttribute("msg", e.getMsg());
            }
        }
        if ("show".equals(acao)) {
            try {
                String id = request.getParameter("id");
                Funcionario funcionario = funcionarioService.buscar(id);

                if (funcionario.getCpf() == null) {
                    throw new ErroFuncionario("Não foi possivel buscar o funcionario");
                }

                RequestDispatcher rd = request.
                        getRequestDispatcher("./funcionarioAlterar.jsp");
                request.setAttribute("funcionario", funcionario);
                request.setAttribute("mostra", 1);
                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);
            }
        }
        if ("formUpdate".equals(acao)) {
            try {
                CidadeService cidadeService = new CidadeService();
                String id = request.getParameter("id");

                Funcionario funcionario = funcionarioService.buscar(id);

                if (funcionario.getCidade() == null) {
                    throw new ErroFuncionario("Não foi possivel buscar este funcionario");
                }

                RequestDispatcher rd = request.
                        getRequestDispatcher("./funcionarioAlterar.jsp");
                CidadesBean cidadeBean = new CidadesBean();
                CidadeDAO cidadeDao = new CidadeDAO();

                Cidade funcionarioCidade = funcionario.getCidade();
                cidadeBean.setCidades(cidadeService.buscarPorEstado(funcionario.getCidade().getEstado()));

                request.setAttribute("funcionario", funcionario);
                request.setAttribute("cidadesBean", cidadeBean);
                rd.forward(request, response);

            } catch (AppException e) {
                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("remove".equals(acao)) {
            try {
                String id = request.getParameter("id");

                if (!funcionarioService.remover(id)) {
                    throw new ErroFuncionario("Não foi possivel remover funcionario");
                }

                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("update".equals(acao)) {
            try {

                if (request.getParameter("id").equals("")) {

                    LocalDate data = null;
                    Funcionario funcionario = new Funcionario();
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        String str = request.getParameter("data");   // Data como String

                        data = LocalDate.parse(str);

                    } catch (Exception e) {

                    }
                    String cpf = request.getParameter("cpf");
                    cpf = cpf.replaceAll("[^0-9]", "");

                    funcionario.setCpf(cpf);
                    funcionario.setNome(request.getParameter("nome"));
                    funcionario.setEmail(request.getParameter("email"));
                    funcionario.setData(data.plusDays(1));
                    funcionario.setRua(request.getParameter("rua"));
                    funcionario.setNumero(Integer.valueOf(request.getParameter("numero")));
                    funcionario.setCep(Integer.valueOf(request.getParameter("cep")));
                    funcionario.setCidade(new Cidade(Integer.valueOf(request.getParameter("cidade")), request.getParameter("uf")));

                    if (funcionarioService.inserir(funcionario) == null) {
                        throw new ErroFuncionario("Não foi possível inserir funcionario");
                    }

                    cbean.setListaFuncionarios(funcionarioService.listar());

                    RequestDispatcher rd = request.
                            getRequestDispatcher("/funcionarioListar.jsp");
                    request.setAttribute("funcionarioBean", cbean);
                    request.setAttribute("action", "listar");

                    rd.forward(request, response);

                }

                LocalDate data = null;
                Funcionario funcionario = new Funcionario();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = request.getParameter("data");   // Data como String

                data = LocalDate.parse(str);

                funcionario.setId(request.getParameter("id"));

                String cpf = request.getParameter("cpf");
                cpf = cpf.replaceAll("[^0-9]", "");

                funcionario.setCpf(cpf);
                funcionario.setNome(request.getParameter("nome"));
                funcionario.setEmail(request.getParameter("email"));
                funcionario.setData(data);
                funcionario.setRua(request.getParameter("rua"));
                funcionario.setNumero(Integer.valueOf(request.getParameter("numero")));
                funcionario.setCep(Integer.valueOf(request.getParameter("cep")));
                funcionario.setCidade(new Cidade(Integer.valueOf(request.getParameter("cidade")), request.getParameter("uf")));
                
                if(funcionarioService.alterar(funcionario)){
                    throw new ErroFuncionario("Não foi possivel alterar este funcionario");
                }
                

                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                request.setAttribute("action", "listar");

                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);
            }
        }
        if ("formNew".equals(acao)) {
            Funcionario funcionario = new Funcionario();
            RequestDispatcher rd = request.
                    getRequestDispatcher("/funcionarioAlterar.jsp");
            request.setAttribute("funcionario", funcionario);
            rd.forward(request, response);
        }
        if ("new".equals(acao)) {
            LocalDate data = null;

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = request.getParameter("data");   // Data como String

                data = LocalDate.parse(str);

            } catch (Exception e) {

            }
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(request.getParameter("cpf"));
                funcionario.setNome(request.getParameter("nome"));
                funcionario.setEmail(request.getParameter("email"));
                funcionario.setData(data);
                funcionario.setRua(request.getParameter("rua"));
                funcionario.setNumero(Integer.valueOf(request.getParameter("numero")));
                funcionario.setCep(Integer.valueOf(request.getParameter("cep")));
                funcionario.setCidade(new Cidade(Integer.valueOf(request.getParameter("cidade")), request.getParameter("uf")));
                funcionarioService.inserir(funcionario);

                cbean.setListaFuncionarios(funcionarioService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("./funcionarioListar.jsp");
                request.setAttribute("funcionarioBean", cbean);
                rd.forward(request, response);

            } catch (Exception e) {
                request.setAttribute("javax.servlet.jsp.jspException", e);
                request.setAttribute("javax.servlet.error.status_code", 500);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
