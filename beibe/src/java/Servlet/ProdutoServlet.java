/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.ProdutoBean;
import DAO.ProdutoDAO;
import Exceptions.AppException;
import Exceptions.ErroProduto;
import Facade.CategoriaService;
import Facade.ProdutoService;
import Model.Produto;
import java.io.IOException;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

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
        String pagina = null;
        ProdutoDAO dao = new ProdutoDAO();
        ProdutoBean prodBean = new ProdutoBean();
        ProdutoService service = new ProdutoService();
        String acao = request.getParameter("action");
        CategoriaService categoriaService = new CategoriaService();

        if (null == acao || "listar".equals(acao)) {
            try {
                prodBean.setListaProdutos(service.listar());

                if (prodBean.getListaProdutos().isEmpty()) {
                    throw new ErroProduto("Não foi possivel carregar atendimentos");
                }
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                rd.forward(request, response);

            } catch (AppException e) {
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);
            }
        }
        if ("show".equals(acao)) {
            try {
                String id = request.getParameter("id");

                Produto produto = service.buscar(id);

                if (produto.getIdProduto() == null) {
                    throw new ErroProduto("Produto Não Encontrado");
                }

                prodBean.setCategorias(categoriaService.listar());
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("./produtosAlterar.jsp");
                request.setAttribute("produto", produto);
                request.setAttribute("produtoBean", prodBean);
                request.setAttribute("mostra", 1);
                rd.forward(request, response);
            } catch (AppException e) {
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }
        }
        if ("formUpdate".equals(acao)) {
            try {
                String id = request.getParameter("id");
                Produto produto = service.buscar(id);

                if (produto.getIdProduto() == null) {
                    throw new ErroProduto("Produto Não Encontrado");
                }
                prodBean.setCategorias(categoriaService.listar());
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("./produtosAlterar.jsp");
                request.setAttribute("produto", produto);
                request.setAttribute("produtoBean", prodBean);

                rd.forward(request, response);
            } catch (AppException e) {
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("remove".equals(acao)) {
            try {
                String id = request.getParameter("id");

                if (!service.remover(id)) {
                    throw new ErroProduto("Impossivel remover produto");
                }

                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                rd.forward(request, response);

            } catch (AppException e) {
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);

            }

        }
        if ("update".equals(acao)) {
            try {
                Produto produto = new Produto();

                String id = request.getParameter("id");

                String idCategoria = request.getParameter("categoria");
                produto.setCategoria(categoriaService.buscar(idCategoria));
                produto.setIdProduto(request.getParameter("id"));
                produto.setDescricao(request.getParameter("descricao"));
                produto.setNomeProduto(request.getParameter("nome"));
                produto.setPeso(Double.parseDouble(request.getParameter("peso")));

                if (!("".equals(id))) {
                    if (!service.atualizar(produto)) {
                        throw new ErroProduto("Erro ao atualizar produto");
                    }

                    prodBean.setListaProdutos(service.listar());
                    RequestDispatcher rd = request.
                            getRequestDispatcher("/produtosListar.jsp");
                    request.setAttribute("produtoBean", prodBean);
                    rd.forward(request, response);

                } else {
                    if (!service.inserir(produto)) {
                        throw new ErroProduto("Erro ao inserir produto");
                    }
                    prodBean.setListaProdutos(service.listar());
                    RequestDispatcher rd = request.
                            getRequestDispatcher("/produtosListar.jsp");
                    request.setAttribute("produtoBean", prodBean);
                    rd.forward(request, response);

                }

            } catch (AppException e) {
                prodBean.setListaProdutos(service.listar());
                RequestDispatcher rd = request.
                        getRequestDispatcher("/produtosListar.jsp");
                request.setAttribute("produtoBean", prodBean);
                request.setAttribute("msg", e.getMsg());
                rd.forward(request, response);
            }
        }
        if ("formNew".equals(acao)) {
            Produto produto = new Produto();

            prodBean.setCategorias(categoriaService.listar());
            request.setAttribute("produtoBean", prodBean);

            RequestDispatcher rd = request.
                    getRequestDispatcher("/produtosAlterar.jsp");
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
