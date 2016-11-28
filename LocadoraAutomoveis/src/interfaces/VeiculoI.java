/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Locacao;
import classes.Cliente;
import enums.Categoria;
import enums.Estado;
import enums.Marca;
import exceptions.OperacaoNaoPermitidaException;
import java.util.Calendar;

/**
 *
 * @author luis
 */
public interface VeiculoI {
        
        public void locar(int dias, Calendar data, Cliente cliente)throws OperacaoNaoPermitidaException ;
        public void vender()throws OperacaoNaoPermitidaException;
        public void devolver()throws OperacaoNaoPermitidaException;
        public Estado getEstado();
        public Marca getMarca();
        public Categoria getCategoria();
        public Locacao getLocacao();
        public String getPlaca();
        public int getAno();
        public double getValorParaVenda();
        public double getValorDiariaLocacao();
        
        
}
