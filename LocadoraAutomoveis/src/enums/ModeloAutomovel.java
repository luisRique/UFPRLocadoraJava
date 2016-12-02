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
public enum ModeloAutomovel {

        GOL, CELTA, CIVIC, E350, PALIO, GOLF;

        public static ModeloAutomovel getModeloAutomovel(String modeloAutomovel) {
                List<ModeloAutomovel> listaAutomovel = new ArrayList<ModeloAutomovel>(EnumSet.allOf(ModeloAutomovel.class));
                for (ModeloAutomovel auto : listaAutomovel) {
                        if (auto.name().equals(modeloAutomovel)) {
                                return auto;
                        }
                }
                return null;
        }
}
