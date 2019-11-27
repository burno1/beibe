/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exceptions.ErroCliente;
import Facade.CidadeService;
import Factories.ConnectionFactory;
import Model.Cidade;
import Model.Cliente;
import Utils.MD5;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Bruno F
 */
public class ClienteDAO {

    CidadeService cidadeService = new CidadeService();
    public Cliente buscarCliente(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente cl = new Cliente();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_cliente,senha,cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, id_cidade_cliente FROM beibe.tb_cliente WHERE id_cliente = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                cl.setId(rs.getString("id_cliente"));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome((rs.getString("nome_cliente")));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setSenha((rs.getString("senha")));
                cl.setData(rs.getDate("data_cliente").toLocalDate());
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNumero(Integer.valueOf(rs.getString("nr_cliente")));
                cl.setCep(Integer.valueOf(rs.getString("cep_cliente")));
                Cidade cidade = cidadeService.buscarPorId(rs.getInt("id_cidade_cliente"));
                cl.setCidade(cidade);
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
    
    public Cliente buscarPorEmail(String email) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente cl = new Cliente();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_cliente, cpf_cliente, nome_cliente,senha, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, id_cidade_cliente FROM beibe.tb_cliente WHERE email_cliente = ?");
            st.setString(1, email);
            rs = st.executeQuery();

            while (rs.next()) {
                cl.setId(rs.getString("id_cliente"));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome((rs.getString("nome_cliente")));
                cl.setSenha((rs.getString("senha")));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setData(rs.getDate("data_cliente").toLocalDate());
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNumero(Integer.valueOf(rs.getString("nr_cliente")));
                cl.setCep(Integer.valueOf(rs.getString("cep_cliente")));
                Cidade cidade = cidadeService.buscarPorId(rs.getInt("id_cidade_cliente"));
                cl.setCidade(cidade);
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

    public boolean removerCliente(String id) throws ErroCliente {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("delete from beibe.tb_cliente where id_cliente = ?");
            st.setInt(1, Integer.valueOf(id));
            
            
            int retorno =  st.executeUpdate();
            
            if(retorno == 0){
                return false;
            }
            return true;

        } catch (Exception e) {
            throw new ErroCliente("Cliente não pode ser excluido, verifique atendimentos");
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
            st = con.prepareStatement("SELECT id_cliente, cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, id_cidade_cliente FROM beibe.tb_cliente");
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getString("id_cliente"));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome((rs.getString("nome_cliente")));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setData(rs.getDate("data_cliente").toLocalDate()); 
                System.out.println(cl.getData());
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNumero(Integer.valueOf(rs.getString("nr_cliente")));
                cl.setCep(Integer.valueOf(rs.getString("cep_cliente")));
                Cidade cidade = cidadeService.buscarPorId(rs.getInt("id_cidade_cliente"));
                cl.setCidade(cidade);
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
    
    
    

    public boolean inserirCliente(Cliente cliente) throws ErroCliente {
        Connection con = null;
        PreparedStatement st = null;

        LocalDate dt = cliente.getData();
        MD5 md5 = new MD5();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "insert into beibe.tb_cliente(cpf_cliente, nome_cliente, senha, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, id_cidade_cliente) values (?, ?, ?, ?, ?, ?, ? , ?,?)");
            st.setString(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            st.setString(3, md5.MD5Transformed(cliente.getSenha()));
            st.setString(4, cliente.getEmail());
            st.setDate(5, Date.valueOf(dt));
            st.setString(6, cliente.getRua());
            st.setInt(7, cliente.getNumero());
            st.setInt(8, cliente.getCep());
            st.setInt(9, cliente.getCidade().getId());
            int retorno = st.executeUpdate();
            
            if(retorno == 0){
                return false;
            }
            return true;

        } catch (Exception e) {
            throw new ErroCliente("Não foi possivel inserir o Cliente");
            
        }  finally {
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

    public boolean updateCliente(Cliente cliente) throws ErroCliente {
        Connection con = null;
        PreparedStatement st = null;
        try {
            System.out.println(cliente.getData() + "bbbbbb");
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "update beibe.tb_cliente set cpf_cliente = ?, nome_cliente = ?, email_cliente = ?, data_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, id_cidade_cliente = ? where id_cliente = ?");
            st.setString(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getEmail());
            st.setDate(4, Date.valueOf(cliente.getData()));
            st.setString(5, cliente.getRua());
            st.setInt(6, cliente.getNumero());
            st.setInt(7, cliente.getCep());
            st.setInt(8, cliente.getCidade().getId());
            st.setString(9, cliente.getId());
            int retorno = st.executeUpdate();
            
            if(retorno == 0){
                return false;
            }
            return true;

        } catch (Exception e) {
            throw new ErroCliente("Cliente não pode ser atualizado.");
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
