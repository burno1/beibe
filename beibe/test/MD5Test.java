/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Factories.ConnectionFactory;
import Utils.MD5;

/**
 *
 * @author Erick Alessi
 */
public class MD5Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionFactory con = new ConnectionFactory();
        System.out.println(MD5.MD5Transformed("senha"));
    }
    
}
