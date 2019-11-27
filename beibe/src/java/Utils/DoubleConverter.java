/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.DecimalFormat;

/**
 *
 * @author Bruno Fernandes
 */
public class DoubleConverter {

    public static double converterDoubleDoisDecimais(double precoDouble) {
        
            DecimalFormat fmt = new DecimalFormat("0.00");
            String string = fmt.format(precoDouble);
            String[] part = string.split("[,]");
            String string2 = part[0] + "." + part[1];
            double preco = Double.parseDouble(string2);
            return preco;
        
        
    }

}
