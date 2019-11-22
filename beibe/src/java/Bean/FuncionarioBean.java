/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Model.Funcionario;
import java.util.List;


/**
 *
 * @author Erick Alessi
 */
public class FuncionarioBean  {

    List<Funcionario> listaFuncionarios = null;
    
    
   
    public FuncionarioBean() {
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> clientesBanco) {
        this.listaFuncionarios = clientesBanco;
    }

    
}
