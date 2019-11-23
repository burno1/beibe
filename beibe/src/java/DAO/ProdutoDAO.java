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
        CategoriaDAO categoriaDAO = new CategoriaDAO();

    public List<Produto> listar() {
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
                produto.setIdProduto(rs.getString("id_produto"));
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

    public Produto buscar(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        Produto produto = new Produto();
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_produto, nome_produto, categoria, peso ,descricao FROM tb_produto WHERE id_produto = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                produto.setIdProduto(rs.getString("id_produto"));
                produto.setNomeProduto((rs.getString("nome_produto")));
                produto.setCategoria(categoriaDAO.buscar(rs.getString("categoria")));
                produto.setPeso(rs.getDouble("peso"));
                produto.setDescricao(rs.getString("descricao"));

            }
            return produto;
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
    
    public boolean inserir(Produto produto) {
        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = con.prepareStatement("INSERT INTO tb_produto "
                    + "(nome_produto, categoria, peso, descricao) VALUES "
                    + "(?, ?, ?, ?)");
            st.setString(1, produto.getNomeProduto());
            st.setString(2, produto.getCategoria().getId());
            st.setDouble(3, produto.getPeso());
            st.setString(4, produto.getDescricao());

            int retorno = st.executeUpdate();
            
            if (retorno == 0){
            return false;
            }
            
            return true;

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

    public boolean atualizar(Produto produto) {
        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = con.prepareStatement("UPDATE tb_produto SET nome_produto = ?, categoria = ?, peso = ?, descricao = ? WHERE id_produto = ?");
            st.setString(1, produto.getNomeProduto());
            st.setString(2, produto.getCategoria().getId());
            st.setDouble(3, produto.getPeso());
            st.setString(4, produto.getDescricao());
            st.setString(5, produto.getIdProduto());

            int retorno = st.executeUpdate();
            
            if (retorno == 0){
            return false;
            }
            
            return true;

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
    
    public boolean remover(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("DELETE FROM tb_produto where id_produto = ?");
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
}
