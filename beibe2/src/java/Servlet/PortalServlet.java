/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick Alessi
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

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
        ArrayList<Usuario> usuarios = ((ArrayList<Usuario>) request.getSession().getAttribute("listaUsuarios"));

        String nome = "";
        String email = "";
        String senha = "";
        try {
            if (request.getParameter("nome") != null) {
                nome = (String) request.getParameter("nome");
                email = (String) request.getParameter("email");
                senha = (String) request.getParameter("senha");
                Usuario usuario = new Usuario(nome, email, senha, "");
                usuarios.add(usuario);
            }
        } catch (Exception e) {
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h6> User " + request.getSession().getAttribute("user") + "<a href=\'Invalidar'>   logout</a></h6>");
            out.println("<form action=\"PortalServlet\" method=\"post\" modelAttribute=\"user\">\n"
                    + "                    <div class=\"form-group\">\n"
                    + "                        <label path=\"nome\">Nome</form:label>\n"
                    + "                            <input type=\"text\" name=\"nome\" class=\"block\" required=\"true\"/>\n"
                    + "                        <label path=\"email\">E-mail</form:label>\n"
                    + "                            <input type=\"email\" name=\"email\" class=\"block\" required=\"true\"/>\n"
                    + "                        <label path=\"senha\">Senha </form:label>\n"
                    + "                            <input type=\"password\" name=\"senha\" class=\"block\" required=\"true\"/>\n"
                    + "                        <button type=\"submit\" class=\"btn btn-success btn-block\">Adicionar</button>\n"
                    + "                </form>");
            if (usuarios.size() > 0) {
                out.println("<table style=\"width:100%\"><tr>\n"
                        + "    <th>Nome</th>\n"
                        + "    <th>Email</th> \n"
                        + "    <th>Senha</th>\n"
                        + "  </tr>");
                usuarios.forEach((u) -> {
                    out.println("<tr><th>" + u.getNome() + "</th><th>" + u.getEmail() + "</th><th>" + u.getSenha() + "</th></tr>");
                });
                out.println("</table></body>");
                out.println("</html>");

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
