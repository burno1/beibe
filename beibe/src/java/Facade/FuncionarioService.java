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
    
    public static boolean remover(String id){
         return funcionarioDAO.removerFuncionario(id);
    }
    
    public static Funcionario inserir(Funcionario funcionario){
        return funcionarioDAO.inserir(funcionario);
    }
    
    public static boolean alterar (Funcionario funcionario){
        return funcionarioDAO.updateFuncionario(funcionario);
    }
    
    public static  List<Funcionario> listar(){
        return funcionarioDAO.buscarTodos();
        
    }
    
    public static  Funcionario buscar(String id){
        return funcionarioDAO.buscarFuncionario(id);
    }
}

