/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author luis
 */
public class OperacaoNaoPermitidaException extends Exception{
        
        public OperacaoNaoPermitidaException(String mensagem){
        super(mensagem);
    }
        
}
