/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 *
 * @author luis
 */
public enum Marca {
        VW, GM, HONDA, FORD, MERCEDES, FIAT;
        
          public static Marca getMarca(String marca) {
                List<Marca> listaMarca = new ArrayList<Marca>(EnumSet.allOf(Marca.class));
                for (Marca mar : listaMarca) {
                        if (mar.name().equals(marca)) {
                                return mar;
                        }
                }
                return null;
        }
}
