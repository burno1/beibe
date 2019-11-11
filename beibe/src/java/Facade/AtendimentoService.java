/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.ProdutoDAO;
import DAO.TipoAtendimentoDAO;
import Model.Atendimento;
import Model.Produto;
import Model.TipoAtendimento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class AtendimentoService {
    TipoAtendimentoDAO tipoProdutoDAO = new TipoAtendimentoDAO();
    ProdutoDAO produtoDao = new ProdutoDAO();
    TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO();
    
    public List<Produto> buscarProdutos(){
        List<Produto> retorno = new ArrayList<Produto>();
        retorno = produtoDao.buscarTodos();
        
        
        return retorno;
    }
    
    public List<TipoAtendimento> buscarTipos(){
    List<TipoAtendimento> retorno = new ArrayList<TipoAtendimento>();
        
    retorno = tipoAtendimentoDAO.buscarTodos();
    return retorno;
    }
    
    public List<Atendimento> listar(){
        List<Atendimento> retorno = new ArrayList<Atendimento>();
        
        
        
        
        return retorno;
    }

    public Atendimento buscar(String id) {
        Atendimento retorno = new Atendimento();
        
        return retorno;
    }
    
    
}
