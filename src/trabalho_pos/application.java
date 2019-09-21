/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import trabalho_pos.tp.dao.ConnectionFactory;
import trabalho_pos.tp.ui.TelaInicial;

/**
 *
 * @author leand
 */
public class application {

    public static void main(String[] args) {
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
    }
    
}





        
       
        
//         try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pedidos?useTimezone=true&serverTimezone=UTC&useSSL=false"
//                   ,"root","1234");
//            System.out.println("conectado");               
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//        }
