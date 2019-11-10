/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;
import DAO.EstadoDAO;
import Model.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Fernandes
 */
public class EstadoService {
    EstadoDAO estadoDAO = new EstadoDAO();
    
    
    public List<Estado> listarTodos(){
    List<Estado> retorno = new ArrayList<Estado>();
    
    retorno = estadoDAO.listarTodosEstados();
    
      return retorno;
    }
    
    
}
