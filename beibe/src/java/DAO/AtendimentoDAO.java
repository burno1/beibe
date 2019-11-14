/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Atendimento;
import Model.Cliente;
import Model.Produto;
import Model.TipoAtendimento;
import Model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class AtendimentoDAO {

    public Atendimento buscarAtendimento(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        ProdutoDAO produtoDAO = new ProdutoDAO();
        TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_atendimento, dt_hr_atendimento, dsc_atendimento, id_produto, id_tipo_atendimento, id_usuario, id_cliente, res_atendimento FROM beibe.tb_atendimento WHERE id_atendimento = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            
            Atendimento atendimento = new Atendimento();
            while (rs.next()) {

                Produto produto = produtoDAO.buscar(rs.getString("id_produto"));
                Cliente cliente = clienteDAO.buscarCliente(rs.getString("id_cliente"));

                atendimento.setId(rs.getString("id_atendimento"));
                atendimento.setData(rs.getDate("dt_hr_atendimento").toLocalDate());
                atendimento.setDescricao(rs.getString("dsc_atendimento"));
                
                
                TipoAtendimento tipoAtendimento = tipoAtendimentoDAO.buscar(rs.getString("id_tipo_atendimento"));
                Usuario usuario = usuarioDAO.buscarID(rs.getString("id_usuario"));
                
                atendimento.setProduto(produto);
                atendimento.setTipoAtendimento(tipoAtendimento);
                atendimento.setUsuario(usuario);
                atendimento.setCliente(cliente);
                atendimento.setResolvido(rs.getInt("res_atendimento"));

            }
            return atendimento;
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean removerAtendimento(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("delete from beibe.tb_atendimento where id_atendimento = ?");
            st.setInt(1, Integer.valueOf(id));
            int retorno = st.executeUpdate();
            
            if(retorno == 0){
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

    public boolean inserirAtendimento(Atendimento atendimento) {
        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = con.prepareStatement("INSERT INTO tb_atendimento "
                    + "(dt_hr_atendimento, dsc_atendimento, id_produto, id_tipo_atendimento, id_usuario, id_cliente, res_atendimento) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?)");
            st.setDate(1, Date.valueOf(atendimento.getData()));
            st.setString(2, atendimento.getDescricao());
            st.setInt(3, atendimento.getProduto().getIdProduto());
            st.setInt(4, atendimento.getTipoAtendimento().getIdTipo());
            st.setString(5, atendimento.getUsuario().getId());
            st.setInt(6, atendimento.getCliente().getId());
            st.setInt(7, atendimento.getResolvido());

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

    public boolean atualizar(Atendimento atendimento) {
        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("UPDATE tb_atendimento SET"
                    + " dt_hr_atendimento = ?, "
                    + " dsc_atendimento = ?, "
                    + " id_produto = ?, "
                    + " id_tipo_atendimento = ?, "
                    + " id_usuario = ?, "
                    + " id_cliente = ?, "
                    + " res_atendimento = ? "
                    + " WHERE id_atendimento = ? ");

            st.setDate(1, Date.valueOf(atendimento.getData()));
            st.setString(2, atendimento.getDescricao());
            st.setInt(3, atendimento.getProduto().getIdProduto());
            st.setInt(4, atendimento.getTipoAtendimento().getIdTipo());
            st.setString(5, atendimento.getUsuario().getId());
            st.setInt(6, atendimento.getCliente().getId());
            st.setInt(7, atendimento.getResolvido());
            st.setString(8, atendimento.getId());
            
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

    public List<Atendimento> listar() {

        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Atendimento> retorno = new ArrayList<Atendimento>();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            st = con.prepareStatement("SELECT id_atendimento, dt_hr_atendimento,  id_produto, id_cliente from tb_atendimento");
            rs = st.executeQuery();

            while (rs.next()) {

                Produto produto = produtoDAO.buscar(rs.getString("id_produto"));
                Cliente cliente = clienteDAO.buscarCliente(rs.getString("id_cliente"));

                Atendimento atendimento = new Atendimento();
                atendimento.setId(rs.getString("id_atendimento"));
                atendimento.setData(rs.getDate("dt_hr_atendimento").toLocalDate());
                
                LocalDate data;
                data = rs.getDate("dt_hr_atendimento").toLocalDate();
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                atendimento.setDataString(data.format(formatter));
                
                
                atendimento.setProduto(produto);
                atendimento.setCliente(cliente);

                retorno.add(atendimento);
            }
            return retorno;

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
