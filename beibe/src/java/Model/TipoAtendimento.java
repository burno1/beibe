/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bruno Fernandes
 */
public class TipoAtendimento {
    private String nomeTipo;
    private int idTipo;
    private int quantidadeAtendimentosAbertos;
    private int quantidadeAtendimentos;

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getQuantidadeAtendimentosAbertos() {
        return quantidadeAtendimentosAbertos;
    }

    public void setQuantidadeAtendimentosAbertos(int quantidadeAtendimentosAbertos) {
        this.quantidadeAtendimentosAbertos = quantidadeAtendimentosAbertos;
    }

    public int getQuantidadeAtendimentos() {
        return quantidadeAtendimentos;
    }

    public void setQuantidadeAtendimentos(int quantidadeAtendimentos) {
        this.quantidadeAtendimentos = quantidadeAtendimentos;
    }
    
    
    
    
}
