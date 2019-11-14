/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Bruno Fernandes
 */
public class AppException extends Exception {
    private String msg;
    
    
    public AppException (String msg){
        this.msg = msg;
    }

    public AppException() {
    }
    
    public String getMsg(){
        return msg;
    }
    
    
    
    
}
