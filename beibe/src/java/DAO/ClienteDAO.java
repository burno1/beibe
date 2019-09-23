/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Cliente;
import Model.Usuario;
import Utils.DateConverter;
import Utils.MD5;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno F
 */
public class ClienteDAO {

    Cliente cli = new Cliente();

    public Usuario buscarUsuario(String email) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Usuario u = new Usuario();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT nome_usuario,senha_usuario,login_usuario FROM beibe.tb_usuario where login_usuario = ?");
            st.setString(1, email);
            rs = st.executeQuery();

            while (rs.next()) {
                u.setNome(rs.getString("nome_usuario"));
                u.setSenha(rs.getString("senha_usuario"));
                u.setEmail(rs.getString("login_usuario"));
            }
            return u;
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

    public List<Cliente> buscarTodos() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * FROM beibe.tb_cliente");
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(Integer.valueOf(rs.getString("id_cliente")));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome((rs.getString("nome_cliente")));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setData(DateConverter.converter((rs.getString("data_cliente")))); //arrumar no front
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNumero(Integer.valueOf(rs.getString("nr_cliente")));
                cl.setCep(Integer.valueOf(rs.getString("cep_cliente")));
                cl.setCidade(rs.getString("cidade_cliente"));
                cl.setUf(rs.getString("uf_cliente"));
                clientes.add(cl);
            }
            return clientes;
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

    public Usuario inserir(Usuario usuario) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            Usuario usuarioSalvo = new Usuario();
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "insert into beibe.tb_usuario (login_usuario, nome_usuario,senha_usuario) values (?, ?, ?)");
            st.setString(1, usuario.getEmail());
            st.setString(2, usuario.getNome());
            st.setString(3, usuario.getSenha());
            
            usuarioSalvo = usuario;
            st.executeUpdate();
            
            return usuarioSalvo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
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
