/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.ProdutoDAO;
import DAO.TipoAtendimentoDAO;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class AtendimentoService {
    TipoAtendimentoDAO tipoProdutoDAO = new TipoAtendimentoDAO();
    ProdutoDAO produtoDao = new ProdutoDAO();
    
    public List<Produto> buscarProdutos(){
        List<Produto> retorno = new ArrayList<Produto>();
        retorno = produtoDao.buscarTodos();
        
        
        return retorno;
    }
    
    
}
