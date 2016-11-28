/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author luis
 */
public class ConnectionFactory {
        
        
        public Connection getConnection() throws IOException, SQLException{
                try{
                        Properties prop = new Properties();
                        
                        prop.load(getClass().getResourceAsStream("Locadora/bancoDeDados/bancoDeDados.properties"));
                        String dbDriver = prop.getProperty("db.driver");
                        String dbUrl = prop.getProperty("db.url");
                        String dbUser = prop.getProperty("db.user");
                        String dbPwd = prop.getProperty("db.pwd");
                        Class.forName(dbDriver);
                        return DriverManager.getConnection(dbUrl, dbUser,dbPwd);
                        
                }catch(ClassNotFoundException e){
                        throw new RuntimeException(e);
                }catch(IOException e){
                        throw new RuntimeException(e);
                }catch(SQLException e){
                        throw new RuntimeException(e);
                }
        }
        
}
