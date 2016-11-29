/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.VeiculoDAO;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import enums.ModeloAutomovel;
import java.io.IOException;

/**
 *
 * @author luis
 */
public class TestaClasses {
        
        public static void main(String[] args) throws IOException{
                VeiculoDAO veiculo = new VeiculoDAO();
                Veiculo carro = new Automovel(Marca.VW, Estado.NOVO, null, Categoria.INTERMEDIARIO, 60.000, "AFG5478", 2014, ModeloAutomovel.GOLF);
                veiculo.criaVeiculo(carro);
                String classe = carro.getClass().toString();
                String quebrado[] = classe.split("\\.");
        }
        
}
