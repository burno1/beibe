/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Erick Alessi
 */
public class Cidade {

    private int id;
    private String nome;
    private Estado estado;

    public Cidade() {
    }

    public Cidade(int id, String UF) {
        this.id = id;
        this.estado = new Estado("", UF);
    }

    public Cidade(String cidade, String UF) {
        this.nome = cidade;
        this.estado = new Estado("", UF);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
