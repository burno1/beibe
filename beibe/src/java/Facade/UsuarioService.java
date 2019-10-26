/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;


import DAO.UsuarioDAO;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class UsuarioService {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    
    
    public void remover(String id){
    }
    
    public Usuario inserir(Usuario usuario){
        return usuarioDAO.inserir(usuario);
    }
    
    public List<Usuario> listar(){
        return usuarioDAO.buscarTodos();
    }
    
    public Usuario buscar(String email){
        return usuarioDAO.buscarUsuario(email);
    }
}
