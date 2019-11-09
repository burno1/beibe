/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
import Model.Cidade;
import Model.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class CidadesBean {
    private List<Cidade> cidades = null;
    private Estado estado = null;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
        
    
}
