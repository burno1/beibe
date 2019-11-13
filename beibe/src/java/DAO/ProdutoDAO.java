/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Cidade;
import Model.Cliente;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Bruno Fernandes
 */
public class ProdutoDAO {
    
    public List<Produto> buscarTodos(){
        List<Produto> retorno = new ArrayList<Produto>();
        
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_produto, nome_produto FROM beibe.tb_produto");
            rs = st.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(Integer.valueOf(rs.getString("id_produto")));
                
                produto.setNomeProduto((rs.getString("nome_produto")));
                retorno.add(produto);
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
    
   public Produto buscar(String id){
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Produto retorno = new Produto();
        
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_produto, nome_produto FROM beibe.tb_produto WHERE id_produto=?");
            st.setString(1, id);
            rs = st.executeQuery();
            
            
            while (rs.next()) {
                
                retorno.setIdProduto(Integer.valueOf(rs.getString("id_produto")));
                retorno.setNomeProduto((rs.getString("nome_produto")));
                
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
