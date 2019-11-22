/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class FuncionarioService {

    static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public boolean remover(String id) {
        return funcionarioDAO.removerFuncionario(id);
    }

    public Funcionario inserir(Funcionario funcionario) {
        return funcionarioDAO.inserir(funcionario);
    }

    public boolean alterar(Funcionario funcionario) {
        return funcionarioDAO.updateFuncionario(funcionario);
    }

    public List<Funcionario> listar(String idUsuarioLogado) {
        return funcionarioDAO.buscarTodos(idUsuarioLogado);
    }

    public Funcionario buscar(String email) {
        return funcionarioDAO.buscarFuncionario(email);
    }

    public Funcionario buscarID(String id) {
        return funcionarioDAO.buscarID(id);
    }
}
