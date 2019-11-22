/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Facade.CidadeService;
import Factories.ConnectionFactory;
import Model.Cidade;
import Model.Funcionario;
import java.sql.Date;
import Utils.MD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno F
 */
public class FuncionarioDAO {

    public Funcionario buscarFuncionario(String email) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        
        Funcionario u = new Funcionario();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_usuario,nome_usuario,senha_usuario,login_usuario,tipo_usuario FROM tb_usuario where login_usuario = ?");
            st.setString(1, email);
            rs = st.executeQuery();

            while (rs.next()) {
                u.setId(rs.getString("id_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                u.setSenha(rs.getString("senha_usuario"));
                u.setEmail(rs.getString("login_usuario"));
                u.setTipo(rs.getString("tipo_usuario"));
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

    public Funcionario buscarID(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Funcionario u = new Funcionario();
        CidadeService cidadeService = new CidadeService();

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT id_usuario,nome_usuario,senha_usuario,login_usuario,tipo_usuario,cpf,data,rua,nrua,cep,idCidade,idEstado FROM tb_usuario where id_usuario = ?");
            st.setString(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                u.setId(rs.getString("id_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                
                u.setEmail(rs.getString("login_usuario"));
                u.setTipo(rs.getString("tipo_usuario"));
                u.setData(rs.getDate("data").toLocalDate());
                u.setRua(rs.getString("rua"));
                u.setCpf(rs.getString("cpf"));
                u.setNumero(rs.getInt("nrua"));
                u.setCep(rs.getInt("cep"));
                Cidade cidade = cidadeService.buscarPorId(rs.getInt("idCidade"));
                u.setCidade(cidade);
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

    public List<Funcionario> buscarTodos(String idUsuarioLogado) {
        List<Funcionario> resultados = new ArrayList<Funcionario>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * FROM tb_usuario where id_usuario != ?");
            st.setString(1, idUsuarioLogado);
            rs = st.executeQuery();
            while (rs.next()) {
                Funcionario u = new Funcionario();
                u.setEmail(rs.getString("login_usuario"));
                u.setId(rs.getString("id_usuario"));
                u.setSenha(rs.getString("senha_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                u.setTipo(rs.getString("tipo_usuario"));
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

    public Funcionario inserir(Funcionario funcionario) {
        Connection con = null;
        PreparedStatement st = null;
        MD5 md5 = new MD5();
        try {
            Funcionario funcionarioSalvo = new Funcionario();
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "insert into tb_usuario (cpf, nome_usuario, login_usuario,senha_usuario, tipo_usuario, data, rua, nrua, cep, idCidade) values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, funcionario.getCpf());
            st.setString(2, funcionario.getNome());
            st.setString(3, funcionario.getEmail());
            st.setString(4, md5.MD5Transformed(funcionario.getSenha()));
            st.setString(5, funcionario.getTipo());
            st.setDate(6, Date.valueOf(funcionario.getData()));
            st.setString(7, funcionario.getRua());
            st.setInt(8, funcionario.getNumero());
            st.setInt(9, funcionario.getCep());
            st.setInt(10, funcionario.getCidade().getId());

            funcionarioSalvo = funcionario;
            st.executeUpdate();

            return funcionarioSalvo;
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

    public boolean removerFuncionario(String id) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("delete from beibe.tb_usuario where id_usuario = ?");
            st.setInt(1, Integer.valueOf(id));

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

    public boolean updateFuncionario(Funcionario funcionario) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            System.out.println(funcionario.getData() + "bbbbbb");
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement(
                    "update beibe.tb_usuario set cpf = ?, nome_usuario = ?, login_usuario = ?, data = ?, rua = ?, nrua = ?, cep = ?, idCidade = ?, tipo_usuario = ?  where id_usuario = ?");
            st.setString(1, funcionario.getCpf());
            st.setString(2, funcionario.getNome());
            st.setString(3, funcionario.getEmail());
            st.setDate(4, Date.valueOf(funcionario.getData()));
            st.setString(5, funcionario.getRua());
            st.setInt(6, funcionario.getNumero());
            st.setInt(7, funcionario.getCep());
            st.setInt(8, funcionario.getCidade().getId());
            st.setString(9, funcionario.getTipo());
            st.setInt(10, Integer.valueOf(funcionario.getId()));
            int retorno = st.executeUpdate();

            if (retorno == 0) {
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
}
