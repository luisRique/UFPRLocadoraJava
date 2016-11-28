/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloMotocicleta;

/**
 *
 * @author luis
 */
public class Motocicleta extends Veiculo{
        
        private final ModeloMotocicleta modeloMotocicleta;
        
        public Motocicleta(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloMotocicleta modeloMotocicleta) {
                super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
                this.modeloMotocicleta = modeloMotocicleta;
        }
        
        public ModeloMotocicleta getModeloMotocicleta(){
                return this.modeloMotocicleta;
        }
        
        @Override
        public double getValorDiariaLocacao(){
                switch (this.getCategoria()) {
                        case POPULAR:
                                return 70.00;
                        case INTERMEDIARIO:
                                return 200.00;
                        default:
                                return 350.00;
                }
        }
        
}
