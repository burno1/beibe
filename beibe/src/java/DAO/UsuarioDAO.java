/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno F
 */
public class UsuarioDAO {

    private String id_usuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

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

    public List<Usuario> buscarTodos() {
        List<Usuario> resultados = new ArrayList<Usuario>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * FROM beibe.tb_usuario");
            rs = st.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setEmail(rs.getString("login_usuario"));
                u.setSenha(rs.getString("senha_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                resultados.add(u);
            }
            return resultados;
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
