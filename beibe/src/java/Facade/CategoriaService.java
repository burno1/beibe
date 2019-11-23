/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.CategoriaDAO;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class CategoriaService {
    CategoriaDAO dao = new CategoriaDAO();
    
    public boolean inserir(Categoria categoria){
        return dao.inserir(categoria);
        
    }
    
    public boolean remover(String id){
        return dao.remover(id);
    }
    
    public boolean atualizar(Categoria categoria){
       return dao.atualizar(categoria);
    }
    
    public List<Categoria> listar(){
        return dao.listar();
    }
    
    public Categoria buscar(String id){
        return dao.buscar(id);
    }  
}
