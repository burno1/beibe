/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factories.ConnectionFactory;
import Model.Cliente;
import Utils.DateConverter;
import static com.sun.xml.bind.util.CalendarConv.formatter;
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
public class ClienteDAO {

    public Cliente buscarCliente(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Cliente cl = new Cliente();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_cliente, cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente FROM beibe.tb_cliente WHERE id_cliente = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                cl.setId(Integer.valueOf(rs.getString("id_cliente")));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome((rs.getString("nome_cliente")));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setData(rs.getDate("data_cliente").toLocalDate());
               // System.out.println(cl.getData().getgetTime() + "iguuu");
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNumero(Integer.valueOf(rs.getString("nr_cliente")));
                cl.setCep(Integer.valueOf(rs.getString("cep_cliente")));
                cl.setCidade(rs.getString("cidade_cliente"));
                cl.setUf(rs.getString("uf_cliente"));
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

    public void removerCliente(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("delete from beibe.tb_cliente where id_cliente = ?");
            st.setInt(1, Integer.valueOf(id));
            st.executeUpdate();

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
            st = con.prepareStatement("SELECT id_cliente, cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente FROM beibe.tb_cliente");
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(Integer.valueOf(rs.getString("id_cliente")));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome((rs.getString("nome_cliente")));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setData(rs.getDate("data_cliente").toLocalDate()); //arrumar no front
                System.out.println(cl.getData());
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

    public void inserirCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement st = null;
        
        LocalDate dt = cliente.getData();
        //java.sql.Date data = new java.sql.Date(dt.getTime());

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "insert into beibe.tb_cliente(cpf_cliente, nome_cliente, email_cliente, data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente, uf_cliente) values (?, ?, ?, ?, ?, ?, ? , ?, ?)");
            st.setString(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getEmail());
            System.out.println("chegando"+cliente.getData());
            st.setDate(4, Date.valueOf(dt));
            st.setString(5, cliente.getRua());
            st.setInt(6, cliente.getNumero());
            st.setInt(7, cliente.getCep());
            st.setString(8, cliente.getCidade());
            st.setString(9, cliente.getUf());
            st.executeUpdate();

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

    public void updateCliente(Cliente cliente) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            System.out.println(cliente.getData()+ "bbbbbb");
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "update beibe.tb_cliente set cpf_cliente = ?, nome_cliente = ?, email_cliente = ?, data_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, cidade_cliente = ?, uf_cliente = ? where id_cliente = ?");
            st.setString(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getEmail());
            st.setDate(4, Date.valueOf(cliente.getData()));
            st.setString(5, cliente.getRua());
            st.setInt(6, cliente.getNumero());
            st.setInt(7, cliente.getCep());
            st.setString(8, cliente.getCidade());
            st.setString(9, cliente.getUf());
            st.setInt(10, cliente.getId());
            st.executeUpdate();

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
