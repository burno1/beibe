/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Bruno Fernandes
 */
public class Atendimento {
    private String id = "";
    private LocalDate data;
    private String dataString;
    private String descricao;
    private Produto produto;
    private TipoAtendimento tipoAtendimento;
    private Funcionario funcionario;
    private Cliente cliente;
    private int resolvido;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getResolvido() {
        return resolvido;
    }

    public void setResolvido(int resolvido) {
        this.resolvido = resolvido;
    }

    public Atendimento(LocalDate data, String descricao, Produto produto, TipoAtendimento tipoAtendimento, Funcionario funcionario, Cliente cliente, int resolvido) {
        this.data = data;
        this.descricao = descricao;
        this.produto = produto;
        this.tipoAtendimento = tipoAtendimento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.resolvido = resolvido;
    }
    
    public Atendimento(){
        
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }
    
    
    
}
