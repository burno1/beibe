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
public class CidadeDAO {

    public Cidade buscarCidadeId(int idCidade) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cidade cl = new Cidade();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT C.nome_cidade, E.uf_estado, E.nome_estado FROM tb_cidade C, tb_estado E WHERE C.id_cidade = ? AND C.estado_cidade = E.id_estado;");
            st.setInt(1, idCidade);
            rs = st.executeQuery();
            if (rs.next()) {
                cl.setNome(rs.getString("nome_cidade"));
                cl.setEstado(new Estado(rs.getString("nome_estado"), rs.getString("uf_estado")));
            }
            return cl;
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
    
    public int buscarIdCidade(Cidade cidade) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int id = 0;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("select distinct c.id_cidade from tb_cidade c, tb_estado e where c.nome_cidade = ? and c.estado_cidade = (select id_estado from tb_estado where uf_estado = ?);");
            st.setString(1, cidade.getNome());
            st.setString(2, cidade.getEstado().getUf());
            rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_cidade");
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

    public List<Cidade> buscarTodosPorEstado(Estado estado) {
        List<Cidade> cidades = new ArrayList<Cidade>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("select c.nome_cidade, e.nome_estado, e.uf_estado from tb_cidade c, tb_estado e where c.estado_cidade = e.id_estado and e.uf_estado = ?;");
            st.setString(1, estado.getUf());
            rs = st.executeQuery();
            while (rs.next()) {
                Cidade cl = new Cidade();
                cl.setNome(rs.getString("nome_cidade"));
                cl.setEstado(new Estado(rs.getString("nome_estado"), rs.getString("uf_estado")));
                cidades.add(cl);
            }
            return cidades;
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
