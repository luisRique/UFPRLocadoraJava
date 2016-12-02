/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.ClienteDAO;
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
                //////testa VeiculoDAO
                VeiculoDAO veiculo = new VeiculoDAO();
                Veiculo carro = new Automovel(Marca.VW, Estado.NOVO, null, Categoria.INTERMEDIARIO, 45.000, "asd3343", 2014, ModeloAutomovel.GOLF);
//                veiculo.excluiVeiculo(carro);
//                veiculo.criaVeiculo(carro);
//                veiculo.atualizaVeiculo(carro);
                String classe = carro.getClass().toString();
                String quebrado[] = classe.split("\\.");
                
//                for(Veiculo v : veiculo.selecionaVeiculos()){
//                        System.out.println(v.getPlaca());
//                }
                
                
                /////testeClienteDAO
                ClienteDAO clientedao = new ClienteDAO();
                Cliente cliente = new Cliente("Alzira", "Geni de souza", "0354654813", "01353520017", "Rua Nações Unidas, 999, Piraquara - PR");
                cliente.setIdcliente(4);
//                clientedao.adiciona(cliente);
//                clientedao.atualiza(cliente);
                for(Cliente c : clientedao.selecionaClientes()){
                        System.out.println(c.getNome());
                }
                
                
        }
        
}
