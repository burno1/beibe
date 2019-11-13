/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import DAO.AtendimentoDAO;
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
    
    ProdutoDAO produtoDao = new ProdutoDAO();
    TipoAtendimentoDAO tipoAtendimentoDAO = new TipoAtendimentoDAO();
    AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
    
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
        retorno = atendimentoDAO.listar();
        
        return retorno;
    }
    
    public void atualizar(Atendimento atendimento){
        atendimentoDAO.atualizar(atendimento);
    }
    
    public void inserir(Atendimento atendimento){
        atendimentoDAO.inserirAtendimento(atendimento);
    }

    public Atendimento buscar(String id) {
        Atendimento retorno;
        
        retorno = atendimentoDAO.buscarAtendimento(id);
        
        return retorno;
    }
    
       public Produto buscarProduto(String id){
        Produto produto = new Produto();
           
        produto = produtoDao.buscar(id);
        return produto;
    }
     
       public TipoAtendimento buscarTipoAtendimento(String id){
           TipoAtendimento tipoAtendimento = new TipoAtendimento();
           
           tipoAtendimento = tipoAtendimentoDAO.buscar(id);
           
           return tipoAtendimento;
       }
       
       public void remover(String id){
           atendimentoDAO.removerAtendimento(id);
       }
       
     
    
    
}
