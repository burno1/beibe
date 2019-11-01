/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.EstadoDAO;
import Model.Estado;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class EstadosBean {
    List<Estado> estados = null;

    public List<Estado> getEstados() {
        setEstados((new EstadoDAO()).listarTodosEstados());
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
   
    
}
