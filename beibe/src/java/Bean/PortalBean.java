/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Model.TipoAtendimento;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class PortalBean {

    private int quantidadeAtendimentos = 0;
    private int quantidadeAbertos = 0;
    private double porcentagemAbertos = 0.0;
    private List<TipoAtendimento> tiposAtendimento;


    public PortalBean() {

    }

    public int getQuantidadeAtendimentos() {
        return quantidadeAtendimentos;
    }

    public void setQuantidadeAtendimentos(int quantidadeAtendimentos) {
        this.quantidadeAtendimentos = quantidadeAtendimentos;
    }

    public int getQuantidadeAbertos() {
        return quantidadeAbertos;
    }

    public void setQuantidadeAbertos(int quantidadeAbertos) {
        this.quantidadeAbertos = quantidadeAbertos;
    }

    public double getPorcentagemAbertos() {
        return porcentagemAbertos;
    }

    public void setPorcentagemAbertos(double porcentagemAbertos) {
        this.porcentagemAbertos = porcentagemAbertos;
    }

    public List<TipoAtendimento> getTiposAtendimento() {
        return tiposAtendimento;
    }

    public void setTiposAtendimento(List<TipoAtendimento> tiposAtendimento) {
        this.tiposAtendimento = tiposAtendimento;
    }

    
}
