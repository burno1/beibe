/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class Cargo {
    private int id;
    private String nome;
    
    public Cargo (){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
   static public List<Cargo> geraCargos(){
        List<Cargo> retorno = new ArrayList<Cargo>();
        
        retorno.add(new Cargo(1,"Gerente"));
        retorno.add(new Cargo(2,"Funcionario"));
        
        return retorno;
    }
    
    
    
}
