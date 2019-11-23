/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.CategoriaBean;
import DAO.CategoriaDAO;
import Exceptions.AppException;
import Exceptions.ErroCategoria;
import Facade.CategoriaService;
import Model.Categoria;
import java.io.IOException;
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
@WebServlet(name = "CategoriaServlet", urlPatterns = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

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

        CategoriaDAO dao = new CategoriaDAO();
        CategoriaBean cbean = new CategoriaBean();
        CategoriaService service = new CategoriaService();
        String acao = request.getParameter("action");

        if (null == acao || "listar".equals(acao)) {
            try {
                cbean.setCategorias(service.listar());

                if (cbean.getCategorias().isEmpty()) {
                    throw new ErroCategoria("Não foi possivel carregar atendimentos");
                }
                RequestDispatcher rd = request.
                        getRequestDispatcher("/categoriaListar.jsp");
                request.setAttribute("categoriaBean", cbean);
                rd.forward(request, response);

            } catch (AppException e) {
                RequestDispatcher rd = request.
                        getRequestDispatcher("/categoriaListar.jsp");
                request.setAttribute("msg", e.getMsg());
                request.setAttribute("categoriaBean", cbean);
                rd.forward(request, response);
            }
        }
        if ("show".equals(acao)) {
            try {
                String id = request.getParameter("id");

                Categoria categoria = service.buscar(id);

                if (categoria.getId() == null) {
                    throw new ErroCategoria("Categoria Não Encontrado");
                }

                cbean.setCategorias(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("./categoriaListar.jsp");
                request.setAttribute("categoria", categoria);
                request.setAttribute("categoriaBean", cbean);
                request.setAttribute("mostra", 1);
                rd.forward(request, response);
            } catch (AppException e) {

            }
        }
        if ("formUpdate".equals(acao)) {
            try {

                //request.setAttribute("atualiza", 1);
                String id = request.getParameter("id");
                Categoria categoria = service.buscar(id);

                if (categoria.getId() == null) {
                    throw new ErroCategoria("Categoria Não Encontrado");
                }

                cbean.setCategorias(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("./categoriaListar.jsp");
                request.setAttribute("categoria", categoria);
                request.setAttribute("categoriaBean", cbean);
                request.setAttribute("atualiza", 1);
                rd.forward(request, response);
            } catch (AppException e) {

            }

        }
        if ("remove".equals(acao)) {
            try {
                String id = request.getParameter("id");

                if (!service.remover(id)) {
                    throw new ErroCategoria("Impossivel remover categoria");
                }

                cbean.setCategorias(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/categoriaListar.jsp");
                request.setAttribute("categoriaBean", cbean);
                rd.forward(request, response);

            } catch (AppException e) {
                cbean.setCategorias(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/categoriaListar.jsp");
                request.setAttribute("categoriaBean", cbean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("update".equals(acao)) {
            try {
                Categoria categoria = new Categoria();

                categoria.setNome(request.getParameter("nome"));
                categoria.setId(request.getParameter("id"));
                String id = request.getParameter("id");

                if (!("".equals(id))) {
                    if (!service.atualizar(categoria)) {
                        throw new ErroCategoria("Erro ao atualizar categoria");
                    }

                    cbean.setCategorias(service.listar());
                    RequestDispatcher rd = request.
                            getRequestDispatcher("/categoriaListar.jsp");
                    request.setAttribute("categoriaBean", cbean);
                    rd.forward(request, response);

                } else {
                    if (!service.inserir(categoria)) {
                        throw new ErroCategoria("Erro ao inserir categoria");
                    }
                    cbean.setCategorias(service.listar());
                    RequestDispatcher rd = request.
                            getRequestDispatcher("/categoriaListar.jsp");
                    request.setAttribute("categoriaBean", cbean);
                    rd.forward(request, response);

                }

            } catch (AppException e) {
            }
        }
        if ("formNew".equals(acao)) {
            Categoria categoria = new Categoria();

            RequestDispatcher rd = request.
                    getRequestDispatcher("/categoria.jsp");
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
