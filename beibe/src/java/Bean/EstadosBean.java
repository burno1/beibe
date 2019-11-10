/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.EstadoDAO;
import Facade.EstadoService;
import Model.Estado;
import java.util.List;

/**
 *
 * @author Erick Alessi
 */
public class EstadosBean {
    List<Estado> estados = null;
    EstadoService estadoService = new EstadoService();
    public List<Estado> getEstados() {
        setEstados((estadoService.listarTodos()));
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
   
    
}
