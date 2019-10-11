/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.ClienteBean;
import Bean.PortalBean;
import DAO.ClienteDAO;
import Model.Cliente;
import Utils.DateConverter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
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
 * @author Bruno F
 */
@WebServlet(name = "InserirClienteServlet", urlPatterns = {"/InserirClienteServlet"})
public class InserirClienteServlet extends HttpServlet {

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
            RequestDispatcher rd = request.
                    getRequestDispatcher("/ErroServlet");
            request.setAttribute("msg", "Não vem de hack");
            request.setAttribute("page", "index.jsp");
            rd.forward(request, response);

        }

        java.sql.Date date = null;
        try {
            String sDate1 = request.getParameter("data");

            
            date = Date.valueOf(sDate1);//converting string into sql date  
            
            System.out.println(date + "aaaaaaaaaa");
        } catch (Exception e) {
        }

        Cliente cl = new Cliente();
        cl.setCpf(request.getParameter("cpf"));
        cl.setNome(request.getParameter("nome"));
        cl.setEmail(request.getParameter("email"));
        cl.setData(date);
        cl.setRua(request.getParameter("rua"));
        cl.setNumero(Integer.valueOf(request.getParameter("numero")));
        cl.setCep(Integer.valueOf(request.getParameter("cep")));
        cl.setCidade(request.getParameter("cidade"));
        cl.setUf(request.getParameter("uf"));
        new ClienteDAO().inserirCliente(cl);

        RequestDispatcher rd = request.
                getRequestDispatcher("./clientesListar.jsp");
        request.setAttribute("clienteBean", new ClienteBean());
        rd.forward(request, response);

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
