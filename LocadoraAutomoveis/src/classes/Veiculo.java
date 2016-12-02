/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import enums.Categoria;
import enums.Estado;
import enums.Marca;
import exceptions.OperacaoNaoPermitidaException;
import java.util.Calendar;
import interfaces.VeiculoI;

/**
 *
 * @author luis
 */
public abstract class Veiculo implements VeiculoI {

        private final Marca marca;
        private Estado estado;
        private Locacao locacao;
        private final Categoria categoria;
        private final double valorDeCompra;
        private final String placa;
        private final int ano;

        public Veiculo(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano) {
                this.marca = marca;
                this.estado = estado;
                if (estado.equals(Estado.LOCADO)) {
                        this.locacao = locacao;
                } else {
                        this.locacao = null;
                }
                this.categoria = categoria;
                this.valorDeCompra = valorDeCompra;
                this.placa = placa.toUpperCase();
                this.ano = ano;
        }

        @Override
        public void locar(int dias, Calendar data, Cliente cliente) throws OperacaoNaoPermitidaException {
               
                switch (this.estado) {
                        case DISPONIVEL:
                                double valor = this.getValorDiariaLocacao();
                                Locacao loca = new Locacao(data, valor, dias, cliente);
                                this.locacao = loca;
                                this.estado = Estado.LOCADO;
                                break;
                        case VENDIDO:
                                throw new OperacaoNaoPermitidaException("Operação não permitida! Veículo já está vendido!");
                        default:
                                throw new OperacaoNaoPermitidaException("Operação não permitida! Veículo já se encontra locado!");
                }
        }

        @Override
        public void vender() throws OperacaoNaoPermitidaException{
                switch (this.estado) {
                        case LOCADO:
                                throw new OperacaoNaoPermitidaException("O veículo encontra-se locado! Só poderá ser vendido assim que for devolvido!");
                        case VENDIDO:
                                throw new OperacaoNaoPermitidaException("O veículo já está vendido! Não há mais como fazer nenhuma operação!");
                        default:
                                this.estado = Estado.VENDIDO;
                                break;
                }
        }

        @Override
        public void devolver() throws OperacaoNaoPermitidaException{
                if(this.estado.equals(Estado.LOCADO)){
                        this.estado = Estado.DISPONIVEL;
                        this.locacao = null;
                }else{
                        throw new OperacaoNaoPermitidaException("O veículo não encontra-se locado para ser devolvido!");
                }
        }

        @Override
        public Estado getEstado() {
                return this.estado;
        }

        @Override
        public Marca getMarca() {
                return this.marca;
        }

        @Override
        public Categoria getCategoria() {
                return this.categoria;
        }

        @Override
        public Locacao getLocacao() {
                return this.locacao;
        }

        @Override
        public String getPlaca() {
                return this.placa;
        }

        @Override
        public int getAno() {
                return this.ano;
        }

        @Override
        public double getValorParaVenda() {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                double valorParaVenda = this.valorDeCompra - (getAno() - year) * 0.15 * this.valorDeCompra;
                if(valorParaVenda < (this.valorDeCompra * 0.1)){
                        valorParaVenda = this.valorDeCompra * 0.1;
                }
                return valorParaVenda;
        }

        @Override
        public abstract double getValorDiariaLocacao();

}
