/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_pos.tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author leand
 */
public class PedidoDao {
    
    private Connection connection;
    private PreparedStatement stmtAdiciona;
    
    public PedidoDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into pedido (data, id_cliente) values (?,?)", Statement.RETURN_GENERATED_KEYS);
    }
    
}
