/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import bancoDeDados.ConnectionFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class TestaClasses {
        
        public static void main(String[] args){
                ConnectionFactory con = new ConnectionFactory();
                try {
                        con.getConnection();
                } catch (IOException ex) {
                        Logger.getLogger(TestaClasses.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                        Logger.getLogger(TestaClasses.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
}
