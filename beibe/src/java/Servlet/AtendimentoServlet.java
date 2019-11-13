/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.AtendimentoBean;
import Bean.ClienteBean;
import Bean.ProdutoBean;
import Facade.AtendimentoService;
import Facade.ClienteService;
import Model.Atendimento;
import Model.Cidade;
import Model.Cliente;
import Model.Produto;
import Model.TipoAtendimento;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "AtendimentoServlet", urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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

        AtendimentoService atendimentoService = new AtendimentoService();
        AtendimentoBean atendimentoBean = new AtendimentoBean();
        ProdutoBean pBean = new ProdutoBean();
        String acao = request.getParameter("action");

        if (null == acao || "listar".equals(acao)) {

            //atendimentoBean.setAtendimentosLista(atendimentoService.listar());
            RequestDispatcher rd = request.
                    getRequestDispatcher("/atendimentoListar.jsp");
            request.setAttribute("atendimentoBean", atendimentoBean);
            rd.forward(request, response);
        }

        if ("show".equals(acao)) {
            String id = request.getParameter("id");
            Atendimento atendimento = atendimentoService.buscar(id);

            RequestDispatcher rd = request.
                    getRequestDispatcher("./atendimento.jsp");
            request.setAttribute("atendimento", atendimento);

            // Implementar para checar a data do atendimento e enviar um dado
            // que será utilizado no jquery para colocar bootstrap na label
            rd.forward(request, response);
        }
        //formulario para novo atendimento
        if ("formNew".equals(acao)) {

            List<Cliente> listaClientes = new ArrayList<Cliente>();

            listaClientes = ClienteService.listar();
            atendimentoBean.setProdutos(atendimentoService.buscarProdutos());
            atendimentoBean.setTiposAtendimento(atendimentoService.buscarTipos());
            atendimentoBean.setClientes(listaClientes);

            Atendimento atendimento = new Atendimento();

            atendimento.setData(LocalDate.now());

            RequestDispatcher rd = request.
                    getRequestDispatcher("/atendimento.jsp");
            request.setAttribute("atendimentoBean", atendimentoBean);
            request.setAttribute("atendimento", atendimento);

            rd.forward(request, response);
        }

        //cadastra no banco novo atendimento
        if ("new".equals(acao)) {

        }

        // Formulario para alteração de novo atendimento só que vazio sem id
        if ("formUpdate".equals(acao)) {
        }
        // Enviado através do alterar por id
        if ("update".equals(acao)) {
            LocalDate data = null;

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String str = request.getParameter("data");   // Data como String

                data = LocalDate.parse(str);

            } catch (Exception e) {

            }

            try {

                Cliente cliente = new Cliente();
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                Produto produto = new Produto();
                Atendimento atendimento = new Atendimento();

                cliente = ClienteService.buscar(request.getParameter("cliente"));
                tipoAtendimento = atendimentoService.buscarTipoAtendimento(request.getParameter("tipoAtendimento"));
                produto = atendimentoService.buscarProduto(request.getParameter("produto"));

                atendimento.setCliente(cliente);
                atendimento.setData(data);
                atendimento.setProduto(produto);
                atendimento.setTipoAtendimento(tipoAtendimento);
                atendimento.setDescricao(request.getParameter("descricao"));

                if ("resolvido".equals(request.getParameter("resolvido"))) {
                    atendimento.setResolvido(1);
                } else {
                    atendimento.setResolvido(0);
                }

                Usuario usuario = new Usuario();
                usuario = (Usuario) s.getAttribute("usuario");
                atendimento.setUsuario(usuario);
                String idAtend = request.getParameter("idAtend");

                if (idAtend != null) {

                    AtendimentoBean ab = new AtendimentoBean();
                    ab.setAtendimentosLista(atendimentoService.listar());
                    RequestDispatcher rd = request.
                            getRequestDispatcher("/atendimentoListar.jsp");
                    request.setAttribute("atendimentoBean", ab);
                    rd.forward(request, response);

                } else {
                       
                    atendimentoService.inserir(atendimento);
                    
                    AtendimentoBean ab = new AtendimentoBean();
                    ab.setAtendimentosLista(atendimentoService.listar());
                    RequestDispatcher rd = request.
                            getRequestDispatcher("/atendimentoListar.jsp");
                    request.setAttribute("atendimentoBean", ab);
                    rd.forward(request, response);
                }

            } catch (Exception e) {
                request.setAttribute("javax.servlet.jsp.jspException", e);
                request.setAttribute("javax.servlet.error.status_code", 500);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
            }
        }
        // remove por id
        if ("remove".equals(acao)) {
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
