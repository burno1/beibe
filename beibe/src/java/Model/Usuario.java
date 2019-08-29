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
public class Usuario {
    private String email;
    private String nome;
    private String senha;
    private String tipo;

    public Usuario(){
        
    }
    public Usuario(String nome, String email, String senha, String tipo){
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
