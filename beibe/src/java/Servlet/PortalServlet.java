/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.AtendimentoBean;
import Bean.PortalBean;
import Facade.AtendimentoService;
import Facade.TipoAtendimentoService;
import Model.Atendimento;
import Model.Cliente;

import Model.Funcionario;
import Model.TipoAtendimento;
import Utils.DoubleConverter;
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
        PortalBean pb = new PortalBean();
        HttpSession s = request.getSession();

        Funcionario funcionarioLogado = (Funcionario) s.getAttribute("funcionario");
        Cliente clienteLogado = (Cliente) s.getAttribute("clienteLogado");

        //Condicional de erro para login
        if ("1".equals(funcionarioLogado.getTipo())) {
            AtendimentoBean atendimentoBean = new AtendimentoBean();
            PortalBean portal = new PortalBean();
            AtendimentoService atendimentoService = new AtendimentoService();
            List<TipoAtendimento> tipos = new ArrayList<TipoAtendimento>();
            TipoAtendimentoService tipoService = new TipoAtendimentoService();
            double quantidadeAtendimentos = atendimentoService.quantidadeAtendimentos();
            double quantidadeAbertos = atendimentoService.listarAbertos().size();
            double porcentagemAbertos = ((quantidadeAbertos / quantidadeAtendimentos) * 100);
            
            porcentagemAbertos = DoubleConverter.converterDoubleDoisDecimais(porcentagemAbertos);
            portal.setQuantidadeAbertos((int) quantidadeAbertos);
            portal.setPorcentagemAbertos(porcentagemAbertos);
            portal.setQuantidadeAtendimentos((int) quantidadeAtendimentos);
            portal.setTiposAtendimento(tipoService.buscaTipo());
            
            
            
            RequestDispatcher rd = request.
                    getRequestDispatcher("/portalGerente.jsp");
            request.setAttribute("portalBean", portal);
            rd.forward(request, response);

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
            atendimentosLista = atendimentoService.listarPorCliente(clienteLogado.getId());
            atendimentoBean.setAtendimentosLista(atendimentosLista);

            RequestDispatcher rd = request.
                    getRequestDispatcher("/portal.jsp");
            request.setAttribute("atendimentoBean", atendimentoBean);
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
