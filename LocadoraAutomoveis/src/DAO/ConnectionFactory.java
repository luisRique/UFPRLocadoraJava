/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author caiiqueam
 */
public class ConnectionFactory {
        public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/Locadora", "root", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
