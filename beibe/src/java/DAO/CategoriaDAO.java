/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class CategoriaDAO {

    public Categoria buscar(String idCategoria) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Categoria categoria = new Categoria();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id,nome FROM tb_categoria WHERE id = ?");
            st.setString(1, idCategoria);
            rs = st.executeQuery();

            while (rs.next()) {
                categoria.setId(rs.getString("id"));
                categoria.setNome(rs.getString("nome"));
            }
            
            return categoria;
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

    public boolean atualizar(Categoria categoria) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("UPDATE tb_categoria set nome = ? where id = ?");
            st.setString(1, categoria.getNome());
            st.setString(2, categoria.getId());

            int retorno = st.executeUpdate();

            if (retorno == 0) {
                return false;
            }
            return true;

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

     public boolean remover(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("DELETE FROM tb_categoria where id = ?");
            st.setString(1, id);
            

            int retorno = st.executeUpdate();

            if (retorno == 0) {
                return false;
            }
            return true;

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
     
     public boolean inserir(Categoria categoria) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("INSERT INTO tb_categoria (nome) values (?) ");
            st.setString(1, categoria.getNome());

            int retorno = st.executeUpdate();

            if (retorno == 0) {
                return false;
            }
            return true;

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
     
     public List<Categoria> listar() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Categoria> retorno = new ArrayList<Categoria>();
        

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * FROM tb_categoria");
            rs = st.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getString("id"));
                categoria.setNome(rs.getString("nome"));
                
                retorno.add(categoria);
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
