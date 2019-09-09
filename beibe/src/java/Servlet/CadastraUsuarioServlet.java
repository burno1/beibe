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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno F
 */
@WebServlet(name = "CadastraUsuarioServlet", urlPatterns = {"/CadastraUsuarioServlet"})
public class CadastraUsuarioServlet extends HttpServlet {

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

        String nome = "";
        String email = "";
        String senha = "";

        nome = (String) request.getParameter("nome");
        email = (String) request.getParameter("email");
        senha = (String) request.getParameter("senha");

        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario usuarioSalvo = new Usuario();

        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senha);

        usuarioSalvo = uDAO.inserir(usuario);

        if (usuarioSalvo != null) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CadastraUsuarioServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Usuario Cadastrado com Sucesso!</h1>");

                out.println("<table ><tr>\n"
                        + "    <th>Nome</th>\n"
                        + "    <th>Email</th> \n"
                        + "    <th>Senha</th>\n"
                        + "  </tr>");

                out.println("<tr><th>" + nome + "</th><th>" + email + "</th><th>" + senha + "</th></tr>");
                out.println("</table></body>");
                
                out.println("<a href=\'PortalServlet'> Voltar ao Portal</a>");

                out.println("</body>");
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
