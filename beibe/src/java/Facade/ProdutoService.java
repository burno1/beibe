/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.ProdutoDAO;
import Model.Produto;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class ProdutoService {
    ProdutoDAO dao = new ProdutoDAO();
    
    public boolean inserir(Produto produto){
        return dao.inserir(produto);
        
    }
    
    public boolean remover(String id){
        return dao.remover(id);
    }
    
    public boolean atualizar(Produto produto){
       return dao.atualizar(produto);
    }
    
    public List<Produto> listar(){
        return dao.listar();
    }
    
    public Produto buscar(String id){
        return dao.buscar(id);
    }
    
}
