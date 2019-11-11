/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Model.Atendimento;
import Model.Cliente;
import Model.Produto;
import Model.TipoAtendimento;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class AtendimentoBean {
   private String descricaoAtendimento;
   private Atendimento atendimento;
   private List<Atendimento> atendimentosLista;    
   private List<TipoAtendimento> tiposAtendimento;
   private List<Produto> produtos;
   private Produto produto;
   private Cliente cliente;
   private TipoAtendimento tipoAtendimento;

    public AtendimentoBean() {
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public List<Atendimento> getAtendimentosLista() {
        return atendimentosLista;
    }

    public void setAtendimentosLista(List<Atendimento> atendimentosLista) {
        this.atendimentosLista = atendimentosLista;
    }

    public List<TipoAtendimento> getTiposAtendimento() {
        return tiposAtendimento;
    }

    public void setTiposAtendimento(List<TipoAtendimento> tipoAtendimento) {
        this.tiposAtendimento = tipoAtendimento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente ){
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void setTipoAtendimento(TipoAtendimento tipoAtendimento){
        this.tipoAtendimento = tipoAtendimento;
    }
    
    public TipoAtendimento getTipoAtendimento (){
        return tipoAtendimento;
    }
    
   
   
}
