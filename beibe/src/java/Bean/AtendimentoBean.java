/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.time.temporal.ChronoUnit;
import Model.Atendimento;
import Model.Cliente;
import Model.Produto;
import Model.TipoAtendimento;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class AtendimentoBean {

    private String descricaoAtendimento;
    private List<Atendimento> atendimentosLista;
    private List<Atendimento> atendimentosAbertos;
    private List<TipoAtendimento> tiposAtendimento;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    

    public AtendimentoBean() {
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public List<Atendimento> getAtendimentosLista() {
        return atendimentosLista;
    }

    public void setAtendimentosLista(List<Atendimento> atendimentosLista) {
        
        for (Atendimento atendimento : atendimentosLista) {
            Period period = Period.between( atendimento.getData(),LocalDate.now());
            atendimento.setAtrasado(0);
            if(period.getDays() >= 7 ){
                atendimento.setAtrasado(1);
            }
        }

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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Atendimento> getAtendimentosAbertos() {
        return atendimentosAbertos;
    }

    public void setAtendimentosAbertos(List<Atendimento> atendimentosAbertos) {
        
                
        for (Atendimento atendimento : atendimentosAbertos) {
            Period period = Period.between( atendimento.getData(),LocalDate.now());
            atendimento.setAtrasado(0);
            if(period.getDays() >= 7 ){
                atendimento.setAtrasado(1);
            }
        }

        this.atendimentosAbertos = atendimentosAbertos;
    }
}
