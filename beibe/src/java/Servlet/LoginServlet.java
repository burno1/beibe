/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.AtendimentoBean;
import Bean.LoginBean;
import Bean.PortalBean;
import Facade.AtendimentoService;
import Facade.ClienteService;
import Facade.LoginService;
import Model.Atendimento;
import Model.Cliente;

import Model.Funcionario;
import Utils.MD5;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Erick Alessi
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        LoginService loginService = new LoginService();
        String email = "";
        String senha = "";

        email = request.getParameter("email");
        senha = request.getParameter("senha");

        ClienteService clienteService = new ClienteService();

        Funcionario funcionarioLogado = loginService.buscar(email);
        Cliente clienteLogado = clienteService.buscarPorEmail(email);

        HttpSession s = request.getSession();
        LoginBean loginBean = new LoginBean();
        
        senha = MD5.MD5Transformed(senha);
        

        
        //Condicional de erro para login
        if (senha.equals(clienteLogado.getSenha()) || senha.equals(funcionarioLogado.getSenha()) )  {
            loginBean.setUser(email);

            loginBean.setSenha(MD5.MD5Transformed(senha));
            s.setAttribute("login", loginBean);
            s.setAttribute("funcionario", funcionarioLogado);
            s.setAttribute("clienteLogado", clienteLogado);
            s.setAttribute("portalBean", new PortalBean());

            if ("1".equals(funcionarioLogado.getTipo())) {
                response.sendRedirect("./portalGerente.jsp");
            }

            if ("2".equals(funcionarioLogado.getTipo())) {
                AtendimentoBean atendimentoBean = new AtendimentoBean();
                AtendimentoService atendimentoService = new AtendimentoService();

                atendimentoBean.setAtendimentosLista(atendimentoService.listar());
                atendimentoBean.setAtendimentosAbertos(atendimentoService.listarAbertos());

                RequestDispatcher rd = request.
                        getRequestDispatcher("/portalFuncionario.jsp");
                request.setAttribute("atendimentoBean", atendimentoBean);
                rd.forward(request, response);
            }

            if (clienteLogado.getId() != null) {
                AtendimentoBean atendimentoBean = new AtendimentoBean();
                AtendimentoService atendimentoService = new AtendimentoService();
                List<Atendimento> atendimentosLista = new ArrayList<Atendimento>();
                atendimentosLista =  atendimentoService.listarPorCliente(clienteLogado.getId());
                atendimentoBean.setAtendimentosLista(atendimentosLista);
                
                RequestDispatcher rd = request.
                        getRequestDispatcher("/portal.jsp");
                request.setAttribute("atendimentoBean", atendimentoBean);
                rd.forward(request, response);
            }

        } else {
            RequestDispatcher rd = request.
                    getRequestDispatcher("/ErroServlet");
            request.setAttribute("msg", "Senha ou Usuário incorretos!");
            request.setAttribute("page", "index.jsp");

            rd.forward(request, response);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
