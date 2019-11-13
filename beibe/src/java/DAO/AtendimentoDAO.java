/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Facade.AtendimentoService;
import Facade.CidadeService;
import Factories.ConnectionFactory;
import Model.Atendimento;
import Model.Cidade;
import Model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class AtendimentoDAO {

    

    public Atendimento buscarAtendimento(String id) {
        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        Atendimento atendimento = new Atendimento();

        try {
            //implementar
            while (rs.next()) {

            }
            return atendimento;
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

    public void removerAtendimento(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("delete from beibe.tb_atendimento where id_atendimento = ?");
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

    public List<Atendimento> buscarTodos() {
        List<Atendimento> atendimentos = new ArrayList<Atendimento>();
        Connection con = null;
        con = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //implementar
            return atendimentos;
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

    public void inserirAtendimento(Atendimento atendimento) {
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

    public void atualizar(Atendimento atendimento) {
        Connection con = null;
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("UPDATE tb_atendimento SET"
                    + "dt_hr_atendimento = ?,"
                    + "dsc_atendimento = ?,"
                    + "id_produto = ?,"
                    + "id_tipo_atendimento = ?,"
                    + "id_usuario = ?,"
                    + "id_cliente = ?,"
                    + "res_atendimento = ?"
                    + " WHERE id_atendimento = ?");

            st.setDate(1, Date.valueOf(atendimento.getData()));
            st.setString(2, atendimento.getDescricao());
            st.setInt(3, atendimento.getProduto().getIdProduto());
            st.setInt(4, atendimento.getTipoAtendimento().getIdTipo());
            st.setString(5, atendimento.getUsuario().getId());
            st.setInt(6, atendimento.getCliente().getId());
            st.setInt(7, atendimento.getResolvido());
            st.setString(8, atendimento.getId());

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
