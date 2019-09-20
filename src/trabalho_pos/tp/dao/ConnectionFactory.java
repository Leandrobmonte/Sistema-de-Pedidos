/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leand
 */
public class ConnectionFactory {
    /**
     * Author Kissy Melo
     @return conexao com o banco
     
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/pedidos?useTimezone=true&serverTimezone=UTC&useSSL=false","root","1234");//"rrw@and14"
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

