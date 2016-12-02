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
public enum Estado {
        
        VENDIDO, DISPONIVEL, LOCADO, NOVO;
        
           public static Estado getEstado(String estado) {
                List<Estado> listaEstado = new ArrayList<Estado>(EnumSet.allOf(Estado.class));
                for (Estado est : listaEstado) {
                        if (est.name().equals(estado)) {
                                return est;
                        }
                }
                return null;
        }
        
}
