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
public class LoginService {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    
    
    public void remover(String id){
    }
    
    public Funcionario inserir(Funcionario funcionario){
        return funcionarioDAO.inserir(funcionario);
    }
    
    public List<Funcionario> listar(){
        return funcionarioDAO.buscarTodos();
    }
    
    public Funcionario buscar(String email){
        return funcionarioDAO.buscarFuncionario(email);
    }
}
