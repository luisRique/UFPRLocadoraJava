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
public enum Categoria {
        
        POPULAR, INTERMEDIARIO, LUXO;
        
        public static Categoria getCategoria(String categoria) {
                List<Categoria> listaCategoria = new ArrayList<Categoria>(EnumSet.allOf(Categoria.class));
                for (Categoria cate : listaCategoria) {
                        if (cate.name().equals(categoria)) {
                                return cate;
                        }
                }
                return null;
        }
        
}
