package Utils;


import Factories.ConnectionFactory;
import Utils.MD5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erick Alessi
 */
public class TestBDConnection {

    public void main(String[] a) {
        ConnectionFactory con = new ConnectionFactory();
        System.out.println(MD5.MD5Transformed("senha"));
    }
}
