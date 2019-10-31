/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.ClienteBean;
import Bean.PortalBean;

import Facade.ClienteService;
import Model.Cidade;
import Model.Cliente;
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
        HttpSession s = request.getSession();

        if (s.getAttribute("login") == null) {
            System.out.println("true");
            RequestDispatcher rd = request.
                    getRequestDispatcher("ErroServlet");
            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");
            request.setAttribute("page", "index.jsp");
            rd.forward(request, response);
        }

        ClienteBean cbean = new ClienteBean();
        ClienteService clienteService = new ClienteService();

        String acao = request.getParameter("action");

        if (null == acao || "listar".equals(acao)) {
            cbean.setListaClientes(clienteService.listar());

            RequestDispatcher rd = request.
                    getRequestDispatcher("/clientesListar.jsp");
            request.setAttribute("clienteBean", cbean);

            rd.forward(request, response);
        }
        if ("show".equals(acao)) {
            String id = request.getParameter("id");
            Cliente cl = clienteService.buscar(id);

            RequestDispatcher rd = request.
                    getRequestDispatcher("./clientesVisualizar.jsp");
            request.setAttribute("cliente", cl);
            rd.forward(request, response);
        }
        if ("formUpdate".equals(acao)) {
            try {
                String id = request.getParameter("id");
                Cliente cl = clienteService.buscar(id);
                RequestDispatcher rd = request.
                        getRequestDispatcher("./clientesAlterar.jsp");
                request.setAttribute("cliente", cl);
                rd.forward(request, response);
            } catch (Exception e) {
                request.setAttribute("exception", e);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);

            }

        }
        if ("remove".equals(acao)) {
            String id = request.getParameter("id");
            clienteService.remover(id);
            cbean.setListaClientes(clienteService.listar());

            RequestDispatcher rd = request.
                    getRequestDispatcher("/clientesListar.jsp");
            request.setAttribute("clienteBean", cbean);
            rd.forward(request, response);

        }
        if ("update".equals(acao)) {
            LocalDate data = null;
            Cliente cl = new Cliente();
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = request.getParameter("data");   // Data como String

                data = LocalDate.parse(str);

            } catch (Exception e) {

            }

            cl.setId(Integer.valueOf(request.getParameter("id")));
            cl.setCpf(request.getParameter("cpf"));
            cl.setNome(request.getParameter("nome"));
            cl.setEmail(request.getParameter("email"));
            cl.setData(data);
            cl.setRua(request.getParameter("rua"));
            cl.setNumero(Integer.valueOf(request.getParameter("numero")));
            cl.setCep(Integer.valueOf(request.getParameter("cep")));
            cl.setCidade(new Cidade(request.getParameter("cidade"), request.getParameter("uf")));
            clienteService.alterar(cl);

            cbean.setListaClientes(clienteService.listar());

            RequestDispatcher rd = request.
                    getRequestDispatcher("/clientesListar.jsp");
            request.setAttribute("clienteBean", cbean);
            request.setAttribute("action", "listar");

            rd.forward(request, response);
        }
        if ("formNew".equals(acao)) {
            RequestDispatcher rd = request.
                    getRequestDispatcher("/clientesNovo.jsp");
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
                Cliente cl = new Cliente();
                cl.setCpf(request.getParameter("cpf"));
                cl.setNome(request.getParameter("nome"));
                cl.setEmail(request.getParameter("email"));
                cl.setData(data);
                cl.setRua(request.getParameter("rua"));
                cl.setNumero(Integer.valueOf(request.getParameter("numero")));
                cl.setCep(Integer.valueOf(request.getParameter("cep")));
                cl.setCidade(new Cidade(request.getParameter("cidade"), request.getParameter("uf")));
                clienteService.inserir(cl);
                

                cbean.setListaClientes(clienteService.listar());

                RequestDispatcher rd = request.
                        getRequestDispatcher("./clientesListar.jsp");
                request.setAttribute("clienteBean", cbean);
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
