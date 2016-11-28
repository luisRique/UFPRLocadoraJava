/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;

/**
 *
 * @author luis
 */
public class Automovel extends Veiculo{
        
        private final ModeloAutomovel modeloAutomovel;
        
        public Automovel(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloAutomovel modeloAutomovel) {
                super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
                this.modeloAutomovel = modeloAutomovel;
        }

        public ModeloAutomovel getModeloAutomovel(){
                return this.modeloAutomovel;
        }

        @Override
        public double getValorDiariaLocacao(){
                switch (this.getCategoria()) {
                        case POPULAR:
                                return 100.00;
                        case INTERMEDIARIO:
                                return 300.00;
                        default:
                                return 450.00;
                }
        }
        
}

