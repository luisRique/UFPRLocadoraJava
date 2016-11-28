/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Calendar;

/**
 *
 * @author luis
 */
public class Locacao {
        
        private Calendar data;
        private double valor;
        private int dias;
        private Cliente cliente;
        
        public Locacao(Calendar data, double valor, int dias, Cliente cliente){
                this.data = data;
                this.valor = valor;
                this.dias = dias;
                this.cliente = cliente;
        }

        public Calendar getData() {
                return data;
        }

        public double getValor() {
                return valor;
        }

        public int getDias() {
                return dias;
        }

        public Cliente getCliente() {
                return cliente;
        }
        
        
        
}
