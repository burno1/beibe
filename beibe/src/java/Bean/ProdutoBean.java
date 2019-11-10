/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Model.Produto;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class ProdutoBean {
    String nome;
    int idProduto;
    List<Produto> listaProdutos = null;
    
        public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    
}
