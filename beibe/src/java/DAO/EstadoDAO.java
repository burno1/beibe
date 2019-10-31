/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Cidade;
import Model.Cliente;
import Model.Estado;
import Utils.DateConverter;
//import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

/**
 *
 * @author Bruno F
 */
public class EstadoDAO {

    public List<Estado> listarTodosEstados() {
        List<Estado> estados = new ArrayList<Estado>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("select e.nome_estado, e.uf_estado from tb_estado e;");
            rs = st.executeQuery();
            while (rs.next()) {
                Estado e1 = new Estado(rs.getString("nome_estado"), rs.getString("uf_estado"));
                estados.add(e1);
            }
            return estados;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

    }
    
    public int buscarIdEstado(Estado estado) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int id = 0;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("select e.id_estado from tb_estado e where e.uf_estado = ?;");
            st.setString(1, estado.getUf());
            rs = st.executeQuery();       
            if (rs.next()) {
                id = rs.getInt("id_estado");
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

    }
}
