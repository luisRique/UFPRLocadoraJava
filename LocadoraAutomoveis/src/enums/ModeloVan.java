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
public enum ModeloVan {
        
        SPRINTER, KOMBI;
        
         public static ModeloVan getModeloVan(String modeloVan) {
                List<ModeloVan> listaVan = new ArrayList<ModeloVan>(EnumSet.allOf(ModeloVan.class));
                for (ModeloVan van : listaVan) {
                        if (van.name().equals(modeloVan)) {
                                return van;
                        }
                }
                return null;
        }
        
}
