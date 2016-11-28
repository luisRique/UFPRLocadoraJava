/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloVan;

/**
 *
 * @author luis
 */
public class Van extends Veiculo {
        
        private final ModeloVan modeloVan;
        
        public Van(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloVan modeloVan){
                super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
                this.modeloVan = modeloVan;
        }
        
        public ModeloVan getModeloVan(){
                return this.modeloVan;
        }
        
        @Override
        public double getValorDiariaLocacao(){
                switch (this.getCategoria()) {
                        case POPULAR:
                                return 200.00;
                        case INTERMEDIARIO:
                                return 400.00;
                        default:
                                return 600.00;
                }
        }
        
}
