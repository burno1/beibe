/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Produto;
import Model.TipoAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class TipoAtendimentoDAO {

    public List<TipoAtendimento> buscarTodos() {
        
        List<TipoAtendimento> retorno = new ArrayList<TipoAtendimento>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_tipo_atendimento, nome_tipo_atendimento FROM beibe.tb_tipo_atendimento");
            rs = st.executeQuery();
            while (rs.next()) {
                TipoAtendimento tipoAtendimento = new TipoAtendimento();
                tipoAtendimento.setIdTipo(Integer.valueOf(rs.getString("id_tipo_atendimento")));
                
                tipoAtendimento.setNomeTipo((rs.getString("nome_tipo_atendimento")));
                retorno.add(tipoAtendimento);
            }
            return retorno;
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
