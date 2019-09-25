/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.ClienteBean;
import Bean.PortalBean;
import Bean.UsuarioBean;
import DAO.UsuarioDAO;
import Model.Usuario;
import Utils.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno Fernandes
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

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
        
        if(request.getParameter("nome") == null) {
        RequestDispatcher rd = request.
                getRequestDispatcher("./cadastrarUsuario.jsp");
        request.setAttribute("usuarioBean", new UsuarioBean());
        rd.forward(request, response);
        } else {
             String nome = "";
        String email = "";
        String senha = "";

        nome = (String) request.getParameter("nome");
        email = (String) request.getParameter("email");
        senha = MD5.MD5Transformed((String) request.getParameter("senha"));

        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario usuarioSalvo = new Usuario();

        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);

        usuarioSalvo = uDAO.inserir(usuario);
        
        RequestDispatcher rd = request.
                getRequestDispatcher("LoginServlet");

        request.setAttribute("portalBean", new PortalBean());
        request.setAttribute("msg", "Usuario Inserido com Sucesso");
        rd.forward(request, response);
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
