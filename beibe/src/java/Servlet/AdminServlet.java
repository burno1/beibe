/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.PortalBean;
import Facade.UsuarioService;
import Model.Usuario;
import java.io.IOException;
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
 * @author Bruno Fernandes
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
        PortalBean pb = new PortalBean();
        HttpSession s = request.getSession();
        ArrayList<Usuario> usuarios = ((ArrayList<Usuario>) s.getAttribute("listaUsuarios"));
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        UsuarioService usuarioService = new UsuarioService(); 

        listaUsuarios = usuarioService.listar();
        String nome = "";
        String email = "";
        String senha = "";

        try {
            if (s.getAttribute("login") == null) {
                RequestDispatcher rd = request.
                        getRequestDispatcher("/ErroServlet");
                request.setAttribute("msg", "Erro acessando a Servlet");
                request.setAttribute("page", "index.jsp");
                rd.forward(request, response);
            }
            if (request.getParameter("email") != null) {
                nome = (String) request.getParameter("nome");
                email = (String) request.getParameter("email");
                senha = (String) request.getParameter("senha");

                Usuario usuario = new Usuario(nome, email, senha, "");
                usuarios.add(usuario);
            }
            RequestDispatcher rd = request.
                    getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
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