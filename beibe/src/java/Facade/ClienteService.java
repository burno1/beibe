/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.ClienteDAO;
import Model.Cliente;
import java.util.List;
/**
 *
 * @author Bruno Fernandes
 */
public class ClienteService {
    static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static void remover(String id){
         clienteDAO.removerCliente(id);
    }
    
    public static void inserir(Cliente cliente){
        clienteDAO.inserirCliente(cliente);
    }
    
    public static void alterar (Cliente cliente){
        clienteDAO.updateCliente(cliente);
    }
    
    public static  List<Cliente> listar(){
        return clienteDAO.buscarTodos();
        
    }
    
    public static  Cliente buscar(String id){
        return clienteDAO.buscarCliente(id);
    }
}
