/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.ClienteDAO;
import Exceptions.ErroCliente;
import Model.Cliente;
import java.util.List;
/**
 *
 * @author Bruno Fernandes
 */
public class ClienteService {
    static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static boolean remover(String id) throws ErroCliente{
         return clienteDAO.removerCliente(id);
    }
    
    public static boolean inserir(Cliente cliente) throws ErroCliente{
        return clienteDAO.inserirCliente(cliente);
    }
    
    public static boolean alterar (Cliente cliente) throws ErroCliente{
        return clienteDAO.updateCliente(cliente);
    }
    
    public static  List<Cliente> listar(){
        return clienteDAO.buscarTodos();
        
    }    
    public static  Cliente buscar(String id){
        return clienteDAO.buscarCliente(id);
    }
        
    public static  Cliente buscarPorEmail(String email){
        return clienteDAO.buscarPorEmail(email);
    }
    
}
