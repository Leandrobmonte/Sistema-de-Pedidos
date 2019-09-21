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
import trabalho_pos.tp.domain.ItemDoPedido;
import trabalho_pos.tp.domain.Produto;

/**
 *
 * @author leand
 */
public class ItemDoPedidoDao {
    
     private Connection connection;
    private PreparedStatement stmtAdiciona;
    
    public ItemDoPedidoDao() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into item_do_pedido (id_pedido, id_produto, qtdade) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
    }
    
    
    
    public void insert(Produto produto, ItemDoPedido item) {
        
    }
    
}
