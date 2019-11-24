/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;


import DAO.FuncionarioDAO;
import Exceptions.ErroFuncionario;
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
    
    public Funcionario inserir(Funcionario funcionario) throws ErroFuncionario{
        return funcionarioDAO.inserir(funcionario);
    }
    

    public Funcionario buscar(String email){
        return funcionarioDAO.buscarFuncionario(email);
    }
}
