/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UsuarioDAO;
import Model.Usuario;
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
        HttpSession s = request.getSession();
        ArrayList<Usuario> usuarios = ((ArrayList<Usuario>) s.getAttribute("listaUsuarios"));
        List<Usuario> usuariosBanco = new ArrayList<Usuario>();

        usuariosBanco = new UsuarioDAO().buscarTodos();
        String nome = "";
        String email = "";
        String senha = "";

        try {
            if (s.getAttribute("email") == null) {
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

        } catch (Exception e) {
        }
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServlet</title>");
            out.println("<link href=\"./bootstrap/css/bootstrap.css\" rel=\"stylesheet\" />\n"
                    + "        <link href=\"./bootstrap/css/bootstrap-theme.css\" rel=\"stylesheet\"/>\n"
                    + "        <link href=\"./css/login.css\" rel=\"stylesheet\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h6> User " + s.getAttribute("email") + "<a href=\'Invalidar'>   logout</a></h6>");
            out.println("<form action=\"CadastraUsuarioServlet\" method=\"post\">\n"
                    + "            <div class=\"container\">\n"
                    + "                <div class=\"form-group row\">\n"
                    + "                    <label class=\"col-sm-2 col-form-label\" for=\"nome\">Nome</label>\n"
                    + "                    <div class=\"col-sm-10\">\n"
                    + "                        <input type=\"text\" name=\"nome\" class=\"form-control\" required>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group row\">\n"
                    + "                    <label class=\"col-sm-2 col-form-label\" for=\"email\">E-mail</label>\n"
                    + "                    <div class=\"col-sm-10\">\n"
                    + "                        <input type=\"email\" name=\"email\" class=\"form-control\" required>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-group row\">\n"
                    + "                    <label class=\"col-sm-2 col-form-label\" for=\"senha\">Senha </label>\n"
                    + "                    <div class=\"col-sm-10\">\n"
                    + "                        <input type=\"password\" name=\"senha\" class=\"form-control\" required>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "\n"
                    + "                <div class=\"form-group row\">\n"
                    + "                    <div class=\"col-sm-2\">\n"
                    + "                        <button type=\"submit\" class=\"btn btn-success btn-block\">Salvar</button>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "\n"
                    + "\n"
                    + "        </form>");
            if (usuariosBanco.size() > 0) {
               
                out.println("<table class=\"table\">\n"
                        + "            <thead class=\"thead-light\">\n"
                        + "                <tr>\n"
                        + "                    <th scope=\"col\">Nome</th>\n"
                        + "                    <th scope=\"col\">E-mail</th>\n"
                        + "                    <th scope=\"col\">Senha</th>\n"
                        + "                </tr>\n"
                        + "            </thead>"
                        + "            <tbody>\n");
                usuariosBanco.forEach((u) -> {
                    out.println("<tr><th>" + u.getNome() + "</th><th>" + u.getEmail() + "</th><th>" + u.getSenha() + "</th></tr>");
                });
                out.println("</tbody></table></body>");

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
