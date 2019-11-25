/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.AtendimentoBean;
import Bean.CidadesBean;
import Bean.ClienteBean;
import Bean.LoginBean;
import Bean.PortalBean;
import DAO.CidadeDAO;
import Exceptions.AppException;
import Exceptions.ErroCliente;
import Facade.AtendimentoService;
import Facade.CidadeService;

import Facade.ClienteService;
import Model.Cidade;
import Model.Cliente;
import Model.Funcionario;
import Utils.MD5;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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

        if (s.getAttribute("login") == null && request.getParameter("email") == null) {
            System.out.println("true");
            RequestDispatcher rd = request.
                    getRequestDispatcher("ErroServlet");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            request.setAttribute("page", "index.jsp");
            rd.forward(request, response);
        }

        ClienteBean cbean = new ClienteBean();
        ClienteService clienteService = new ClienteService();
        AtendimentoService atendimentoService = new AtendimentoService();

        String acao = request.getParameter("action");

        if (null == acao || "listar".equals(acao)) {

            try {

                cbean.setListaClientes(clienteService.listar());

                if (cbean.getListaClientes() == null) {
                    throw new ErroCliente("Não foi possivel carregar lista de clientes");
                }
                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);

                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
                request.setAttribute("msg", e.getMsg());
            }
        }
        if ("show".equals(acao)) {
            try {
                String id = request.getParameter("id");
                Cliente cl = clienteService.buscar(id);

                if (cl.getCpf() == null) {
                    throw new ErroCliente("Não foi possivel buscar o cliente");
                }

                RequestDispatcher rd = request.
                        getRequestDispatcher("./clientesAlterar.jsp");
                request.setAttribute("cliente", cl);
                request.setAttribute("mostra", 1);
                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);
            }
        }
        if ("formUpdate".equals(acao)) {
            try {
                CidadeService cidadeService = new CidadeService();
                String id = request.getParameter("id");

                Cliente cl = clienteService.buscar(id);

                if (cl.getCidade() == null) {
                    throw new ErroCliente("Não foi possivel buscar este cliente");
                }

                RequestDispatcher rd = request.
                        getRequestDispatcher("./clientesAlterar.jsp");
                CidadesBean cidadeBean = new CidadesBean();
                CidadeDAO cidadeDao = new CidadeDAO();

                Cidade clienteCidade = cl.getCidade();
                cidadeBean.setCidades(cidadeService.buscarPorEstado(cl.getCidade().getEstado()));

                request.setAttribute("cliente", cl);
                request.setAttribute("altera", 1);
                request.setAttribute("cidadesBean", cidadeBean);
                rd.forward(request, response);

            } catch (AppException e) {
                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("remove".equals(acao)) {
            try {
                String id = request.getParameter("id");

                if (!clienteService.remover(id)) {
                    throw new ErroCliente("Não foi possivel remover cliente");
                }

                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("update".equals(acao)) {
            try {

                LocalDate data = null;
                Cliente cl = new Cliente();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = request.getParameter("data");   // Data como String
                data = LocalDate.parse(str);

                String cpf = request.getParameter("cpf");
                cpf = cpf.replaceAll("[^0-9]", "");

                cl.setCpf(cpf);
                cl.setId(request.getParameter("id"));
                cl.setNome(request.getParameter("nome"));
                cl.setEmail(request.getParameter("email"));
                cl.setData(data.plusDays(1));
                cl.setRua(request.getParameter("rua"));
                cl.setNumero(Integer.valueOf(request.getParameter("numero")));
                cl.setCep(Integer.valueOf(request.getParameter("cep")));
                cl.setCidade(new Cidade(Integer.valueOf(request.getParameter("cidade")), request.getParameter("uf")));

                if (request.getParameter("id").equals("")) {
                    Cliente clienteBanco = new Cliente();

                    if (!clienteService.inserir(cl)) {
                        throw new ErroCliente("Não foi possível inserir cliente");
                    }

                } else {
                    if (!clienteService.alterar(cl)) {
                        throw new ErroCliente("Não foi possivel alterar este cliente");
                    }
                }
                String pagina = "/clientesListar.jsp";
                cbean.setListaClientes(clienteService.listar());
                Cliente clienteLogado = (Cliente) s.getAttribute("clienteLogado");
                if (clienteLogado.getId() != null) {
                     pagina = "PortalServlet";
                }
                RequestDispatcher rd = request.
                        getRequestDispatcher(pagina);
                request.setAttribute("clienteBean", cbean);
                request.setAttribute("action", "listar");

                rd.forward(request, response);
            } catch (AppException e) {
                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);
            }
        }
        if ("formNew".equals(acao)) {
            RequestDispatcher rd = request.
                    getRequestDispatcher("/clientesAlterar.jsp");
            rd.forward(request, response);
        }
        if ("new".equals(acao)) {
            LocalDate data = null;

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = request.getParameter("data");   // Data como String

                data = LocalDate.parse(str);
                AtendimentoBean atendBean = new AtendimentoBean();

                String cpf = request.getParameter("cpf");
                cpf = cpf.replaceAll("[^0-9]", "");

                Cliente cl = new Cliente();
                cl.setCpf(cpf);
                cl.setNome(request.getParameter("nome"));
                cl.setSenha(request.getParameter("senha"));
                cl.setEmail(request.getParameter("email"));
                cl.setData(data);
                cl.setRua(request.getParameter("rua"));
                cl.setNumero(Integer.valueOf(request.getParameter("numero")));
                cl.setCep(Integer.valueOf(request.getParameter("cep")));
                cl.setCidade(new Cidade(Integer.valueOf(request.getParameter("cidade")), request.getParameter("uf")));

                if (!clienteService.inserir(cl)) {
                    throw new ErroCliente("Não foi possível inserir cliente");
                }

                Cliente clienteLogado = clienteService.buscarPorEmail(cl.getEmail());
                LoginBean loginBean = new LoginBean();
                loginBean.setUser(cl.getEmail());
                Funcionario funcionarioLogado = new Funcionario();

                loginBean.setSenha(MD5.MD5Transformed(cl.getSenha()));
                s.setAttribute("login", loginBean);
                s.setAttribute("funcionario", funcionarioLogado);
                s.setAttribute("cliente", clienteLogado);
                s.setAttribute("portalBean", new PortalBean());

                RequestDispatcher rd = request.
                        getRequestDispatcher("./portal.jsp");
                rd.forward(request, response);

            } catch (AppException e) {

                RequestDispatcher rd = request.
                        getRequestDispatcher("/cadastrarUsuario.jsp");
                request.setAttribute("msg", e.getMsg());
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
