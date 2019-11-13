/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Cidade;
import Model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Bruno F
 */
public class CidadeDAO {

    public Cidade buscarCidadePorId(int idCidade) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cidade cl = new Cidade();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT C.id_cidade, C.nome_cidade, E.uf_estado, E.nome_estado FROM tb_cidade C, tb_estado E WHERE C.id_cidade = ? AND C.estado_cidade = E.id_estado;");
            st.setInt(1, idCidade);
            rs = st.executeQuery();
            if (rs.next()) {
                cl.setId(idCidade);
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
    
   

    public List<Cidade> buscarTodosPorEstado(Estado estado) {
        List<Cidade> cidades = new ArrayList<Cidade>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("select c.id_cidade, c.nome_cidade, e.nome_estado, e.uf_estado from tb_cidade c, tb_estado e where c.estado_cidade = e.id_estado and e.uf_estado = ?;");
            st.setString(1, estado.getUf());
            rs = st.executeQuery();
            while (rs.next()) {
                Cidade cl = new Cidade();
                cl.setId(rs.getInt("id_cidade"));
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
