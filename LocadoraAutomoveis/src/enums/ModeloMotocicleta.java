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
public enum ModeloMotocicleta {
        
        CBR500, CG150, CG125, BIS125;       
        
          public static ModeloMotocicleta getModeloMotocicleta(String modeloMotocicleta) {
                List<ModeloMotocicleta> listaMotocicleta = new ArrayList<ModeloMotocicleta>(EnumSet.allOf(ModeloMotocicleta.class));
                for (ModeloMotocicleta mar : listaMotocicleta) {
                        if (mar.name().equals(modeloMotocicleta)) {
                                return mar;
                        }
                }
                return null;
        }
}
